package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.StudentGroup;

public interface StudentGroupDao extends GenericDao<StudentGroup, Integer> {
  

	//public List<StudentGroup> findGroupsByTaskID(int taskId);
	public List<StudentGroup> findStudentByGroupId(int groupId);
    public List<StudentGroup> findGroupByStudentId(int studentId);

	//void findGroupsByTaskID(int i);

	//void findGroupsByTaskID(int i);

	
}
