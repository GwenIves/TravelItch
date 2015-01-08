package com.foundry.app.stockton.travelitchbase;

import android.content.Context;
import android.net.Uri;

import com.foundry.app.stockton.travelitchbase.R;
import com.google.android.gms.games.Player;

public class UserInfo {
	private Context mContext;

	private String mUsername;
	private Uri mIconUri;

	public UserInfo (Context c, Player p) {
		mContext = c.getApplicationContext();

		mIconUri = null;

		if (p != null) {
			mUsername = p.getDisplayName();

			if (p.hasIconImage())
				mIconUri = p.getIconImageUri();
		} else {
			mUsername = mContext.getString(R.string.anonymous);
		}
	}

	public String getUsername () {
		return mUsername;
	}

	public Uri getIconUri () {
		return mIconUri;
	}

}
