package com.great.cms.bean;

public class ProjectBean {

	private Integer projectId;
	private Integer taskId;
	private String projectTitle;
	private String projectDesc;

	@Override
	public String toString() {
		return "UPDATED PARAMETERS:\nProject Id: " + this.projectId
				+ " Project Title: " + this.projectTitle
				+ " Project Description: " + this.projectDesc;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

}
