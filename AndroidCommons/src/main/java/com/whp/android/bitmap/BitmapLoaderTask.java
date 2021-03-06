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

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Task to be executed to load an image in background
 *
 * Created by walterpalladino on 9/2/16.
 */
public class BitmapLoaderTask extends AsyncTask<Void, Void, Void> {

	private Context context;
	private ImageView imageView;
	private String url;
	private int size;
	private int borderSize;
	private int borderColor;

	/**
	 * Constructor
	 *
	 * @param context
	 * @param imageView
	 * @param url
	 * @param size
	 * @param borderSize
	 * @param borderColor
	 */
	public BitmapLoaderTask (Context context, ImageView imageView, String url, int size, int borderSize, int borderColor) {
		this.context = context;
		this.imageView = imageView;
		this.url = url;
		this.size = size;
		this.borderSize = borderSize;
		this.borderColor = borderColor;
	}


	@Override
	protected Void doInBackground (Void... params) {

		try {
			BitmapManager.loadBitmap (url, imageView,
					size, size, true,
					borderSize, borderColor);
		} catch (Exception e) {
			e.printStackTrace ();
		}
		return null;
	}
}
