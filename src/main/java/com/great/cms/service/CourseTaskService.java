package com.great.cms.service;

import com.great.cms.db.entity.CourseTask;

public interface CourseTaskService {
	
	public CourseTask getCourseTaskById(int id);
	public void deleteCourseTask(CourseTask courseTask);
	public void deleteCourseTaskById(int id);

	public CourseTask findCourseTaskByTaskId(int id,int courseId);
	public void deleteCourseTaskByCourseTaskId(int id);

}
