package com.foundry.app.stockton.travelitchbase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import com.foundry.app.stockton.travelitchbase.R;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

public class ImagePackDownloaderFragment extends Fragment {
	private static final int BUFFER_SIZE = 2048;

	public interface TaskCallbacks {
		public void onImagePackDownloadProgressed(int percent);
		public void onImagePackDownloadCancelled();
		public void onImagePackDownloaded();
	}

	private Context mContext = null;
	private TaskCallbacks mCallbacks = null;
	private Task mTask = null;
	private boolean mRunning = false;

	@Override
	public void onAttach (Activity activity) {
		super.onAttach(activity);
		mCallbacks = (TaskCallbacks) activity;
		mContext = activity.getApplicationContext();
	}

	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public void onDestroy () {
		super.onDestroy();
		cancel ();
	}

	public void start (int firstPack) {
		if (!mRunning) {
			mTask = new Task ();
			mTask.execute (firstPack);
			mRunning = true;
		}
	}

	public void cancel () {
		if (mRunning) {
			mTask.cancel (false);
			mTask = null;
			mRunning = false;
		}
	}

	public boolean isRunning () {
		return mRunning;
	}

	private class Task extends AsyncTask<Integer, Integer, Void> {

		private String mTempFileName = null;
		private int mTempFileSize = 0;

		private int mPacksToDownload = 0;
		private int mCurrentPack = 0;
		private int mProgressFrom = 0;
		private int mProgressTo = 0;
		private int mProgressCounter = 0;

		@Override
		protected Void doInBackground (Integer... params) {
			int versionAlreadyDownloaded = params[0];

			String[] ids = mContext.getResources().getStringArray(R.array.image_packs_ids);
			int[] idVersions = mContext.getResources().getIntArray(R.array.image_packs_version_introduced);

			for (int i = 0 ; i < idVersions.length; i++) {
				if (idVersions[i] > versionAlreadyDownloaded)
					mPacksToDownload++;
			}

			for (int i = 0; i < idVersions.length; i++) {
				if (idVersions[i] <= versionAlreadyDownloaded)
					continue;

				setProgressScale ();

				try {
					downloadPack (ids[i]);
					unzipPack ();
				} catch (IOException ioe) {
					cancel (true);
					return null;
				}
			}

			return null;
		}

		@Override
		protected void onProgressUpdate (Integer... percent) {
			if (mCallbacks != null)
				mCallbacks.onImagePackDownloadProgressed(percent[0]);
		}

		@Override
		protected void onCancelled () {
			if (mCallbacks != null)
				mCallbacks.onImagePackDownloadCancelled();

			mContext.deleteFile(mTempFileName);
			mRunning = false;
		}

		@Override
		protected void onPostExecute (Void param) {
			if (mCallbacks != null)
				mCallbacks.onImagePackDownloaded();

			mRunning = false;
		}

		private void setProgressScale () {
			mProgressFrom = mCurrentPack * 100 / mPacksToDownload;
			mCurrentPack++;
			mProgressTo = mCurrentPack * 100 / mPacksToDownload;

			mProgressCounter = 0;
		}

		private void publishPartialProgress (int partialProgress) {
			mProgressCounter++;

			if (mProgressCounter % 50 != 0)
				return;

			int progress = (int) (mProgressFrom + (mProgressTo - mProgressFrom) / 100.0 * partialProgress);
			publishProgress (progress);
		}

		private void downloadPack (String id) throws IOException {
			URL url = new URL("https://docs.google.com/uc?id=" + id);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();

			try {
				mTempFileName = UUID.randomUUID().toString();
				mTempFileSize = connection.getContentLength();
				InputStream in = connection.getInputStream();
				FileOutputStream out = mContext.openFileOutput(mTempFileName, Context.MODE_PRIVATE);

				if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
					throw new IOException ();
				}

				int bytesRead = 0;
				int bytesTotal = 0;
				byte[] buffer = new byte[BUFFER_SIZE];

				while ((bytesRead = in.read(buffer)) > 0) {
					out.write(buffer, 0, bytesRead);

					bytesTotal += bytesRead;
					publishPartialProgress(50 * bytesTotal / mTempFileSize);
				}

				out.close();
			} finally {
				connection.disconnect();
			}
		}

		private void unzipPack () throws IOException {
			ZipInputStream zin = new ZipInputStream(mContext.openFileInput(mTempFileName));
			ZipEntry ze = null;

			int bytesTotal = 0;

			while ((ze = zin.getNextEntry()) != null) {
				if (ze.isDirectory()) {
					checkDirectories(ze.getName());
				} else {
					FileOutputStream fout = new FileOutputStream(mContext.getExternalFilesDir(null) + "/" + ze.getName());

					int bytesRead = 0;
					byte[] buffer = new byte[BUFFER_SIZE];

					while ((bytesRead = zin.read(buffer)) > 0) {
						fout.write(buffer, 0, bytesRead);
						bytesTotal += bytesRead;
					}

					fout.close();
				}

				zin.closeEntry();

				publishPartialProgress(50 + 50 * bytesTotal / mTempFileSize);
			}

			zin.close();
			mContext.deleteFile(mTempFileName);
		}

		private void checkDirectories (String dir) {
			File f = new File(mContext.getExternalFilesDir(null) + "/" + dir);
			f.mkdirs();
		}
	}
}
