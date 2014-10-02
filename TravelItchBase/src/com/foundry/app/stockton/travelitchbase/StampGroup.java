package com.foundry.app.stockton.travelitchbase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Context;

public class StampGroup {

	private int mName;
	private int mVisitedCount;
	private int mFeatures;
	private int mIcon;
	private List<Stamp> mStamps;
	
	public static Comparator<StampGroup> getByNameComparator (final Context context) {
		return new Comparator<StampGroup> () {
			
			@Override
			public int compare(StampGroup lhs, StampGroup rhs) {
				String lhsString = context.getString(lhs.getName());
				String rhsString = context.getString(rhs.getName());
				
				return lhsString.compareTo(rhsString);
			}
		};
	}
	
	public StampGroup (int name, int features, int icon) {
		mName = name;
		mFeatures = features;
		mVisitedCount = 0;
		mStamps = new ArrayList<Stamp> ();
		mIcon = icon;
	}
	
	public boolean isFeature (int features) {
		return (mFeatures & features) != 0;
	}

	public int getName() {
		return mName;
	}
	
	public List<Stamp> getStamps() {
		return mStamps;
	}

	public int getVisitedCount() {
		return mVisitedCount;
	}

	public int getIcon() {
		return mIcon;
	}

	public void addStamp (Stamp s) {
		mStamps.add(s);
	}
	
	public void sort (Context context) {
		Collections.sort (mStamps, Stamp.getByNameComparator(context));
	}
	
	public void refreshCounters () {
		mVisitedCount = 0;
		
		for (Stamp s : mStamps)
			if (s.isVisited())
				mVisitedCount++;
	}
}
