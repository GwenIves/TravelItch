package com.foundry.app.stockton.travelitchbase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.foundry.app.stockton.travelitchbase.R;
import com.google.android.gms.common.images.ImageManager;

public class MainMenuFragment extends Fragment implements OnClickListener {

	public interface Listener {
		public void onLocationsDisplayRequested ();
		public void onMapDisplayRequested ();
		public void onLeaderboardsDisplayRequested ();
		public void onSignInRequested ();
		public void onSignOutRequested ();
	}
	
	private StampsManager mStampsManager = null;
	
	private TextView mUserScoreView = null;
	private TextView mVisitedLocationsView = null;
	private TextView mVisitedCountriesView = null;
	private TextView mVisitedContinentsView = null;
	private TextView mUserScoreUnitsView = null;
	private TextView mVisitedLocationsUnitsView = null;
	private TextView mVisitedCountriesUnitsView = null;
	private TextView mVisitedContinentsUnitsView = null;
	private TextView mUsernameView = null;
	private ImageView mUserIconView = null;
	private LinearLayout mSignInBar = null;
	private LinearLayout mSignOutBar = null;
	
	private UserInfo mUserInfo = null;
	private Listener mListener = null;
	private boolean mShowSignIn = true;
	
	private ImageManager mImageManager = null;

	public void setListener (Listener listener) {
		mListener = listener;
	}
	
	public void setShowSignIn (boolean shouldShow) {
		mShowSignIn = shouldShow;
	}
	
	public void setUserInfo (UserInfo info) {
		mUserInfo = info;
	}
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_mainmenu, parent, false);

		mStampsManager = StampsManager.get(getActivity ());
		
		final int[] BUTTONS = new int[] {
				R.id.locations_button,
				R.id.map_button,
				R.id.leaderboards_button,
				R.id.sign_in_button,
				R.id.sign_out_button
		};
		
		for (int button: BUTTONS)
			v.findViewById(button).setOnClickListener(this);
		
		mSignInBar = (LinearLayout) v.findViewById(R.id.sign_in_bar);
		mSignOutBar = (LinearLayout) v.findViewById(R.id.sign_out_bar);
		mUserIconView = (ImageView) v.findViewById(R.id.main_menu_user_photo);
		mUsernameView = (TextView) v.findViewById(R.id.main_menu_user_name);
		mUserScoreView = (TextView) v.findViewById(R.id.main_menu_user_score);
		mVisitedLocationsView = (TextView) v.findViewById(R.id.main_menu_visited_locations);
		mVisitedCountriesView = (TextView) v.findViewById(R.id.main_menu_visited_countries);
		mVisitedContinentsView = (TextView) v.findViewById(R.id.main_menu_visited_regions);
		mUserScoreUnitsView = (TextView) v.findViewById(R.id.main_menu_user_score_units);
		mVisitedLocationsUnitsView = (TextView) v.findViewById(R.id.main_menu_visited_locations_units);
		mVisitedCountriesUnitsView = (TextView) v.findViewById(R.id.main_menu_visited_countries_units);
		mVisitedContinentsUnitsView = (TextView) v.findViewById(R.id.main_menu_visited_regions_units);
		
		setUpActionBar ();
		
		return v;
	}
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mImageManager = ImageManager.create(getActivity().getApplicationContext());
	}
	
	@Override
	public void onStart () {
		super.onStart();
		updateUI ();
	}
	
	public void updateUI () {
		if (getActivity () == null)
			return;

		mSignInBar.setVisibility(mShowSignIn ? View.VISIBLE : View.GONE);
		mSignOutBar.setVisibility(mShowSignIn ? View.GONE : View.VISIBLE);
		
		mUsernameView.setText(mUserInfo.getUsername());
		
		mImageManager.loadImage(mUserIconView, mUserInfo.getIconUri(), R.drawable.ic_user_anonymous_inv);
		
		int score = mStampsManager.getScore();
		int locations = mStampsManager.getVisitedLocations();
		int countries = mStampsManager.getVisitedCountries();
		int continents = mStampsManager.getVisitedContinents();
		
		mUserScoreView.setText(score + "");
		mUserScoreUnitsView.setText(getActivity ().getResources().getQuantityString(R.plurals.points, score));
		mVisitedLocationsView.setText(locations + "/" + mStampsManager.getStamps().size());
		mVisitedLocationsUnitsView.setText(getActivity ().getResources().getQuantityString(R.plurals.locations, locations));
		mVisitedCountriesView.setText(countries + "/" + mStampsManager.getCountries().size());
		mVisitedCountriesUnitsView.setText(getActivity ().getResources().getQuantityString(R.plurals.countries, countries));
		mVisitedContinentsView.setText(continents + "/" + mStampsManager.getContinents().size());
		mVisitedContinentsUnitsView.setText(getActivity ().getResources().getQuantityString(R.plurals.continents, continents));
	}
	
	@Override
	public void onClick (View view) {
		if (view.getId() == R.id.locations_button)
			mListener.onLocationsDisplayRequested();
		else if (view.getId() == R.id.map_button)
			mListener.onMapDisplayRequested();
		else if (view.getId() == R.id.leaderboards_button)
			mListener.onLeaderboardsDisplayRequested();
		else if (view.getId() == R.id.sign_in_button)
			mListener.onSignInRequested();
		else if (view.getId() == R.id.sign_out_button)
			mListener.onSignOutRequested();
	}
	
	private void setUpActionBar () {
		ActionBar bar = ((TravelItchBaseActivity) getActivity()).getSupportActionBar();
		
		bar.setDisplayHomeAsUpEnabled(false);
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		bar.setTitle(R.string.itch);
	}
}
