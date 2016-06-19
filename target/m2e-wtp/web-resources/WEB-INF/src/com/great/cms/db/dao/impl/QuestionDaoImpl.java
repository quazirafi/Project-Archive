package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.QuestionDao;
import com.great.cms.db.entity.Question;


@Repository("QuestionDao")
public class QuestionDaoImpl extends GenericDaoImpl<Question, Integer> implements QuestionDao {

	public QuestionDaoImpl() {
		super(Question.class);
		
	}

	@Override
	public List<Question> findByCourseId(int CourseId) {
		

		List<Question> list = null;
		try{
			String query = "select o from " + type.getName() + " o where " +
 				   "o.courseId.courseId = ?1 " +
 				   "order by o.courseId.courseId ";
 	list = em.createQuery(query)
 			 .setParameter(1, CourseId)
 			 .getResultList();
 	
 	
 		}
		catch(Exception e){
			System.out.println("Exception in findByCourseID, CourseID = "+CourseId + " error trace : ");
			e.printStackTrace();
			return null;
        }
		    System.out.println("findByCourseId was successful");
		    return list;
	}

}
