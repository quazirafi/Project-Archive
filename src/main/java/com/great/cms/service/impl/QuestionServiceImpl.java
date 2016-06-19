package com.great.cms.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.great.cms.bean.QuestionBean;
import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.dao.DepartmentDao;
import com.great.cms.db.dao.QuestionDao;
import com.great.cms.db.dao.QuestionTypeDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Department;
import com.great.cms.db.entity.Question;
import com.great.cms.service.QuestionService;

@Service("QuestionService")
public class QuestionServiceImpl implements QuestionService,Serializable {
	
	String uploadDirectory; 
	
	
	File f = null;
   
	
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired 
	private QuestionDao questiondao;

	@Autowired
	private QuestionTypeDao typeDao;
	
	
	@Override
	public void addQuestion(QuestionBean questionBean, MultipartFile File) {
		Question question = new Question();
		
		
		System.out.println("add QuestionService");
		Department dept=deptDao.findByDeptCode(questionBean.getDeptName());
		
		int acceptDept=dept.getDeptId();
		
		String deptCode=questionBean.getCourseCode().substring(0, 2);
		
		Department dept2=deptDao.findByDeptCode(deptCode);
		
		int offerDept=dept2.getDeptId();
		
		
		
		Course course =courseDao.findByCourseCode(questionBean.getCourseCode(),offerDept,questionBean.getSession(),acceptDept );
		
		
		System.out.println("the question of course: "+course);
		question.setCourseId(course);
		question.setQuestionTypeId(typeDao.findByQuestionName(questionBean.getType()));
		
		
		InputStream inputStream = null;
	    FileOutputStream outputStream =null;
	    
	    String newFileName=questionBean.getCourseCode()+String.valueOf(questionBean.getSession());
	    
	    System.out.println("new file name "+newFileName);
	    
	    uploadDirectory="F:\\question"+newFileName;
		
		
	    if(File.getSize()>0){
	    	try {
	    		inputStream = File.getInputStream();
				outputStream = new FileOutputStream(uploadDirectory);
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
				outputStream.write(buffer, 0, readBytes);
				
				}
				outputStream.close();
				inputStream.close();
				question.setQuestionUrl(uploadDirectory);
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	    }
	    else{
	    	question.setQuestionUrl(uploadDirectory);
	    }
	    
	    questiondao.save(question);
		
	}

	@Override
	public void deleteQuestion(int questionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuestion(QuestionBean questionBean, int questionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateQuestion(QuestionBean questionBean, int questionId, MultipartFile file) {
		// TODO Auto-generated method stub
		
	}

}
