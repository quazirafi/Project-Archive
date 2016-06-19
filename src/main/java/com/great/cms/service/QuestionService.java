package com.great.cms.service;

import org.springframework.web.multipart.MultipartFile;

import com.great.cms.bean.QuestionBean;

public interface QuestionService {
	
	public void addQuestion(QuestionBean questionBean, MultipartFile File);

	public void deleteQuestion(int questionId);
	public void updateQuestion(QuestionBean questionBean, int questionId);
	public void updateQuestion(QuestionBean questionBean, int questionId,MultipartFile file);
	

}
