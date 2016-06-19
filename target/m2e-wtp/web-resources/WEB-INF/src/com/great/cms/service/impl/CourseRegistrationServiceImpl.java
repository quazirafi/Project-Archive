package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.CourseRegistrationDao;
import com.great.cms.db.entity.CourseRegistration;
import com.great.cms.service.CourseRegistrationService;


@Repository
@Service("CourseRegistrationService")
public class CourseRegistrationServiceImpl implements CourseRegistrationService, Serializable {
	
	@Autowired
	private CourseRegistrationDao courseRegistrationDao;
	private static final long serialVersionUID = 7468488836689400267L;

	@Override
	public List<CourseRegistration> getStudentRegistration(int id) {
		// TODO Auto-generated method stub
		List<CourseRegistration> courseRegList = courseRegistrationDao.getRegistrationByIdStudent(id);
		return courseRegList;	
	}	
}
