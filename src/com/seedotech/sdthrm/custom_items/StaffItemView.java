/**
 * File StaffItemView.java
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

import com.seedotech.sdthrm.activities.R;
import com.seedotech.sdthrm.models.Staff;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StaffItemView extends LinearLayout {
	private ImageView mAvatarImageView = null;
	private TextView mNameTextView = null;
	private Staff mStaff = null;
	
	private Callback mCallback = null;
	
	public interface Callback {
		public void onItemClicked(Staff staff);
	}
	
	public void setCallback(Callback callback) {
		this.mCallback = callback;
	}
	
	public Staff getStaff() {
		return mStaff;
	}

	public void setStaff(Staff staff) {
		this.mStaff = staff;
	}

	public StaffItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}
	
	protected boolean initialize() {
		initUI();

		return true;
	}

	protected boolean initUI() {
		//LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LayoutInflater layoutInflater = LayoutInflater.from(getContext());
		layoutInflater.inflate(R.layout.staff_item_view, this);

		// Initialize controls
		this.mAvatarImageView = (ImageView) findViewById(R.id.avatar_image_view);
		this.mNameTextView = (TextView) findViewById(R.id.name_text_view);
		
		this.mAvatarImageView.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (mCallback != null)
					mCallback.onItemClicked(mStaff);
			}
		});
		
		this.mNameTextView.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (mCallback != null)
					mCallback.onItemClicked(mStaff);
			}
		});
		
		return true;
	}

	public void updateView() {
		mNameTextView.setText(mStaff.getName());
	}
}
