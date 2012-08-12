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
	protected ProgressDialog indicatorDlg = null;
	protected SdtView view = null;

	public void setView(final SdtView view) {
		this.view = view;
	}
	public SdtView getView() {
		return this.view;
	}
	
	abstract boolean init();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create the indicator dialog
		indicatorDlg = new ProgressDialog(this);
		indicatorDlg.setMessage("Loading. Please wait...");
		indicatorDlg.setCancelable(false);  
	}

	public void showActivityIndicator(final boolean shown) {
		if (shown == true)
			indicatorDlg.show();
		else 
			indicatorDlg.dismiss();
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {	
	}
}
