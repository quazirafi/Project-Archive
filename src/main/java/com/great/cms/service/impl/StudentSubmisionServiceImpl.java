package com.great.cms.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.great.cms.bean.SubmissionBean;
import com.great.cms.db.dao.ProjectGroupDao;
import com.great.cms.db.dao.ProjectGroupSubmitDao;
import com.great.cms.db.dao.SubmissionDao;
import com.great.cms.db.entity.ProjectGroupSubmit;
import com.great.cms.db.entity.Submission;
import com.great.cms.service.StudentSubmissionService;
import com.great.cms.service.SubmissionService;



@Service("StudentSubmissionService")
public class StudentSubmisionServiceImpl implements StudentSubmissionService,Serializable{
	
	
	
	String uploadDirectory; 
	String fileToDelete;
	
	File f = null;
    boolean bool = false;
	
	@Autowired
	private ProjectGroupSubmitDao projGroupSubDao;
	
	@Autowired
	private SubmissionDao submissionDao;
	
	@Autowired
	ProjectGroupDao projectGroupDao;

	@Override
	public void saveStdSubmission(SubmissionBean submissionBean, MultipartFile multipartFile) {
	System.out.println("add project group submit is called");
		
		Submission submission = new Submission();
		submission.setSubmissionTime(submissionBean.getSubmissionTime());
		submission.setCommentTeacher(submissionBean.getCommentTeacher());
		
		//Submission s = null;
		ProjectGroupSubmit pgs = new ProjectGroupSubmit(); 
		
		InputStream inputStream = null;
	    FileOutputStream outputStream =null;
	    
	    String newFileName = fileNameFromDate(submission.getSubmissionTime(), submissionBean.getGroupId());
	    
	    uploadDirectory = "F:\\300file\\"+ newFileName + ".zip";
	    
	    if(multipartFile.getSize()>0){
	    	try {
	    		inputStream = multipartFile.getInputStream();
				outputStream = new FileOutputStream(uploadDirectory);
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
				outputStream.write(buffer, 0, readBytes);
				
				}
				outputStream.close();
				inputStream.close();
				submission.setSubmissionUrl(newFileName);
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	    }   
	    
	    else{
	    	submission.setSubmissionUrl("");
	    }
		
		submissionDao.save(submission);

		pgs.setProjectGroupId(projectGroupDao.findById(submissionBean.getGroupId()));
		pgs.setSubmissionId(submission);
		
		projGroupSubDao.save(pgs);
		
	}
	
	

	// This method generates a unique filename from the timestamp and group id
	public String fileNameFromDate(String submissionTime, int projectGroupId){
		char[] tempFileName = submissionTime.toCharArray();
		Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<7; i++)
	    	sb.append( (char) (random.nextInt((122-65) + 1) + 65) );
	    for(char ch : tempFileName){
	    	if(ch >= '0' && ch <= '9')
	    		sb.append(ch);
	    }
	    sb.append(projectGroupId);
	   return sb.toString();
	}

}
