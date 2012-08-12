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
	private ImageView avatarImageView = null;
	private TextView nameTextView = null;
	private Staff staff = null;
	
	private Callback callback = null;
	
	public interface Callback {
		public void onItemClicked(Staff staff);
	}
	
	public void setCallback(Callback callback) {
		this.callback = callback;
	}
	
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
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
		LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		layoutInflater.inflate(R.layout.staff_item_view, this);

		// Initialize controls
		this.avatarImageView = (ImageView) findViewById(R.id.avatar_image_view);
		this.nameTextView = (TextView) findViewById(R.id.name_text_view);
		
		this.avatarImageView.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (callback != null)
					callback.onItemClicked(staff);
			}
		});
		
		this.nameTextView.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (callback != null)
					callback.onItemClicked(staff);
			}
		});
		
		return true;
	}

	public void updateView() {
		nameTextView.setText(staff.getName());
	}
}
