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
	private Activity mActivity = null;
	private StaffModel mStaffModel = null;

	private Callback mCallback = null;
	
	public interface Callback {
		public void onItemClicked(Staff staff);
	}
	
	public void setCallback(Callback callback) {
		this.mCallback = callback;
	}
	
	public StaffAdapter(Activity activity) {
		super();
		this.mActivity = activity;
	}
	
	public StaffModel getStaffModel() {
		return mStaffModel;
	}

	public void setStaffModel(StaffModel staffModel) {
		this.mStaffModel = staffModel;
	}

	public int getCount() {
		if (mStaffModel == null)
			return 0;
		return mStaffModel.count();
    }

    public Object getItem(int position) {
    	if (mStaffModel == null)
			return null;
		return mStaffModel.get(position);
    }

    public long getItemId(int position) {
        return position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
    	StaffItemView view = (StaffItemView) convertView;
        Staff staff = mStaffModel.get(position);
        
        if(convertView == null) {
            view = new StaffItemView(this.mActivity, null);
            view.setCallback(new StaffItemView.Callback() {				
				@Override
				public void onItemClicked(Staff staff) {
					if (mCallback != null)
						mCallback.onItemClicked(staff);
				}
			});
        }
        
        view.setStaff(staff);
        
        // Update item view
        view.updateView();
        
        return view;
    }
}
