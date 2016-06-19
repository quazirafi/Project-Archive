package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.TaskType;

public interface TaskTypeService {
	
    List<TaskType>getTaskTypeList();
	
	void saveTaskType(TaskType taskType);
	
	public void updateTaskType(TaskType taskType);
	
	public void deleteTaskType(TaskType taskType);
	

}
