package com.great.cms.bean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskBean {
	private Integer taskId;
	private String taskTitle;
	private String taskDesc;
	private String taskDeadline;
	private int taskTotalGroupNo;
	private int taskTotalSubmissonNo;
	private boolean isOpen;
	
	
	public boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

	private String taskType;
	private int session;
	
	public int getSession() {
		return session;
	}
	public void setSession(int session) {
		this.session = session;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public String getTaskDeadline() {
		return taskDeadline;
	}
	public void setTaskDeadline(String taskDeadline) {
		this.taskDeadline = taskDeadline;
	}
	public int getTaskTotalGroupNo() {
		return taskTotalGroupNo;
	}
	public void setTaskTotalGroupNo(int taskTotalGroupNo) {
		this.taskTotalGroupNo = taskTotalGroupNo;
	}
	public int getTaskTotalSubmissonNo() {
		return taskTotalSubmissonNo;
	}
	public void setTaskTotalSubmissonNo(int taskTotalSubmissonNo) {
		this.taskTotalSubmissonNo = taskTotalSubmissonNo;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	
	public int getTaskTypeId(){
		switch(this.taskType){
		case "Assignment":
			return 1;
		case "Project":
			return 2;
		case "Thesis":
			return 3;
		default:
			return 1;
		}
	}
	
	// TODO: Convert the string date from HTML to SQL date format
	// Currently returns the system datetime of execution
	public Date getTaskDeadlineToDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		return date;
	}
}
