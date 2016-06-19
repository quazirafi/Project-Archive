package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.TaskTypeDao;
import com.great.cms.db.entity.TaskType;

@Repository("TaskTypeDaoImpl")
public class TaskTypeDaoImpl extends GenericDaoImpl<TaskType, Integer> implements TaskTypeDao {

	public TaskTypeDaoImpl() {
		super(TaskType.class);
	
	}

	
}
