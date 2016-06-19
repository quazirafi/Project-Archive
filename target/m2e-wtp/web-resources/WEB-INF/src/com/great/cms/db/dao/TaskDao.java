package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Task;

public interface TaskDao extends GenericDao<Task, Integer> {
	
    public List<Task> getTaskListByCourseId(int courseId);
}
