package com.foundry.app.stockton.travelitchbase;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foundry.app.stockton.travelitchbase.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends SupportMapFragment {

	private StampsManager mStampsManager = null;

	private GoogleMap mGoogleMap = null;

	private LatLng mCurrentLocation = null;

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = super.onCreateView(inflater, parent, savedInstanceState);

		mStampsManager = StampsManager.get(getActivity ());

		mGoogleMap = getMap ();
		mGoogleMap.setMyLocationEnabled(true);

		setUpActionBar();
		updateUI ();

		return v;
	}

	public void updateUI () {
		if (getActivity () == null)
			return;

		mGoogleMap.clear();

		LatLng focusLatLng = null;

		if (mCurrentLocation != null)
			focusLatLng = mCurrentLocation;
		else {
			LocationManager lm = (LocationManager) getActivity ().getSystemService(Context.LOCATION_SERVICE);
			Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

			if (loc != null)
				focusLatLng = new LatLng(loc.getLatitude(), loc.getLongitude());
			else
				focusLatLng = new LatLng(50,0);
		}

		mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(focusLatLng, 5.0f));

		BitmapDescriptor blueMarker = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE);
		BitmapDescriptor redMarker = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED);

		for (Stamp s : mStampsManager.getStamps()) {
			mGoogleMap.addMarker(new MarkerOptions()
					.position(s.getCoordinates())
					.title(getActivity ().getString(s.getName()))
					.icon (s.isVisited() ? blueMarker : redMarker));
		}
	}

	private void setUpActionBar () {
		ActionBar bar = ((TravelItchBaseActivity) getActivity()).getSupportActionBar();

		bar.setDisplayHomeAsUpEnabled(true);
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		bar.setTitle(R.string.locations);
	}

	public void setCurrentLocation(Location loc) {
		if (loc != null)
			mCurrentLocation = new LatLng (loc.getLatitude(), loc.getLongitude());
	}
}
