package com.seedotech.sdthrm.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.seedotech.sdthrm.common.Common;
import com.seedotech.sdthrm.models.Staff;
import com.seedotech.sdthrm.models.StaffModel;

public class HrmService {
	private Callback mCallback = null;
	
	public interface Callback {
		public void onGetAllStaffsDone(final StaffModel staffModel);
		public void onError();
	}
	
	public void setCallback(final Callback callback) {
		mCallback = callback;
	}
	
	public boolean requestAllStaffs() {
		String result = getAllStaffs();
		if (mCallback != null) {
			StaffModel staffModel = parseStaffModelFromJSON(result);
			mCallback.onGetAllStaffsDone(staffModel);
		}
		
		return true;
	}
	
	protected String getAllStaffs() {
		String result = "";
		String request = String.format(Common.GET_ALL_STAFF_URL);
		RestClient client = new RestClient(request);
		client.addParam("get_all_staff", "");
		client.addParam("format", "json");
		
		try {
			client.execute(RestClient.RequestMethod.GET);
			result = client.getResponse();
		} catch (Exception e) {
			if (mCallback != null) {
				mCallback.onError();
				return "";
			}
		} 
		return result;
	}
	
	public StaffModel parseStaffModelFromJSON(String data) {
		StaffModel staffModel = new StaffModel();
		
		if (data.indexOf('{') > -1)
			data = data.substring(data.indexOf('{'));
		if (data.lastIndexOf('}') > -1)
			data = data.substring(0, data.lastIndexOf('}')+1);
		
		try {
			JSONObject staffsObj = new JSONObject(data);
			if (!staffsObj.has("staffs"))
				return null;
			
			JSONArray staffListObj = staffsObj.getJSONArray("staffs");
			for (int i = 0; i < staffListObj.length(); i++) {
				Staff staff = new Staff();
				JSONObject staffObj = staffListObj.getJSONObject(i);
				String stringVal = "", key = "";
				int intVal = -1;
				key = "staff";
				if (!staffObj.has(key))
					continue;
				staffObj = staffObj.getJSONObject(key);
				
				key = "id";
				intVal = staffObj.has(key) ? staffObj.getInt(key) : -1;
				staff.setId(intVal);
				key = "id_card";
				stringVal = staffObj.has(key) ? staffObj.getString(key) : "";
				staff.setIdCard(stringVal);
				key = "name";
				stringVal = staffObj.has(key) ? staffObj.getString(key) : "";
				staff.setName(stringVal);
				key = "address";
				stringVal = staffObj.has(key) ? staffObj.getString(key) : "";
				staff.setAddress(stringVal);
				key = "avatar";
				stringVal = staffObj.has(key) ? staffObj.getString(key) : "";
				staff.setAvatar(stringVal);

				// Add to the model
				staffModel.add(staff);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return staffModel;
	}
}
