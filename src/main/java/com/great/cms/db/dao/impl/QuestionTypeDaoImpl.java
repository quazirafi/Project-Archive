package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.QuestionTypeDao;
import com.great.cms.db.entity.QuestionType;


@Repository("QuestionTypeDao")
public class QuestionTypeDaoImpl extends GenericDaoImpl<QuestionType, Integer> implements QuestionTypeDao{

	public QuestionTypeDaoImpl( ) {
		super(QuestionType.class);
	
	}

	@Override
	public QuestionType findByQuestionName(String QuestionName) {
		
		QuestionType list = null;
		try{
			String query = "select o from " + type.getName() + " o where " +
 				   "o.questionTypeName = ?1 " ;
 	list =(QuestionType) em.createQuery(query)
 			 .setParameter(1, QuestionName)
 			 .getResultList().get(0);
 	
 	
 		}
		catch(Exception e){
			System.out.println("Exception in findByquestionName, QuestionNAme = "+QuestionName + " error trace : ");
			e.printStackTrace();
			return null;
        }
		    System.out.println("findByNamewas successful");
		    return list;
	}

}
