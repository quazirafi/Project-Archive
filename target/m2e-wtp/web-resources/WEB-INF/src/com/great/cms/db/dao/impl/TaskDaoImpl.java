package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.great.cms.db.dao.TaskDao;
import com.great.cms.db.entity.CourseRegistration;
import com.great.cms.db.entity.Task;

@Repository("TaskDao")
public class TaskDaoImpl extends GenericDaoImpl<Task, Integer> implements TaskDao {

	public TaskDaoImpl() {
		super(Task.class);
	
	}

	@Override
	public List<Task> getTaskListByCourseId(int courseId) {
		//System.out.println("TaskDaoImpl : COURSE ID IS: "+courseId);
		// TODO Auto-generated method stub
		List<Task> list = null;
		//public ConfUser getConfUserByAccctMsisdn(long acctMsisdn){
		CourseRegistration courseReg = null;
			try{
				//courseReg = (CourseRegistration) em.createQuery("select o from " + type.getName() + " o where o.idStudent.idStudent ="+id+" ").getResultList();
				String query = "select o from " + type.getName() + " o where " +
     				   "o.courseTask.courseId.courseId = ?1 ";
     	list = em.createQuery(query)
     			 .setParameter(1, courseId)
     			 .getResultList();
     	
     	
     		}
			catch(Exception e){
				System.out.println("*******failure*******");
	        }
			System.out.println("*******successful*******");
			return list;
	
	}

	

}