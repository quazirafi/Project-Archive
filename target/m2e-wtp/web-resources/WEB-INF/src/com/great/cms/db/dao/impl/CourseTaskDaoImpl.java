package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.great.cms.db.dao.CourseTaskDao;
import com.great.cms.db.entity.CourseTask;

@Repository("CourseTaskDao")
public class CourseTaskDaoImpl extends GenericDaoImpl<CourseTask, Integer> implements CourseTaskDao {

	public CourseTaskDaoImpl() {
		super(CourseTask.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public CourseTask findByTaskId(int taskId) {
		// TODO Auto-generated method stub
		List<CourseTask> list = null;
		//public ConfUser getConfUserByAccctMsisdn(long acctMsisdn){
		CourseTask courseTask=null;
			try{
				//courseReg = (CourseRegistration) em.createQuery("select o from " + type.getName() + " o where o.idStudent.idStudent ="+id+" ").getResultList();
				String query = "select o from " + type.getName() + " o where " +
     				   "o.taskId.taskId = ?1 ";
     	list = em.createQuery(query)
     			 .setParameter(1, taskId)
     			 .getResultList();
     	
     	
     		}
			catch(Exception e){
				System.out.println("*******failure*******");
	        }
			System.out.println("*******successful*******"+list.size());
			if(list.get(0)==null)System.out.println("SHDKJSHKJDHSKJDHSKJDHSKJD: ");
			courseTask = list.get(0);
			return courseTask;
	}

	@Override
	public CourseTask findCourseTaskIdByTaskId(int taskId,int courseId) {
		// TODO Auto-generated method stub
		List<CourseTask> list = null;
		//public ConfUser getConfUserByAccctMsisdn(long acctMsisdn){
		CourseTask courseTask = null;
			try{
				//courseReg = (CourseRegistration) em.createQuery("select o from " + type.getName() + " o where o.idStudent.idStudent ="+id+" ").getResultList();
				String query = "select o from " + type.getName() + " o where " +
     				   "o.taskId.taskId = ?1 and o.courseId.courseId= ?2 ";
     	list = em.createQuery(query)
     			 .setParameter(1, taskId)
     			 .setParameter(2, courseId)
     			 .getResultList();
     	
     	
     		}
			catch(Exception e){
				System.out.println("*******failure*******");
	        }
			System.out.println("*******successful*******"+list.size());
			if(list.get(0)==null)System.out.println("SHDKJSHKJDHSKJDHSKJDHSKJD: ");
			courseTask = list.get(0);
		
		return courseTask;
	}

	
	

}
