/**
 * File Staff.java
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
package com.seedotech.sdthrm.models;

public class Staff {
	private int mId;
	private String mIdCard;
	private String mName;
	private String mAddress;
	private String mAvatarUrl;
	
	public Staff() {
		mId = -1;
		mIdCard = "";
		mName = "";
		mAddress = "";
		mAvatarUrl = "";
	}
	
	public Staff(int id, final String idCard, final String name, final String address, final String avatarUrl) {
		this.mId = id;
		this.mIdCard = idCard;
		this.mName = name;
		this.mAddress = address;
		this.mAvatarUrl = avatarUrl;
	}
	
	public int getId() {
		return mId;
	}
	public void setId(int id) {
		this.mId = id;
	}
	
	public String getIdCard() {
		return mIdCard;
	}
	public void setIdCard(final String idCard) {
		this.mIdCard = idCard;
	}
	
	public String getName() {
		return mName;
	}
	public void setName(final String name) {
		this.mName = name;
	}
	
	public String getAddress() {
		return mAddress;
	}
	public void setAddress(final String address) {
		this.mAddress = address;
	}
	
	public String getAvatar() {
		return mAvatarUrl;
	}
	public void setAvatar(final String avatar) {
		this.mAvatarUrl = avatar;
	}
}
