/**
 * File MainView.java
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

import android.widget.ListView;
import android.widget.Toast;

import com.seedotech.sdthrm.activities.MainActivity;
import com.seedotech.sdthrm.activities.R;
import com.seedotech.sdthrm.custom_items.StaffAdapter;
import com.seedotech.sdthrm.custom_items.StaffItemView;
import com.seedotech.sdthrm.models.Staff;
import com.seedotech.sdthrm.models.StaffModel;

public class MainView extends SdtView {
	private ListView staffListView = null;
	private StaffAdapter staffAdapter = null;
	
	public MainView(MainActivity activity) {
		super(activity);
	}

	@Override
	public boolean initUI() {
		MainActivity mainActivity = (MainActivity)this.activity;
		this.staffListView = (ListView)mainActivity.findViewById(R.id.staff_list_view);
		
		/* create an adapter */
		this.staffAdapter = new StaffAdapter(this.activity);
    	// set the list's adapter
		this.staffListView.setAdapter(this.staffAdapter);
    	
		StaffModel staffModel = new StaffModel();
		for (int i = 0; i < 30; i++) {
			Staff staff = new Staff(i, i, "Staff" + i, "Test", "Test");
			staffModel.add(staff);
		}
		this.staffAdapter.setStaffModel(staffModel);
		
		this.staffAdapter.setCallback(new StaffAdapter.Callback() {			
			@Override
			public void onItemClicked(Staff staff) {
				Toast.makeText(activity,
						staff.getName(), Toast.LENGTH_LONG).show();
			}
		});
		
		return true;
	}
}
