/*
 * Copyright 2016 Walter Hugo Palladino
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.whp.android.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Task to be executed to load an image in background
 *
 * Created by walterpalladino on 10/12/16.
 */
public class BitmapLoadAndProcessTask extends AsyncTask<Void, Void, Void> {

	private ImageView imageView;
	private String url;
	private int size;
	private int borderSize;
	private int borderColor;
	private Bitmap bitmap=null;

	/**
	 * Constructor
	 *
	 * @param mListener
	 * @param imageView
	 * @param url
	 * @param size
	 * @param borderSize
	 * @param borderColor
	 */
	public BitmapLoadAndProcessTask (BitmapLoadAndProcessTaskCallback mListener, ImageView imageView, String url, int size, int borderSize, int borderColor) {
		this.mListener = mListener;
		this.imageView = imageView;
		this.url = url;
		this.size = size;
		this.borderSize = borderSize;
		this.borderColor = borderColor;
	}


	@Override
	protected Void doInBackground (Void... params) {

		URL url2 = null;
		try {
			url2 = new URL((url));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}

		try {
			bitmap = BitmapFactory.decodeStream(url2.openConnection().getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	@Override
	public void onPostExecute (Void v) {
		mListener.onBitmapLoadAndProcessCompleted (bitmap, imageView, size, borderSize, borderColor);
	}

	public interface BitmapLoadAndProcessTaskCallback {
		public void onBitmapLoadAndProcessCompleted(Bitmap bitmap, ImageView imageView, int size, int borderSize, int borderColor);
	}

	// Use this instance of the interface to deliver action events
	BitmapLoadAndProcessTaskCallback mListener = null;

}
