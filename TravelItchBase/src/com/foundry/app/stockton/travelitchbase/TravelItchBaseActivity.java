package com.foundry.app.stockton.travelitchbase;

import java.io.File;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appstate.AppStateClient;
import com.google.android.gms.appstate.OnStateLoadedListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.example.games.basegameutils.BaseGameActivity;

public class TravelItchBaseActivity extends BaseGameActivity
		implements OnStateLoadedListener, MainMenuFragment.Listener, ImagePackDownloaderFragment.TaskCallbacks {
	private static final String STATE_SAVE_FILE = "stateSave";
	private static final String NMEA_RECEIVED = "NMEA_Received";
	private static final String ALREADY_SYNCED = "alreadySynced";
	private static final String ALREADY_DOWNLOAD_CHECKED = "alreadyDownload";
	private static final String ALREADY_LOCATION_WARNED = "alreadyLocationWarned";
	private static final String IMAGE_DOWNLOAD_PROGRESS = "downloadProgress";
	private static final String CONFIG_FILE = "config";
	private static final String IMAGES_REVISION_DOWNLOADED = "images_revision_downloaded";
	private static final String NEWLY_VISITED_STAMP = "newly_visited";
	
	private static final int SLOT_PROGRESS_STATE = 0;
	
	private ProgressDialog mSyncingDialog = null;
	private ProgressDialog mDownloadingDialog = null;
	
	private StampsManager mStampsManager = null;
	private LocationManager mLocationManager = null;
	private LocationListener mLocationListener = null;
	
	private ImagePackDownloaderFragment mDownloadFragment = null;
	private FragmentManager mFragmentManager = null;
	private MainMenuFragment mMainMenuFragment = null;
	private MapFragment mMapFragment = null;
	private StampListFragment mStampListFragment = null;
	
	private UserInfo mUserInfo = null;
	private StateSave mStateSave = null;
	
	private boolean mNMEAReceived = false;
	private boolean mSynced = false;
	private boolean mDownloadChecked = false;
	private boolean mLocationWarned = false;
	private boolean mLiteRun = false;
	private boolean mTestRun = false;
	
	private Location mLastLocation = null;
	
	private int mDownloadProgress = 0;
	
	private Bitmap mPlaceholder = null;
	private Stamp mNewlyVisitedStamp = null;
	private Dialog mVisitedDialog = null;
	
	public TravelItchBaseActivity (boolean lite, boolean test) {
		super (BaseGameActivity.CLIENT_GAMES | BaseGameActivity.CLIENT_APPSTATE);
		
		mLiteRun = lite;
		mTestRun = test;
	}
	
	@TargetApi(11)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mPlaceholder = BitmapFactory.decodeResource(getResources(), R.drawable.ic_location_placeholder);
		
		if (savedInstanceState != null) {
			mNMEAReceived = savedInstanceState.getBoolean(NMEA_RECEIVED, false);
			mSynced = savedInstanceState.getBoolean(ALREADY_SYNCED, false);
			mDownloadChecked = savedInstanceState.getBoolean(ALREADY_DOWNLOAD_CHECKED, false);
			mLocationWarned = savedInstanceState.getBoolean(ALREADY_LOCATION_WARNED, false);
			mDownloadProgress = savedInstanceState.getInt(IMAGE_DOWNLOAD_PROGRESS, 0);
			mNewlyVisitedStamp = (Stamp) savedInstanceState.getSerializable(NEWLY_VISITED_STAMP);
		}
		
		mSyncingDialog = new ProgressDialog(this);
		mSyncingDialog.setCancelable(false);
		mSyncingDialog.setMessage(getString (R.string.syncing));
		
		mDownloadingDialog = new ProgressDialog(this);
		mDownloadingDialog.setCancelable(false);
		mDownloadingDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mDownloadingDialog.setProgress(mDownloadProgress);
		mDownloadingDialog.setMessage(getString(R.string.downloading));
				
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
			mDownloadingDialog.setProgressNumberFormat(null);
		
		mLocationManager = (LocationManager) getApplicationContext ().getSystemService(Context.LOCATION_SERVICE);
		mFragmentManager = getSupportFragmentManager ();
		mStampsManager = StampsManager.get(this);
		
		mLocationListener = new LocationListener ();
		
		if (isSignedIn ()) {
			mUserInfo = new UserInfo (this, getGamesClient().getCurrentPlayer());
		} else {
			mUserInfo = new UserInfo (this, null);
		}

		mStateSave = new StateSave (getSharedPreferences (STATE_SAVE_FILE, Context.MODE_PRIVATE));
		mStampsManager.updateState(mStateSave);
		
		mMainMenuFragment = (MainMenuFragment) mFragmentManager.findFragmentByTag("MainMenu");
		if (mMainMenuFragment == null)
			mMainMenuFragment = new MainMenuFragment ();

		mMapFragment = (MapFragment) mFragmentManager.findFragmentByTag("Map");
		if (mMapFragment == null)
			mMapFragment = new MapFragment ();

		mStampListFragment = (StampListFragment) mFragmentManager.findFragmentByTag("StampList");
		if (mStampListFragment == null)
			mStampListFragment = new StampListFragment ();
		
		mFragmentManager.executePendingTransactions();
				
		mMainMenuFragment.setListener(this);
		mMainMenuFragment.setUserInfo(mUserInfo);
		
		if (mFragmentManager.findFragmentById(R.id.fragment_container) == null)
			switchFragment (mMainMenuFragment, "MainMenu");
		
		if (mNewlyVisitedStamp != null)
			showVisitPopup(mNewlyVisitedStamp);
	}
	
	@Override
	public boolean onCreateOptionsMenu (Menu menu) {
		getMenuInflater ().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public void onSaveInstanceState (Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		
		savedInstanceState.putBoolean(NMEA_RECEIVED, mNMEAReceived);
		savedInstanceState.putBoolean(ALREADY_SYNCED, mSynced);
		savedInstanceState.putBoolean(ALREADY_DOWNLOAD_CHECKED, mDownloadChecked);
		savedInstanceState.putBoolean(ALREADY_LOCATION_WARNED, mLocationWarned);
		savedInstanceState.putInt(IMAGE_DOWNLOAD_PROGRESS, mDownloadingDialog.getProgress());
		savedInstanceState.putSerializable(NEWLY_VISITED_STAMP, mNewlyVisitedStamp);
	}
	
	@Override
	public void onResume () {
		super.onResume();

		downloadImages ();
		startLocationUpdates ();
	}
	
	@Override
	public void onStop () {
		super.onStop();
		mSyncingDialog.dismiss();
		mDownloadingDialog.dismiss();
	}
	
	@Override
	public void onPause () {
		super.onPause();
		
		stopLocationUpdates ();
	}
	
	@Override
	public void onDestroy () {
		if (mVisitedDialog != null)
			mVisitedDialog.dismiss();
		
		super.onDestroy();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			switchFragment (mMainMenuFragment, "MainMenu");
			return true;
		} else if (item.getItemId() == R.id.menu_legal_notices) {
			Intent i = new Intent(this, LegalNoticesActivity.class);
			startActivity(i);
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
	public boolean onKeyDown (int keyCode, KeyEvent event) {
		switch (keyCode) {
			case KeyEvent.KEYCODE_BACK:
				Fragment activeFragment = mFragmentManager.findFragmentById(R.id.fragment_container);

				if (!activeFragment.getTag().equals("MainMenu")) {
					switchFragment (mMainMenuFragment, "MainMenu");
					return true;
				}
			default:
				return super.onKeyDown(keyCode, event);
		}
	}
	
	
	@Override
	public void onSignInSucceeded () {
		if (!mSynced)
			loadStateFromCloud ();
		
		mUserInfo = new UserInfo (this, getGamesClient().getCurrentPlayer());
		
		mMainMenuFragment.setUserInfo(mUserInfo);
		mMainMenuFragment.setShowSignIn(false);
		mMainMenuFragment.updateUI();
	}
	
	@Override
	public void onSignInFailed () {
		mMainMenuFragment.setShowSignIn(true);
		mMainMenuFragment.updateUI();
	}
		
	@Override
	public void onLeaderboardsDisplayRequested () {
		if (isSignedIn ())
			startActivityForResult (getGamesClient ().getLeaderboardIntent(getString (R.string.leaderboard_most_travelled)), 0);
		else
			showAlert (getString (R.string.leaderboards_not_available));
	}
	
	@Override
	public void onLocationsDisplayRequested () {
		switchFragment (mStampListFragment, "StampList");
	}
	
	@Override
	public void onMapDisplayRequested () {

        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        if (ConnectionResult.SUCCESS == resultCode) {	
    		mMapFragment.setCurrentLocation(mLastLocation);
    		switchFragment (mMapFragment, "Map");
    	} else {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(resultCode, this, -1);
            
            if (dialog != null) {
                ErrorDialogFragment errorFragment = new ErrorDialogFragment();
                errorFragment.setDialog(dialog);
                errorFragment.show(getSupportFragmentManager(), getString(R.string.google_services));
            }
        }
	}
	
	@Override
	public void onSignInRequested () {
		beginUserInitiatedSignIn();
	}
	
	@Override
	public void onSignOutRequested () {
		signOut();
		
		mUserInfo = new UserInfo (this, null);

		mMainMenuFragment.setUserInfo(mUserInfo);
		mMainMenuFragment.setShowSignIn(true);
		mMainMenuFragment.updateUI();
	}
	
	@Override
	public void onStateConflict (int stateKey, String resolvedVersion, byte[] localData, byte[] serverData) {
		StateSave localState = new StateSave (localData);
		StateSave serverState = new StateSave (serverData);
		
		localState.unionWith (serverState);
		
		getAppStateClient().resolveState(this, SLOT_PROGRESS_STATE, resolvedVersion, localState.toBytes());
	}
	
	@Override
	public void onStateLoaded (int statusCode, int stateKey, byte[] localData) {
		mSyncingDialog.dismiss();
		
		switch (statusCode) {
			case AppStateClient.STATUS_OK:
				if (mStateSave.unionWith(new StateSave (localData)))
					mStateSave.saveLocal (getSharedPreferences(STATE_SAVE_FILE, MODE_PRIVATE));
				
				mStampsManager.updateState(mStateSave);
				mMapFragment.updateUI();
				mStampListFragment.updateUI ();
				mMainMenuFragment.updateUI();
				
				updateScores(R.string.leaderboard_most_travelled, mStampsManager.getScore());
				
				mSynced = true;
				break;
			case AppStateClient.STATUS_STATE_KEY_NOT_FOUND:
				mSynced = true;
				break;
			case AppStateClient.STATUS_NETWORK_ERROR_NO_DATA:
				showSimpleAlert(R.string.no_data_warning);
				break;
			case AppStateClient.STATUS_NETWORK_ERROR_STALE_DATA:
				showSimpleAlert(R.string.stale_data_warning);
				break;
			case AppStateClient.STATUS_CLIENT_RECONNECT_REQUIRED:
				reconnectClients(BaseGameActivity.CLIENT_APPSTATE);
				break;
			default:
				showSimpleAlert(R.string.load_error_warning);
				break;
		}
	}
	
	@Override
	public void onImagePackDownloadProgressed (int progress) {
		mDownloadingDialog.setProgress(progress);
	}
	
	@Override
	public void onImagePackDownloadCancelled () {
		showSimpleAlert(R.string.download_cancelled);
		mDownloadingDialog.dismiss();
	}
	
	@Override
	public void onImagePackDownloaded () {
		mDownloadingDialog.dismiss();
		mDownloadChecked = true;
		
		int imagesRevisionDownloaded = getVersion ();
		
		Editor editor = getSharedPreferences(CONFIG_FILE, 0).edit();
		editor.putInt(IMAGES_REVISION_DOWNLOADED, imagesRevisionDownloaded);		
		editor.commit ();
	}
	
	private void switchFragment (Fragment newFragment, String tag) {
		mFragmentManager.beginTransaction().replace(R.id.fragment_container, newFragment, tag).commit ();
	}

	private void saveState () {
		mStateSave.saveLocal (getSharedPreferences(STATE_SAVE_FILE, MODE_PRIVATE));
		
		if (isSignedIn())
			getAppStateClient().updateState(SLOT_PROGRESS_STATE, mStateSave.toBytes());
	}
	
	private void loadStateFromCloud () {
		mSyncingDialog.show();
		getAppStateClient().loadState (this, SLOT_PROGRESS_STATE);
	}
	
	private void showSimpleAlert (int message) {
		new AlertDialog.Builder(this)
		.setMessage(message)
		.setCancelable(true)
		.setPositiveButton(R.string.ok, null)
		.create()
		.show();
	}
	
	private void updateScores (int leaderboard, int score) {
		if (mTestRun)
			return;
		
		getGamesClient().submitScore(getString(leaderboard), score);
	}
	
	private boolean isProviderEnabled (String provider, int errorMessage) {
		if (!mLocationManager.isProviderEnabled(provider) && !mLocationWarned) {
			new AlertDialog.Builder(this)
				.setMessage(errorMessage)
				.setCancelable(false)
				.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						try {
							Intent i = new Intent (android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
							startActivity(i);
						} catch (ActivityNotFoundException e) {
							Toast.makeText(TravelItchBaseActivity.this, R.string.location_settings_not_found, Toast.LENGTH_LONG).show();
						}
					}
				})
				.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel ();
					}
				})
				.create().show();
			
			mLocationWarned = true;
		}
		
		return mLocationManager.isProviderEnabled(provider);
	}

	private void startLocationUpdates () {
		if (!isProviderEnabled (LocationManager.GPS_PROVIDER, R.string.gps_disabled))
			return;
		
		mNMEAReceived = false;
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30 * 1000, 0, mLocationListener);
		
		mLocationManager.addNmeaListener(new NmeaListener() {
			
			@Override
			public void onNmeaReceived(long timestamp, String nmea) {
				mNMEAReceived = true;
				mLocationManager.removeNmeaListener(this);
			}
		});
	}
	
	private void stopLocationUpdates () {
		mLocationManager.removeUpdates(mLocationListener);
	}
	
	private class LocationListener implements android.location.LocationListener {

		@Override
		public void onLocationChanged (Location location) {
			
			mLastLocation = location;
			
			if (!mTestRun && !mNMEAReceived)
				return;

			if (mNewlyVisitedStamp != null)
				return;
			
			if (mLiteRun && mStampsManager.getVisitedLocations() >= 3)
				return;
			
			mNewlyVisitedStamp = mStampsManager.checkStamps (location, mStateSave);
			if (mNewlyVisitedStamp != null) {
				mMapFragment.updateUI();
				mStampListFragment.updateUI();
				mMainMenuFragment.updateUI();
				saveState ();
				
				if (isSignedIn ())
					updateScores(R.string.leaderboard_most_travelled, mStampsManager.getScore());
				
				showVisitPopup (mNewlyVisitedStamp);
			}
		}
		
		@Override
		public void onProviderEnabled (String provider) {

		}
		
		@Override
		public void onProviderDisabled (String provider) {
			if (provider.equals(LocationManager.GPS_PROVIDER) && !mLocationWarned) {
				isProviderEnabled (LocationManager.GPS_PROVIDER, R.string.gps_disabled);
			}
		}
		
		@Override
		public void onStatusChanged (String provider, int status, Bundle extras) {

		}
	}
	
	private void downloadImages () {
		if (mDownloadChecked)
			return;
		
		SharedPreferences config = getSharedPreferences(CONFIG_FILE, 0);
		int imagesRevisionDownloaded = config.getInt(IMAGES_REVISION_DOWNLOADED, 0);
		
		mDownloadFragment = (ImagePackDownloaderFragment) mFragmentManager.findFragmentByTag("Download");
		if (mDownloadFragment == null) {
			mDownloadFragment = new ImagePackDownloaderFragment();
			mFragmentManager.beginTransaction().add(mDownloadFragment, "Download").commit();
			
			mFragmentManager.executePendingTransactions();
		}
		
		if (mDownloadFragment.isRunning()) {
			mDownloadingDialog.show();
		} else if (imagesRevisionDownloaded < getVersion() && isNetworkAvailable() && isExternalStorageWritable()) {
			mDownloadingDialog.show();
			mDownloadFragment.start(imagesRevisionDownloaded);
		}
	}
	
	private int getVersion () {
	    int version = 0;
	    try {
	        PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_META_DATA);
	        version = pInfo.versionCode;
	    } catch (NameNotFoundException e1) {

	    }

	    return version;
	}
	
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}
	
	private boolean isExternalStorageWritable() {
	    String state = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(state)) {
	        return true;
	    }
	    
	    return false;
	}
	
	private void showVisitPopup (Stamp s) {
		mVisitedDialog = new Dialog(this);
		mVisitedDialog.setContentView(R.layout.dialog_visited_location_popup);
		mVisitedDialog.setTitle(R.string.just_visited);
		mVisitedDialog.setCancelable(true);

		TextView nameView = (TextView) mVisitedDialog.findViewById(R.id.popup_dialog_name);
		TextView descView = (TextView) mVisitedDialog.findViewById(R.id.popup_dialog_desc);
		TextView scoreView = (TextView) mVisitedDialog.findViewById(R.id.popup_dialog_score);
		ImageView iconView = (ImageView) mVisitedDialog.findViewById(R.id.popup_dialog_imageview);
		Button shareButton = (Button) mVisitedDialog.findViewById(R.id.popup_dialog_share_button);
		Button dismissButton = (Button) mVisitedDialog.findViewById(R.id.popup_dialog_dismiss_button);
		
		nameView.setText(s.getName());
		descView.setText(s.getDescription());
		scoreView.setText(s.getWeight() + "  " + getResources().getQuantityText(R.plurals.victory_points, s.getWeight()));

        try {
        	File photoFile = new File (getExternalFilesDir(null) + "/" + s.getIconFilename());
        	BitmapWorkerTask.loadBitmap(getResources(), photoFile.getAbsolutePath(), iconView, mPlaceholder, 1);
        } catch (Exception e) {
        	iconView.setImageBitmap(mPlaceholder);
        }
        
        mVisitedDialog.setOnCancelListener(new OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				mNewlyVisitedStamp = null;
			}
		});
        
        dismissButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mNewlyVisitedStamp = null;
				mVisitedDialog.dismiss();
			}
		});
        
        shareButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (mNewlyVisitedStamp != null) {
					Intent sendIntent = new Intent();
					sendIntent.setAction(Intent.ACTION_SEND);

					String name = getString (mNewlyVisitedStamp.getName());
					String country = getString (mNewlyVisitedStamp.getCountry());

					sendIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.scratched));
					sendIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.just_visited_share, name, country));

					sendIntent.setType("text/plain");
					startActivity(Intent.createChooser(sendIntent, getString(R.string.how_share)));
				}
				
				mNewlyVisitedStamp = null;
				mVisitedDialog.dismiss();				
			}
		});
		
		mVisitedDialog.show();
	}
	
    public static class ErrorDialogFragment extends DialogFragment {
        private Dialog mDialog;

        public ErrorDialogFragment() {
            super();
            mDialog = null;
        }

        public void setDialog(Dialog dialog) {
            mDialog = dialog;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return mDialog;
        }
    }
}
