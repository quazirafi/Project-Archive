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
import com.great.cms.service.SubmissionService;


@Service("SubmissionService")
public class SubmissionServiceImpl implements SubmissionService,Serializable{

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
	public void updateSubmission(SubmissionBean submissionBean,int submissionId) {
		
		Submission submission = submissionDao.findById(submissionId);
//		System.out.println("<---UpdateObject Method in Service Impl Layer--->");
//		System.out.println("Submission Object Before Edit: "+submission.toString());
		submission.setSubmissionTime(submissionBean.getSubmissionTime());
		submission.setCommentTeacher(submissionBean.getCommentTeacher());
		// Keeping the old file
		//submission.setSubmissionUrl(null);
		
		
		submissionDao.update(submission);
//		System.out.println("<---UpdateObject Method in Service Impl Layer--->");
//		System.out.println("Submission Object after Edit: "+submission.toString());
	}
	
//	@Override
//	public void saveSubmission(Submission submission) {
//		
//		submissionDao.save(submission);
//	}

	@Override
	public void deleteSubmission(int submissionId) {
		
		if(submissionDao.findById(submissionId).getSubmissionUrl()!=null){
			
			
			System.out.println("We have file to delete");
			//Delete the file from the directory
			fileToDelete = "F:\\Work\\Upload Repo\\" + submissionDao.findById(submissionId).getSubmissionUrl() + ".zip";
            f = new File(fileToDelete);
            bool = f.delete();
            
            if(bool){
            	System.out.println("File Deleted");
            }
          
						
		}
		
		   		
		   //Delete the object anyway
			this.submissionDao.deleteById(submissionId);
			

		
		
		
		
	}

	@Override
	public void saveSubmission(SubmissionBean submissionBean, MultipartFile multipartFile) {
		System.out.println("add project group submit is called");
		
		Submission submission = new Submission();
		submission.setSubmissionTime(submissionBean.getSubmissionTime());
		submission.setCommentTeacher(submissionBean.getCommentTeacher());
		
		//Submission s = null;
		ProjectGroupSubmit pgs = new ProjectGroupSubmit(); 
		
		InputStream inputStream = null;
	    FileOutputStream outputStream =null;
	    
	    String newFileName = fileNameFromDate(submission.getSubmissionTime(), submissionBean.getGroupId());
	    
	    uploadDirectory = "F:\\Work\\Upload Repo\\"+ newFileName + ".zip";
	    
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

	@Override
	public void saveSubmission(SubmissionBean submissionBean) {
		System.out.println("Add Submission with no file-Service Layer");
		// TODO Auto-generated method stub
		ProjectGroupSubmit pgs = new ProjectGroupSubmit();
		Submission submission = new Submission();
		submission.setSubmissionTime(submissionBean.getSubmissionTime());
		submission.setCommentTeacher(submissionBean.getCommentTeacher());
		submission.setSubmissionUrl(null);
		
		submissionDao.save(submission);
		pgs.setProjectGroupId(projectGroupDao.findById(submissionBean.getGroupId()));
		pgs.setSubmissionId(submission);
		
		projGroupSubDao.save(pgs);
	}

	@Override
	public void updateSubmissionWithFile(SubmissionBean submissionBean,MultipartFile multipartFile,int submissionId) {
//		// TODO Auto-generated method stub
//		
//		
		  
		System.out.println("Submission Bean Object Before Edit: "+submissionBean.toString());
		
		Submission submission = submissionDao.findById(submissionId);
		
		System.out.println("Submission Object Before Edit: "+submission.toString());

		
		submission.setSubmissionTime(submissionBean.getSubmissionTime());
		submission.setCommentTeacher(submissionBean.getCommentTeacher());
		
		
		InputStream inputStream = null;
	    FileOutputStream outputStream =null;
	    
	    
	    
	    String newFileName = fileNameFromDate(submission.getSubmissionTime(), submission.getSubmissionId());
	    
	    uploadDirectory = "F:\\Work\\Upload Repo\\"+ newFileName + ".zip";
	    
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
	    
	    submissionDao.update(submission);
	    System.out.println("Submission Object after Editing: "+submission.toString());
		
	}
	

}
