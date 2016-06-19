package com.great.cms.db.dao;

import com.great.cms.db.entity.CourseTask;

public interface CourseTaskDao extends GenericDao<CourseTask, Integer> {
	
	public CourseTask findByTaskId(int taskId);
    public CourseTask findCourseTaskIdByTaskId(int taskId,int courseId);
}
