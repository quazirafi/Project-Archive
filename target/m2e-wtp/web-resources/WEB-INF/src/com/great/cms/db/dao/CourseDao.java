package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Course;

public interface CourseDao extends GenericDao<Course, Integer> {

	public Course findByCourseCode(String CourseCode,int offeringDept,int session, int acceptingDept);
	public Course findByCourseCode(String CourseCode);
	public List<Course> findByCourseSession(int session);
}
