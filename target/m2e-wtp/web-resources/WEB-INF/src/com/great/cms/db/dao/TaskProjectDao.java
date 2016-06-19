package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.TaskProject;

public interface TaskProjectDao extends GenericDao<TaskProject, Integer> {

	List<TaskProject> getProjectsByTaskID(int taskId);
	
	
}