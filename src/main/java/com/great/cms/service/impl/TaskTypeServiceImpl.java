package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.great.cms.db.dao.TaskTypeDao;
import com.great.cms.db.entity.TaskType;
import com.great.cms.service.TaskTypeService;

@Service("TaskTypeService")
public class TaskTypeServiceImpl implements TaskTypeService,Serializable {

	TaskTypeDao taskTypeDao;
	@Override
	public List<TaskType> getTaskTypeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTaskType(TaskType taskType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTaskType(TaskType taskType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTaskType(TaskType taskType) {
		// TODO Auto-generated method stub
		this.taskTypeDao.delete(taskType);
		
	}
	

	

	

	
	

	

}
