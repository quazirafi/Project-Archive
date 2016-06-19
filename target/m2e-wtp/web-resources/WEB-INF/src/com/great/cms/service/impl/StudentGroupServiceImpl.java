package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.StudentGroupDao;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.StudentGroup;
import com.great.cms.service.StudentGroupService;

@Service("StudentGroupService")
public class StudentGroupServiceImpl implements StudentGroupService, Serializable{

	@Autowired
	private StudentGroupDao studentGroupDao;
	
	@Override
	public List<Student> findStudentByGroupId(int groupId) {
		
		List<StudentGroup> studentGroupList =  studentGroupDao.findStudentByGroupId(groupId);
		List<Student> studentList = new ArrayList<Student>();
		
		for(StudentGroup stdGrp : studentGroupList){
			studentList.add(stdGrp.getStudentId());
		}
		
		
		return studentList;
	}

}
