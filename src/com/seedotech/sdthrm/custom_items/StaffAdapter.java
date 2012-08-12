/**
 * File StaffAdapter.java
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
package com.seedotech.sdthrm.custom_items;

import com.seedotech.sdthrm.models.Staff;
import com.seedotech.sdthrm.models.StaffModel;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class StaffAdapter extends BaseAdapter {
	private Activity activity = null;
	private StaffModel staffModel = null;

	private Callback callback = null;
	
	public interface Callback {
		public void onItemClicked(Staff staff);
	}
	
	public void setCallback(Callback callback) {
		this.callback = callback;
	}
	
	public StaffAdapter(Activity activity) {
		super();
		this.activity = activity;
	}
	
	public StaffModel getStaffModel() {
		return staffModel;
	}

	public void setStaffModel(StaffModel staffModel) {
		this.staffModel = staffModel;
	}

	public int getCount() {
		if (staffModel == null)
			return 0;
		return staffModel.count();
    }

    public Object getItem(int position) {
    	if (staffModel == null)
			return null;
		return staffModel.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
    	StaffItemView view = (StaffItemView) convertView;
        Staff staff = staffModel.get(position);
        
        if(convertView == null) {
            view = new StaffItemView(this.activity, null);
            view.setCallback(new StaffItemView.Callback() {				
				@Override
				public void onItemClicked(Staff staff) {
					if (callback != null)
						callback.onItemClicked(staff);
				}
			});
        }
        
        view.setStaff(staff);
        
        // Update item view
        view.updateView();
        
        return view;
    }
}
