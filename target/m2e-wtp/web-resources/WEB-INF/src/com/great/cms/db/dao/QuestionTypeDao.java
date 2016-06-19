package com.great.cms.db.dao;

import com.great.cms.db.entity.QuestionType;

public interface QuestionTypeDao extends GenericDao<QuestionType, Integer> {
	
	public QuestionType findByQuestionName(String QuestionName);

}
