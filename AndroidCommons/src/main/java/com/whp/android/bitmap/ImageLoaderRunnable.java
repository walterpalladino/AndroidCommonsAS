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
import android.widget.ImageView;

/**
 * Created by walterpalladino on 10/12/16.
 */

public class ImageLoaderRunnable implements Runnable {

	private Context context;
	private ImageView imageView;
	private String url;
	private int size;
	private int borderSize;
	private int borderColor;

	public ImageLoaderRunnable (Context context, ImageView imageView, String url, int size, int borderSize, int borderColor) {
		this.context = context;
		this.imageView = imageView;
		this.url = url;
		this.size = size;
		this.borderSize = borderSize;
		this.borderColor = borderColor;
	}

	public void run() {
		try {
			BitmapManager.loadBitmap (url, imageView,
					size, size, true,
					borderSize, borderColor);
		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
}