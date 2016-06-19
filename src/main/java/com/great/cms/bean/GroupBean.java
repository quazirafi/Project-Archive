package com.great.cms.bean;

import java.util.ArrayList;

public class GroupBean {
	private int groupId;
	private ArrayList<String> memberList;
	private String groupName;
	private int submissionCount;
	public int getSubmissionCount() {
		return submissionCount;
	}
	public void setSubmissionCount(int submissionCount) {
		this.submissionCount = submissionCount;
	}
	private int taskId;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public ArrayList<String> getMemberList() {
		return memberList;
	}
	public void setMemberList(ArrayList<String> memberList) {
		this.memberList = memberList;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
}
