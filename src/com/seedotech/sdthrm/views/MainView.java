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

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.seedotech.sdthrm.activities.MainActivity;
import com.seedotech.sdthrm.activities.R;
import com.seedotech.sdthrm.custom_items.StaffAdapter;
import com.seedotech.sdthrm.models.Staff;
import com.seedotech.sdthrm.models.StaffModel;
import com.seedotech.sdthrm.rest.HrmService;
import com.seedotech.sdthrm.rest.HrmService.Callback;

public class MainView extends SdtView {
	private ListView mStaffListView = null;
	private StaffAdapter mStaffAdapter = null;

	public MainView(MainActivity activity) {
		super(activity);
	}

	@Override
	public boolean initUI() {
		MainActivity mainActivity = (MainActivity) this.mActivity;
		this.mStaffListView = (ListView) mainActivity.findViewById(R.id.staff_list_view);

		/* create an adapter */
		this.mStaffAdapter = new StaffAdapter(this.mActivity);
		// set the list's adapter
		this.mStaffListView.setAdapter(this.mStaffAdapter);

		this.mStaffAdapter.setCallback(new StaffAdapter.Callback() {			
			@Override
			public void onItemClicked(Staff staff) {
				Toast.makeText(mActivity,
						staff.getName(), Toast.LENGTH_LONG).show();
			}
		});

		ImageButton refreshButton = (ImageButton) mainActivity.findViewById(R.id.refresh_button);
		refreshButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getAllStaffs();
			}
		});
		
		getAllStaffs();
		
		return true;
	}
	
	public void getAllStaffs() {
		HrmService service = new HrmService();
		service.setCallback(new Callback() {
			@Override
			public void onGetAllStaffsDone(StaffModel staffModel) {
				mStaffAdapter.setStaffModel(staffModel);
				// Refresh data
				mStaffAdapter.notifyDataSetChanged();
			}
			
			@Override
			public void onError() {
			}
		});
		
		// Get staff list
		service.requestAllStaffs();
	}
}
