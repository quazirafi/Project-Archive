package com.great.cms.service;


import org.springframework.web.multipart.MultipartFile;

import com.great.cms.bean.SubmissionBean;

public interface StudentSubmissionService {

	
	
	public void saveStdSubmission(SubmissionBean submissionBean, MultipartFile multipartFile);
}
