/**
 * File MainActivity.java
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

import com.seedotech.sdthrm.common.Common;
import com.seedotech.sdthrm.rest.RestClient;
import com.seedotech.sdthrm.rest.RestUtils;
import com.seedotech.sdthrm.views.MainView;

import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends SdtActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_view);
		
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_view, menu);
		return true;
	}

	@Override
	boolean init() {
		MainView view = new MainView(this);
		setView(view);

		// Initialize UI
		view.initUI();

		// Re-translate UI
		view.retranslateUI();

		// Set login status
		view.updateView();

		return true;
	}
}
