package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.Student;

public interface StudentGroupService {

	public List<Student> findStudentByGroupId(int groupId);
}
