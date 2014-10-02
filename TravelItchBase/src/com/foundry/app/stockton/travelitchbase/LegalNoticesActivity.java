package com.foundry.app.stockton.travelitchbase;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.foundry.app.stockton.travelitchbase.R;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class LegalNoticesActivity extends ActionBarActivity {

	private TextView mLegalNotice = null;
	private Button mDismissButton = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_legal_notices);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		mLegalNotice = (TextView) findViewById(R.id.legal_notice);
		mDismissButton = (Button) findViewById(R.id.legal_notice_dismiss_button);
		
		mLegalNotice.setText(GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(this));
		
		mDismissButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish ();
			}
		});
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	 	    case android.R.id.home:
	 	    	NavUtils.navigateUpFromSameTask(this);
	 	    	return true;
	 	    default:
	 	    	return super.onOptionsItemSelected(item);
	    }
	}
}
