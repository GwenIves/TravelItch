package com.foundry.app.stockton.travelitchbase;

import java.io.Serializable;
import java.util.Comparator;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

public class Stamp implements Serializable {
	public static final long serialVersionUID = 1;
	
	public static final int FEATURE_SIGHTS = 1;
	public static final int FEATURE_OUTDOOR = 2;
	
	public static final int FEATURE_CITY = 4;
	public static final int FEATURE_CAPITAL = 8;
	public static final int FEATURE_WHS = 16;
	public static final int FEATURE_MOUNTAIN = 32;

	public static final int F_CITY = FEATURE_SIGHTS | FEATURE_CITY;
	public static final int F_CAP = FEATURE_SIGHTS | FEATURE_CITY | FEATURE_CAPITAL;
	public static final int F_C_WHS = FEATURE_SIGHTS | FEATURE_WHS;
	public static final int F_N_WHS = FEATURE_OUTDOOR | FEATURE_WHS;
	public static final int F_MNT = FEATURE_OUTDOOR | FEATURE_MOUNTAIN;
	
	private static final String mIconDir = "icons/";
	
	private int mId;
	private int mName;
	private int mDescription;
	private String mIconFilename;
	private int mCountry;
	private int mContinent;
	private int mFeatures;
	private LatLng mCoordinates;
	private int mRadiusMeters;
	private int mWeight;
	private boolean mVisited;
	
	public static Comparator<Stamp> getByLatComparator () {
		return new Comparator<Stamp> () {
			
			@Override
			public int compare(Stamp lhs, Stamp rhs) {
				if (lhs.getLatitude() <= rhs.getLatitude())
					return -1;
				else
					return 1;
			}
		};
	}
	
	public static Comparator<Stamp> getByNameComparator (final Context context) {
		return new Comparator<Stamp> () {
			
			@Override
			public int compare(Stamp lhs, Stamp rhs) {
				String lhsString = context.getString(lhs.getName());
				String rhsString = context.getString(rhs.getName());

				return lhsString.compareTo(rhsString);
			}
		};
	}
	
	public Stamp (int id, int name, int description, int country, int continent, int features, double lat, double lon, int radius, int weight, String icon) {
		mId = id;
		mName = name;
		mDescription = description;
		mCountry = country;
		mContinent = continent;
		mFeatures = features;
		mCoordinates = new LatLng (lat, lon);
		mRadiusMeters = radius;
		mVisited = false;
		mWeight = weight;
		mIconFilename = icon;
	}

	public LatLng getCoordinates() {
		return mCoordinates;
	}
	
	public double getLatitude () {
		return mCoordinates.latitude;
	}
	
	public double getLongitude () {
		return mCoordinates.longitude;
	}

	public int getRadiusMeters() {
		return mRadiusMeters;
	}

	public int getId() {
		return mId;
	}

	public int getName() {
		return mName;
	}

	public boolean isVisited() {
		return mVisited;
	}

	public void setVisited(boolean visited) {
		mVisited = visited;
	}

	public int getWeight() {
		return mWeight;
	}

	public int getDescription() {
		return mDescription;
	}

	public String getIconFilename() {
		return mIconDir + mIconFilename + ".jpg";
	}

	public int getCountry() {
		return mCountry;
	}
}