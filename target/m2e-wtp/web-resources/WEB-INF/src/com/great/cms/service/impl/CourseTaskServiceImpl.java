package com.great.cms.service.impl;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.CourseTaskDao;
import com.great.cms.db.entity.CourseTask;
import com.great.cms.service.CourseTaskService;

@Repository
@Service("CourseTaskService")
public class CourseTaskServiceImpl implements CourseTaskService,Serializable {
	
	@Autowired
	CourseTaskDao courseTaskDao;
	@Override
	public CourseTask getCourseTaskById(int id) {
		// TODO Auto-generated method stub
		CourseTask courseTask =  courseTaskDao.findById(id);
		return courseTask;
	}
	@Override
	public void deleteCourseTask(CourseTask courseTask) {
		// TODO Auto-generated method stub
		courseTaskDao.delete(courseTask);
		
	}
	@Override
	public CourseTask findCourseTaskByTaskId(int id,int courseId) {
		// TODO Auto-generated method stub
		//courseTaskDao.findById(id)
		return courseTaskDao.findCourseTaskIdByTaskId(id, courseId);
	}
	@Override
	public void deleteCourseTaskByCourseTaskId(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteCourseTaskById(int id) {
		// TODO Auto-generated method stub
		this.courseTaskDao.deleteById(id);
		
	}


}
