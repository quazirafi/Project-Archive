package com.great.cms.bean;

import java.util.ArrayList;
import java.util.List;

public class GroupInputBean {
	private int groupId;
	private String groupMember1;
	private String groupMember2;
	private String groupMember3;
	private String groupMember4;
	private String groupMember5;
	private String groupMember6;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupMember1() {
		return groupMember1;
	}

	public void setGroupMember1(String groupMember1) {
		this.groupMember1 = groupMember1;
	}

	public String getGroupMember2() {
		return groupMember2;
	}

	public void setGroupMember2(String groupMember2) {
		this.groupMember2 = groupMember2;
	}

	public String getGroupMember3() {
		return groupMember3;
	}

	public void setGroupMember3(String groupMember3) {
		this.groupMember3 = groupMember3;
	}

	public String getGroupMember4() {
		return groupMember4;
	}

	public void setGroupMember4(String groupMember4) {
		this.groupMember4 = groupMember4;
	}

	public String getGroupMember5() {
		return groupMember5;
	}

	public void setGroupMember5(String groupMember5) {
		this.groupMember5 = groupMember5;
	}

	public String getGroupMember6() {
		return groupMember6;
	}

	public void setGroupMember6(String groupMember6) {
		this.groupMember6 = groupMember6;
	}

	public List<Integer> getMemberRegList() {
		List<Integer> list = new ArrayList<>();
		try {
			if (this.groupMember1 != null && this.groupMember1 != "")
				list.add(Integer.parseInt(groupMember1));
			if (this.groupMember2 != null && this.groupMember2 != "")
				list.add(Integer.parseInt(groupMember2));
			if (this.groupMember3 != null && this.groupMember3 != "")
				list.add(Integer.parseInt(groupMember3));
			if (this.groupMember4 != null && this.groupMember4 != "")
				list.add(Integer.parseInt(groupMember4));
			if (this.groupMember5 != null && this.groupMember5 != "")
				list.add(Integer.parseInt(groupMember5));
			if (this.groupMember6 != null && this.groupMember6 != "")
				list.add(Integer.parseInt(groupMember6));
		} catch (NumberFormatException ex) {
			// In case of invalid registration number entry, we're clearing the list.
			// Inputs should be validated by javaScript before they reach this point in code.
			list.clear();
		}
		return list;
	}
}
