package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Question;

public interface QuestionDao extends GenericDao<Question, Integer>{

	
	public List<Question> findByCourseId(int CourseId);

	
	
}
