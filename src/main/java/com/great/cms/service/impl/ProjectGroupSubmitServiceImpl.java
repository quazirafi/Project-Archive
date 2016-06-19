package com.great.cms.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.great.cms.db.dao.ProjectGroupDao;
import com.great.cms.db.dao.ProjectGroupSubmitDao;
import com.great.cms.db.dao.SubmissionDao;
import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.ProjectGroupSubmit;
import com.great.cms.db.entity.Submission;
import com.great.cms.service.ProjectGroupSubmitService;

@Service("ProjectGroupSubmitService")
public class ProjectGroupSubmitServiceImpl implements ProjectGroupSubmitService,Serializable{

	@Autowired
	private ProjectGroupSubmitDao projGroupSubDao;
	
	@Autowired
	private SubmissionDao submissionDao;
	@Autowired
	ProjectGroupDao projectGroupDao;

	@Autowired
	UserDao userDao;
	
	
	@Override
	public List<Submission> findSubmissionListByProjectGroupId(int projectGroupId) {
		
		System.out.println("findSubmissionByProjectGroupId Called, id = " + projectGroupId);
		List<ProjectGroupSubmit> list = null;
		ArrayList<Submission> submissionList = new ArrayList<Submission>();
		
		Submission sub;
		try{
			list = projGroupSubDao.getSubmissionByProjectGroup(projectGroupId);
			System.out.println("proj grp submit srvc. list size = " + list.size());
			for(ProjectGroupSubmit pGS : list){
				submissionList.add(pGS.getSubmissionId());
				System.out.println("Submission id = " + pGS.getSubmissionId().getSubmissionId()
						+ " Submission time = " + pGS.getSubmissionId().getSubmissionTime());
				
			}
			
		}catch(Exception e){
			System.out.println("ProjectGroupSubmitService failed error = " + e);
			return null;
		}
		return submissionList;
	}


	
	@Override
	public void addProjectGroupSubmit(Submission submission,int projectGroupID,MultipartFile multipartFile){
		
		System.out.println("add project group submit is called");
		

		//Submission s = null;
		ProjectGroupSubmit pgs = new ProjectGroupSubmit(); 
		
		InputStream inputStream = null;
	    FileOutputStream outputStream =null;
	    
	    String newFileName = fileNameFromDate(submission.getSubmissionTime(), projectGroupID);
	    
	    System.out.println("Proposed new file name: "+newFileName);
	    
	    String uploadDirectory = "G:\\Work\\Upload Repo\\"+ newFileName + ".zip";
	    
	    if(multipartFile.getSize()>0){
	    	try {
	    		inputStream = multipartFile.getInputStream();
				outputStream = new FileOutputStream(uploadDirectory);
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
				System.out.println("===ddd=======");
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
		

//		s = submissionDao.findByVersionAndTime(submission.getSubmissionVer(),submission.getSubmissionTime());
//		
//		if(s == null){
//			System.out.println("Submission adding failed!");
//			return;
//		}
//		
//		System.out.println("new submission id = " + s.getSubmissionId());
		pgs.setProjectGroupId(projectGroupDao.findById(projectGroupID));
		pgs.setSubmissionId(submission);
		
		projGroupSubDao.save(pgs);
		
		
		
	}

	@Override
	public void updateProjectGroupSubmit(Submission submission,int projectGroupID) {
		
		
	}

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
