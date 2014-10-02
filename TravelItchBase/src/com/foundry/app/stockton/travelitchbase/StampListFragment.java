package com.foundry.app.stockton.travelitchbase;

import java.util.List;

import com.foundry.app.stockton.travelitchbase.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.OnNavigationListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;

public class StampListFragment extends Fragment {
	private static final String SELECTED_DISPLAY_CATEGORY = "display_category";
	
    ExpandableListView mListView;
    StampListAdapter mListAdapter;
    ActionBar mBar;
    
    private int mSelectedCategory = -1;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_stamp_list, parent, false);

		mListView = (ExpandableListView) v.findViewById(R.id.stamp_list_main);
		mBar = ((TravelItchBaseActivity) getActivity()).getSupportActionBar();
		
		if (savedInstanceState != null) {
			mSelectedCategory = savedInstanceState.getInt(SELECTED_DISPLAY_CATEGORY, 0);
		}
		
        setUpActionBar ();
        setUpAdapter ();

		return v;
	}
	
	@Override
	public void onSaveInstanceState (Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putInt(SELECTED_DISPLAY_CATEGORY, mBar.getSelectedNavigationIndex());
	}
	
	public void updateUI () {
		if (getActivity () == null)
			return;
				
		mListAdapter.notifyDataSetChanged();
	}
	
	private void setUpActionBar () {
		mBar.setDisplayHomeAsUpEnabled(true);
	    mBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
	    mBar.setTitle(R.string.locations);
	      
	    ArrayAdapter<String> adapter = new ArrayAdapter<String> (
	    		getActivity(),
	    		android.R.layout.simple_spinner_dropdown_item,
	    		getActivity().getResources().getStringArray(R.array.stamps_display_categories));

	    mBar.setListNavigationCallbacks(adapter, new OnNavigationListener() {
			
			@Override
			public boolean onNavigationItemSelected(int item, long arg1) {
				if (item != mSelectedCategory) {
					mSelectedCategory = item;
					setUpAdapter();
				}
				
				return true;
			}
		});
	    
	    if (mSelectedCategory != -1) {
    		mBar.setSelectedNavigationItem(mSelectedCategory);
	    }
	}
	
	private void setUpAdapter () {
		StampsManager stampsManager = StampsManager.get(getActivity ());

		List<StampGroup> groupsList = null;

		switch (mBar.getSelectedNavigationIndex()) {
			case (0):
				groupsList = stampsManager.getContinents();
				break;
			case (1):
				groupsList = stampsManager.getCountries();
				break;
			case (2):
				groupsList = stampsManager.getFeatures();
				break;
		}
		
		mListAdapter = new StampListAdapter(getActivity (), groupsList);
        mListView.setAdapter(mListAdapter);
	}
}