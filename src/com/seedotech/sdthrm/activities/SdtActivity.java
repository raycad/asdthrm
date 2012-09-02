/**
 * File SdtActivity.java
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
package com.seedotech.sdthrm.activities;

import com.seedotech.sdthrm.views.SdtView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

public abstract class SdtActivity extends Activity {
	protected ProgressDialog mIndicatorDlg = null;
	protected SdtView mView = null;

	public void setView(final SdtView view) {
		this.mView = view;
	}
	public SdtView getView() {
		return this.mView;
	}
	
	abstract boolean init();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create the indicator dialog
		mIndicatorDlg = new ProgressDialog(this);
		mIndicatorDlg.setMessage("Loading. Please wait...");
		mIndicatorDlg.setCancelable(false);  
	}

	public void showActivityIndicator(final boolean shown) {
		if (shown == true)
			mIndicatorDlg.show();
		else 
			mIndicatorDlg.dismiss();
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {	
	}
}
