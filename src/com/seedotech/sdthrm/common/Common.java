/**
 * File Common.java
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
package com.seedotech.sdthrm.common;

public class Common {
	public static final String ROOT_URL = "http://192.168.1.2";
	// http://localhost/sdtservices/sdthrm.php?get_all_staff&format=json
	public static final String GET_ALL_STAFF_URL = ROOT_URL + "/sdtservices/sdthrm.php";
	public static final String GET_STAFF_URL = ROOT_URL + "/sdtservices/sdthrm.php?get_staff&staff_id=%d&format=json";
	public static final String DELETE_STAFF_URL = ROOT_URL + "/sdtservices/sdthrm.php?delete_staff&staff_id=%d&format=json";
	
	public static final int TIMEOUT = 30000; // 30 seconds
}
