package com.foundry.app.stockton.travelitchbase;

import java.io.File;
import java.util.List;

import com.foundry.app.stockton.travelitchbase.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StampListAdapter extends BaseExpandableListAdapter {

	private Context mContext;
	private Bitmap mPlaceholderBitmap = null;

	private List<StampGroup> mGroupsList;

	public StampListAdapter (Context c, List<StampGroup> groupList) {
		mContext = c.getApplicationContext();
		mPlaceholderBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_location_placeholder);

		mGroupsList = groupList;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return mGroupsList.get(groupPosition).getStamps().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_view_stamp_item, null);
		}

		Stamp stamp = (Stamp) getChild(groupPosition, childPosition);

		TextView stampNameTextView = (TextView) convertView.findViewById(R.id.list_view_stamp_item_name);
		TextView stampDescTextView = (TextView) convertView.findViewById(R.id.list_view_stamp_item_desc);
		TextView stampWeightTextView = (TextView) convertView.findViewById(R.id.list_view_stamp_weight);
		ImageView photoImageView = (ImageView) convertView.findViewById(R.id.list_view_stamp_item_imageview);

		stampNameTextView.setText(stamp.getName());
		stampDescTextView.setText(stamp.getDescription());
		stampWeightTextView.setText("" + stamp.getWeight());

		try {
			File photoFile = new File (mContext.getExternalFilesDir(null) + "/" + stamp.getIconFilename());
			BitmapWorkerTask.loadBitmap(mContext.getResources(), photoFile.getAbsolutePath(), photoImageView, mPlaceholderBitmap, 2);
		} catch (Exception e) {
			photoImageView.setImageBitmap(mPlaceholderBitmap);
		}

		toggleViewState(convertView, stamp.isVisited());

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return mGroupsList.get(groupPosition).getStamps().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return mGroupsList.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return mGroupsList.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_view_stamp_group, null);
		}

		StampGroup group = (StampGroup) getGroup (groupPosition);

		ImageView iconImageView = (ImageView) convertView.findViewById(R.id.list_view_stamp_group_imageview);
		TextView stampNameTextView = (TextView) convertView.findViewById(R.id.list_view_stamp_group_text_view);
		TextView stampEarnedRatioTextView = (TextView) convertView.findViewById(R.id.list_view_stamp_group_earned_ratio);

		iconImageView.setImageResource(group.getIcon());
		stampNameTextView.setText(group.getName());
		stampEarnedRatioTextView.setText(group.getVisitedCount() + "/" + getChildrenCount (groupPosition));

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	private void toggleViewState (View view, boolean enabled) {
		if (view instanceof ViewGroup) {
			ViewGroup group = (ViewGroup) view;

			for (int i = 0; i < group.getChildCount(); i++)
				toggleViewState(group.getChildAt(i), enabled);
		} else {
			if (view instanceof ImageView) {
				ImageView image = (ImageView) view;
				image.setAlpha(enabled ? 255 : 100);
			} else
				view.setEnabled(enabled);
		}
	}
}
