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

package com.whp.android.widget;

import android.widget.ImageView;

/**
 * Created by walterpalladino on 8/30/16.
 *
 * Custom animation to avoid crash becuase of memory problems
 *
 * Not the best performance
 *
 */
public class CustomAnimator {

	private ImageView imgViewFrameAnimation = null;
	private int showQuizIds[] =  null;
	private boolean animatingFrames = false;
	private int delayBetweenFrame = 1;
	private ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;

	public CustomAnimator (ImageView imgViewFrameAnimation, int showQuizIds[], int delayBetweenFrame, ImageView.ScaleType scaleType) {
		this.imgViewFrameAnimation = imgViewFrameAnimation;
		this.showQuizIds = showQuizIds;
		this.delayBetweenFrame = delayBetweenFrame;
		this.scaleType	= scaleType;
	}

	/**
	 * Plays the animation
	 */
	public void playAnimation () {

		if (animatingFrames) {
			return;
		}

		imgViewFrameAnimation.setImageDrawable(null);

		animatingFrames = true;

		playFrame(0);
	}

	/**
	 * Show the frame and if no pending executes the listener
	 *
	 * @param frameNo
	 */
	private void playFrame (final int frameNo){
		imgViewFrameAnimation.postDelayed(new Runnable(){
			public void run() {
				if(frameNo == showQuizIds.length) {
					animatingFrames = false;
					if (mListener != null) {
						mListener.onAnimationCompleted ();
					}
				}
				else {
					imgViewFrameAnimation.setImageResource(showQuizIds[frameNo]);
					imgViewFrameAnimation.setScaleType (scaleType);
					playFrame(frameNo + 1);
				}
			}
		}, delayBetweenFrame);
	}

	public boolean isAnimatingFrames () {

		return animatingFrames;
	}

	/**
	 * Callback to notify the animation was completed
	 */
	public interface CustomAnimatorCallback {
		public void onAnimationCompleted ();
	}

	// Use this instance of the interface to deliver action events
	CustomAnimatorCallback mListener = null;

	public void setListener (CustomAnimatorCallback listener) {
		mListener = listener;
	}
}
