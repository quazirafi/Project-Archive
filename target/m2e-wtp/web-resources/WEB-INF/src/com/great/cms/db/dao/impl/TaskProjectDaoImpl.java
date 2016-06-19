package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.TaskProjectDao;
import com.great.cms.db.entity.Task;
//import com.great.cms.db.entity.Project;
import com.great.cms.db.entity.TaskProject;
//import com.great.cms.db.entity.ProjectGroupSubmit;

@Repository("TaskProjecttDao")
public class TaskProjectDaoImpl extends GenericDaoImpl<TaskProject, Integer> 
									   implements TaskProjectDao{

	public TaskProjectDaoImpl() {
		super(TaskProject.class);
	}
	
	@Override
	public List<TaskProject> getProjectsByTaskID (int taskId) {
		 List<TaskProject> list = null;
		 Task t = new Task (taskId);
		 
		 String query = "select o from " + type.getName() + " o where " +
				   "o.taskId.taskId = ?1 ";
	list = em.createQuery(query)
			 .setParameter(1, taskId)
			 .getResultList();
	
	
		 
			 return list;
	}
	
	}
