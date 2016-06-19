package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.dao.CourseRegistrationDao;
import com.great.cms.db.dao.StudentDao;
import com.great.cms.db.dao.TeacherDao;
import com.great.cms.db.dao.TeachesDao;
import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.CourseRegistration;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;
import com.great.cms.db.entity.User;
import com.great.cms.db.entity.UserType;
import com.great.cms.service.CourseService;

@Service("CourseService")
public class CourseServiceImpl implements CourseService, Serializable{

	@Autowired
	CourseDao courseDao;
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Autowired
	private TeachesDao teachesDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CourseRegistrationDao courseRegDao;
	
	@Autowired
	StudentDao StdDao;
	

	
	Teacher teacher = new Teacher();
	Student student = new Student();
	Long InstructorId = null;
	List<CourseRegistration> courseReg= null;
	 int StudentId=0;
	
	User user=null;
	
	@Override
	public List<Course> getCourseList() {
		List<Course> courseList = null;
		courseList = this.courseDao.findAll();
		return courseList;
	}
	
	public List<Course> getCourseBySession(int session){
		List<Course> courseList = null;
		courseList = this.courseDao.findByCourseSession(session);
		return courseList; 
	} 

	@Override
	public List<Course> getCourseListByUserId(Long id) {
		// TODO implement this method for god's sake.
		List<Course> list = null;
		list = new ArrayList<>();
		List<Teaches> teaches = new ArrayList<>();
		teacher = teacherDao.findByUserId(id);
		if(teacher == null)	
			System.out.println("Null teacher");
			
		
	    InstructorId = teacher.getInstructorId();
		
		teaches = teachesDao.findByInstructorId(InstructorId);

		if (teaches != null && teaches.size() > 0) {
			for (Teaches teach : teaches) {

				Course course = teach.getCourseId();

				System.out.println("##" + course.getCourseTitle());

				list.add(course);

			}
		}
		System.out.println("Courses found: "+list.size());
		return list;
	}

	@Override
	public String getCourseById(int id) {
		return this.courseDao.findById(id).getCourseCode();
	}

	@Override
	public List<Course> getCourseListByUser(String username) {
		// TODO Auto-generated method stub
		List<Course> list = new ArrayList<>();
		user = userDao.findUserByName(username);
		list = this.getCourseListByUserId(user.getUserId());
		
		System.out.println("The Course List in Course Service Layer: "+list);
		return list;
	}

	@Override
	public List<Course> getCourseListByUserType(User user) {
		List<CourseRegistration> courseReg= new ArrayList<>();
		List<Course> list = new ArrayList<>();
		UserType type=user.getUserTypeId();
		String Role=type.getUserTypeName();
		
		System.out.println("user role "+Role);
		
		if( Role.equals("Teacher"))
		{
			list=getCourseListByUserId(user.getUserId());
			return list;
		}
		if( Role.equals("Student"))
				{
			student =  StdDao.getStudentByUserId(user.getUserId());
			
			System.out.println(" Student here "+ student.getFirstName());
			if(student == null)	
				System.out.println("Null student");
				
			
		    StudentId = student.getStudentId();
			
			courseReg = courseRegDao.getRegistrationByIdStudent(StudentId);
			
			if(courseReg == null)
				System.out.println("null course");

			if (courseReg != null && courseReg.size() > 0) {
				for (CourseRegistration teach : courseReg) {

					Course course = teach.getCourseId();

					System.out.println("##" + course.getCourseTitle());

					list.add(course);

				}
			}
			System.out.println("Courses found: "+list.size());
			return list;
				}
		
		System.out.println("Something is wrong");
		return null;
	}

}