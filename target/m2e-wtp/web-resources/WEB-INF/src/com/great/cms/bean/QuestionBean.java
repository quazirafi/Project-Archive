package com.great.cms.bean;

public class QuestionBean {

	
	private String courseCode;
	private int semester;
	private int session;
	private String type;
	private byte[] QuestionFile;
	private String deptName;
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public byte[] getQuestionFile() {
		return QuestionFile;
	}
	public void setQuestionFile(byte[] questionFile) {
		QuestionFile = questionFile;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getSession() {
		return session;
	}
	public void setSession(int session) {
		this.session = session;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
