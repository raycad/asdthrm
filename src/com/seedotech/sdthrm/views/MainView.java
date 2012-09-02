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
import com.seedotech.sdthrm.models.Staff;
import com.seedotech.sdthrm.models.StaffModel;

public class MainView extends SdtView {
	private ListView mStaffListView = null;
	private StaffAdapter mStaffAdapter = null;
	
	public MainView(MainActivity activity) {
		super(activity);
	}

	@Override
	public boolean initUI() {
		MainActivity mainActivity = (MainActivity)this.mActivity;
		this.mStaffListView = (ListView)mainActivity.findViewById(R.id.staff_list_view);
		
		/* create an adapter */
		this.mStaffAdapter = new StaffAdapter(this.mActivity);
    	// set the list's adapter
		this.mStaffListView.setAdapter(this.mStaffAdapter);
    	
		StaffModel staffModel = new StaffModel();
		String idCard = "";
		for (int i = 0; i < 30; i++) {
			idCard.format("%d", i);
			Staff staff = new Staff(i, idCard, "Staff" + i, "Test", "Test");
			staffModel.add(staff);
		}
		this.mStaffAdapter.setStaffModel(staffModel);
		
		this.mStaffAdapter.setCallback(new StaffAdapter.Callback() {			
			@Override
			public void onItemClicked(Staff staff) {
				Toast.makeText(mActivity,
						staff.getName(), Toast.LENGTH_LONG).show();
			}
		});
		
		return true;
	}
}
