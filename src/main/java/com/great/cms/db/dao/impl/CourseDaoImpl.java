package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.entity.Course;

@Repository("CourseDao")
public class CourseDaoImpl extends GenericDaoImpl<Course, Integer> implements CourseDao {

	public CourseDaoImpl() {
		super(Course.class);
		System.out.println("CourseDaoImpl Created\n");
	}

	@Override
	public Course findByCourseCode(String CourseCode, int offeringDept,int session, int acceptingDept) {
	
		Course course = null;
		//public ConfUser getConfUserByAccctMsisdn(long acctMsisdn){
		System.out.println("We are in courseDao");
			try{
				//courseReg = (CourseRegistration) em.createQuery("select o from " + type.getName() + " o where o.idStudent.idStudent ="+id+" ").getResultList();
				String query = "select o from " + type.getName() + " o where " +
     				   "o.courseCode = ?1 ,o.offeringDept = ?2 , o.acceptingDept = 3? ,o.session = 4?" ;
     	course = (Course)em.createQuery(query)
     			 .setParameter(1, CourseCode)
     			 .setParameter(2,offeringDept)
     			 .setParameter(3,acceptingDept)
     			 .setParameter(4,session)
     			 .getResultList().get(0);
     	
     	
     		}
			catch(Exception e){
				System.out.println("*******failure******* in courseCode, dept, session, "+"trace of error "+ e);
				return null;
	        }
			System.out.println("*******successful*******course");
			return course;
		//}
	}

	@Override
	public Course findByCourseCode(String CourseCode) {
		// TODO Auto-generated method stub
		Course course = null;
		//public ConfUser getConfUserByAccctMsisdn(long acctMsisdn){
		System.out.println("We are in courseDao");
			try{
				//courseReg = (CourseRegistration) em.createQuery("select o from " + type.getName() + " o where o.idStudent.idStudent ="+id+" ").getResultList();
				String query = "select o from " + type.getName() + " o where " +
     				   "o.courseCode = ?1 " ;
     	course = (Course)em.createQuery(query)
     			 .setParameter(1, CourseCode)
     			 
     			 .getResultList().get(0);
     	
     	
     		}
			catch(Exception e){
				System.out.println("*******failure******* in courseCode, dept, session, "+"trace of error "+ e);
				return null;
	        }
			System.out.println("*******successful*******course");
			return course;
	}
	
	public List<Course> getAllCourses(){
		List<Course> courses = (List<Course>) em.createQuery("from Course").getResultList();
		return (courses);
	}

	@Override
	public List<Course> findByCourseSession(int session) {
		String query = "select o from Course o where o.session = ?1";
		List<Course> courses = (List<Course>) em.createQuery(query).setParameter(1,session).getResultList();
		return (courses);
	} 

}
