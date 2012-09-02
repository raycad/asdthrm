/**
 * File SdtView.java
 *
 * Brief 
 *
 * Copyright of Seedotech Ltd. All rights reserved.
 *
 * Contact: seedotech@gmail.com
 *
 * Author Nguyen Truong Duong (RayCad) <seedotech@gmail.com> 
 *
 * Created at 12:09:32 PM Aug 12, 2012
 * 
 * Any other legal text to be defined later
 */
package com.seedotech.sdthrm.views;

import com.seedotech.sdthrm.activities.SdtActivity;

public abstract class SdtView {
	protected boolean mIsProcessing = false;
	protected SdtActivity mActivity = null;
	
	public SdtView(SdtActivity activity) {
		this.mActivity = activity;
	}
	
	public SdtActivity getActivity() {
		return this.mActivity;
	}
	
	// Create controls, set up connections
	abstract public boolean initUI(); 

	public void retranslateUI() {
		// Supports internationalization 
	}

	public void updateView() {
		// Update view: controls, positions
	}

	public void initData() {
		// Initialize default data
	}

	public boolean isProcessing() {
		return mIsProcessing;
	}

	public void setProcessing(boolean isProcessing) {
		this.mIsProcessing = isProcessing;
	}
}
