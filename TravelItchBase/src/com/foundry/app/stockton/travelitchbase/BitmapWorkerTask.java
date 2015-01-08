package com.foundry.app.stockton.travelitchbase;

import java.io.File;
import java.lang.ref.WeakReference;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

public class BitmapWorkerTask extends AsyncTask<String, Void, Bitmap> {
	private final WeakReference<ImageView> mImageViewReference;
	private String mFile = null;
	private int mSubSample = 1;

	public BitmapWorkerTask(ImageView imageView, int subSample) {
		mImageViewReference = new WeakReference<ImageView>(imageView);
		mSubSample = subSample;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		mFile = params[0];
		File photoFile = new File (mFile);

		if (photoFile.exists()) {
			final BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = mSubSample;
			return BitmapFactory.decodeFile (photoFile.getAbsolutePath(), options);
		} else {
			return null;
		}
	}

	@Override
	protected void onPostExecute(Bitmap bitmap) {
		if (isCancelled()) {
			bitmap = null;
		}

		if (mImageViewReference != null && bitmap != null) {
			final ImageView imageView = mImageViewReference.get();
			final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

			if (imageView != null && this == bitmapWorkerTask) {
				imageView.setImageBitmap(bitmap);
			}
		}
	}

	public String getFile() {
		return mFile;
	}

	private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
		if (imageView != null) {
			final Drawable drawable = imageView.getDrawable();

			if (drawable instanceof AsyncDrawable) {
				final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
				return asyncDrawable.getBitmapWorkerTask();
			}
		}

		return null;
	}

	private static boolean cancelPotentialWork(String file, ImageView imageView) {
		final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

		if (bitmapWorkerTask != null) {
			final String bitmapFile = bitmapWorkerTask.getFile ();

			if (bitmapFile == null || !bitmapFile.equals(file)) {
				bitmapWorkerTask.cancel(true);
			} else {
				return false;
			}
		}

		return true;
	}

	public static void loadBitmap(Resources res, String file, ImageView imageView, Bitmap placeholder, int samples) {
		if (BitmapWorkerTask.cancelPotentialWork(file, imageView)) {
			final BitmapWorkerTask task = new BitmapWorkerTask(imageView, samples);
			final AsyncDrawable asyncDrawable = new AsyncDrawable(res, placeholder, task);
			imageView.setImageDrawable(asyncDrawable);
			task.execute(file);
		}
	}

	public static class AsyncDrawable extends BitmapDrawable {
		private final WeakReference<BitmapWorkerTask> mBitmapWorkerTaskReference;

		public AsyncDrawable (Resources res, Bitmap bitmap, BitmapWorkerTask bitmapWorkerTask) {
			super(res, bitmap);

			mBitmapWorkerTaskReference = new WeakReference<BitmapWorkerTask>(bitmapWorkerTask);
		}

		public BitmapWorkerTask getBitmapWorkerTask() {
			return mBitmapWorkerTaskReference.get();
		}
	}
}
