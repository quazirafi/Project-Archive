package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.CourseRegistration;



/**
 * 
 * @author sknabil
 *
 */
public interface CourseRegistrationDao  extends GenericDao<CourseRegistration, Integer> {
	public List<CourseRegistration> getRegistrationByIdStudent(int id);
}
