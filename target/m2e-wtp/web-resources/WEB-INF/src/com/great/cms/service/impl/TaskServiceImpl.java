package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.bean.TaskBean;
import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.dao.CourseTaskDao;
import com.great.cms.db.dao.ExamCommitteeDao;
import com.great.cms.db.dao.TaskDao;
import com.great.cms.db.dao.TaskTypeDao;
import com.great.cms.db.entity.CourseTask;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.db.entity.Task;
import com.great.cms.db.entity.TaskType;
import com.great.cms.service.TaskService;

@Service("TaskService")
public class TaskServiceImpl implements TaskService,Serializable {

	@Autowired
	TaskDao taskDao;
	@Autowired
	TaskTypeDao taskTypeDao;
	@Autowired
	CourseTaskDao courseTaskDao;
	@Autowired
	ExamCommitteeDao examCommitteeDao;
	@Autowired
	CourseDao courseDao;
	

	@Override
	public List<Task> getTaskList() {
		// TODO Auto-generated method stub
		List<Task> taskList = null;
		taskList = this.taskDao.findAll();
		return taskList;
	}

	
	@Override
	public void saveTask(TaskBean taskBean, int courseId) {
		// TODO Auto-generated method stub
		ExamCommittee examCommittee = new ExamCommittee();
		TaskType tt = this.taskTypeDao.findById(taskBean.getTaskTypeId());		
		Task task = new Task();
		
		task.setTaskTitle(taskBean.getTaskTitle());
		task.setTaskDesc(taskBean.getTaskDesc());
		task.setTaskDeadline(taskBean.getTaskDeadlineToDate());
		task.setTaskTotalGroupNo(taskBean.getTaskTotalGroupNo());
		task.setTaskTotalSubmissonNo(taskBean.getTaskTotalSubmissonNo());
		task.setIsOpen(taskBean.getIsOpen());
		task.setTaskTypeId(tt);
		
		this.taskDao.save(task);
		CourseTask courseTask = new CourseTask();
		courseTask.setTaskId(task);
		courseTask.setCourseId(this.courseDao.findById(courseId));
		courseTask.setExamCommitteeId(this.examCommitteeDao
				.findBySession(taskBean.getSession()));
		
		this.courseTaskDao.save(courseTask);
	}

	@Override
	public void updateTask(TaskBean taskBean) {
		// TODO Auto-generated method stub
		Task task = this.taskDao.findById(taskBean.getTaskId());
		task.setTaskTitle(taskBean.getTaskTitle());
		task.setTaskDesc(taskBean.getTaskDesc());
		task.setTaskDeadline(taskBean.getTaskDeadlineToDate());
		task.setTaskTotalGroupNo(taskBean.getTaskTotalGroupNo());
		task.setTaskTotalSubmissonNo(taskBean.getTaskTotalSubmissonNo());
		task.setIsOpen(taskBean.getIsOpen());
		this.taskDao.update(task);
		System.out.println("TaskBean session: " + taskBean.getSession());
		CourseTask courseTask = task.getCourseTask();
		courseTask.setExamCommitteeId(this.examCommitteeDao.findBySession(taskBean.getSession()));
		this.courseTaskDao.update(courseTask);
	}

	@Override
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		this.taskDao.delete(task);
	
	}

	@Override
	public Task findTaskById(int id) {
		// TODO Auto-generated method stub
		return this.taskDao.findById(id);
	}

	@Override
	public void deleteTaskById(int id) {
		// TODO Auto-generated method stub
		
		this.taskDao.deleteById(id);
		
	}

	@Override
	public List<Task> getTaskListByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return this.taskDao.getTaskListByCourseId(courseId);
	}
}
