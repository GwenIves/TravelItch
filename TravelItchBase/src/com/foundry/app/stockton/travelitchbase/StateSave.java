package com.foundry.app.stockton.travelitchbase;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;


public class StateSave {
	private static final String TAG = "StateSave";
	private static final String PROGRESS_SAVE_KEY = "progressState";
	
	private Set<Integer> mVisitedLocations = new HashSet<Integer> ();
	
	public StateSave (SharedPreferences sp) {
		String encrypted = sp.getString(PROGRESS_SAVE_KEY, "");
		
		loadFromJson (decrypt (encrypted));
	}
	
	public StateSave (byte [] data) {
		if (data == null)
			return;
		
		try {
			loadFromJson(new String (data, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			
		}
	}
	
	public Set<Integer> getVisitedLocations() {
		return mVisitedLocations;
	}

	public boolean unionWith (StateSave other) {
		int countBefore = mVisitedLocations.size();
		
		mVisitedLocations.addAll(other.getVisitedLocations());
		
		return countBefore != mVisitedLocations.size();
	}
	
    public byte[] toBytes() {
    	try {
    		return toString().getBytes("UTF-8");
    	} catch (UnsupportedEncodingException e) {
    		return null;
    	}
    }
    
    @Override
    public String toString() {
   		JSONArray locations = new JSONArray ();
    		
   		for (Integer location : mVisitedLocations)
   			locations.put (location);

   		return locations.toString();
    }
    
    public void loadFromJson(String json) {
    	if (json == null || json.trim().equals(""))
    		return;

    	try {
    		JSONArray locations = (JSONArray) new JSONTokener (json).nextValue();
    		
    		for (int i = 0; i < locations.length(); i++)
    			mVisitedLocations.add(locations.getInt(i));
    	}
    	catch (JSONException ex) {
    		Log.e(TAG, "Save data has a syntax error: " + json, ex);
    	}
    	catch (NumberFormatException ex) {
    		Log.e(TAG, "Save data has an invalid number in it: " + json, ex);
    	}
    }
    
	public void saveLocal (SharedPreferences sp) {
        SharedPreferences.Editor spe = sp.edit();
        spe.putString(PROGRESS_SAVE_KEY, encrypt (toString()));
        spe.commit();
	}
	
	public void visit (int stampId) {
		mVisitedLocations.add (stampId);
	}
	
	private byte[] getSecretKey () {
		return new byte[] {-12, 25, 90, -35, 101, 0, -10, 81, -2, 77, 40, -63, 58, 9, -16, 62};
	}
	
	private String encrypt (String clearText) {
		try {
			SecretKeySpec key = new SecretKeySpec (getSecretKey (), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init (Cipher.ENCRYPT_MODE, key);
			
			byte[] encrypted = cipher.doFinal(clearText.getBytes("UTF-8"));
			return Base64.encodeToString(encrypted, Base64.DEFAULT);
		} catch (GeneralSecurityException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
	
	private String decrypt (String encryptedText) {
		try {
			SecretKeySpec key = new SecretKeySpec (getSecretKey (), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			
			byte[] decrypted = cipher.doFinal(Base64.decode(encryptedText, Base64.DEFAULT));
			
			return new String (decrypted, "UTF-8");
		} catch (GeneralSecurityException e) {
			return null;
		} catch (UnsupportedEncodingException e) {
			return null;
		} catch (IllegalArgumentException e) {
			return null;
		}
	}
}
