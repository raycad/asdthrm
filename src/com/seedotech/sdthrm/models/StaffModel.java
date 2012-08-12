/**
 * File StaffModel.java
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StaffModel {
	private ArrayList<Staff> m_staffList = new ArrayList<Staff>();

	public void add(final Staff staff) {
		m_staffList.add(staff);
	}

	public Staff get(final int index) {
		if (index < 0)
			return null;
		return m_staffList.get(index);
	}

	public boolean remove(final Staff staff) {
		return m_staffList.remove(staff);
	}

	public int count() {
		return m_staffList.size();
	}
	
	public void clear() {
		m_staffList.clear();
	}
	
	public void sortByName() {
		Collections.sort(m_staffList, new Comparator<Staff>() {
			@Override
			public int compare(Staff o1, Staff o2) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				return name1.compareToIgnoreCase(name2);
			}
		});
	}
}
