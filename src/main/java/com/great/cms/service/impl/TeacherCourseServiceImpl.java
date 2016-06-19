package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.dao.TeacherDao;
import com.great.cms.db.dao.TeachesDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Teacher;
import com.great.cms.db.entity.Teaches;
import com.great.cms.service.TeacherCourseService;


//Tested
@Repository
@Service("TeacherCourseService")
public class TeacherCourseServiceImpl implements TeacherCourseService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private TeachesDao teachesDao;
	@Autowired
	private CourseDao courseDao;

	List<Course> list = new ArrayList<>();
	List<Teaches> teaches = new ArrayList<>();
	List<Teacher> teacher = new ArrayList<>();
	Long InstructorId = null;
	private JSONArray jsonArray;

	@Override
	public String getCourseListByUserId(Long userId) {

		teacher = (List<Teacher>) teacherDao.findByUserId(userId);
		for (Teacher teachers : teacher) {

			InstructorId = teachers.getInstructorId();
		}
		teaches = teachesDao.findByInstructorId(InstructorId);

		if (teaches != null && teaches.size() > 0) {
			for (Teaches teach : teaches) {

				Course course = teach.getCourseId();

				System.out.println("##" + course.getCourseTitle());

				list.add(course);

			}
		}
		
		jsonArray = new JSONArray();
		if(list==null)
			System.out.println("list is null");
	    for(Course t: list)
	    {
	    	JSONArray jObj = new JSONArray();
	    	jObj.add(t.getCourseId().toString());
	    	jObj.add(t.getCourseTitle());
	    	jObj.add(t.getCourseCode());
	    	jObj.add(String.valueOf(t.getCredit()));
	    	jObj.add(String.valueOf(t.getSemester()));
	    	jObj.add(String.valueOf(t.getSession()));
	    	jObj.add(t.getAcceptingDept());
	    	jObj.add(t.getOfferingDept());
	    	
	    	
	    	jsonArray.add(jObj);  	
	    	

	    }
	    JSONObject parameters = new JSONObject();

    	parameters.put("draw", 1);

    	parameters.put("recordsTotal", 1 );
    	
    	parameters.put("recordsFiltered", 1 );
    	
    	parameters.put("data", jsonArray);
    	
    	String courseJson = parameters.toJSONString();
    	
		return courseJson;

	}

	@Override
	public String getCourseListByInstructionId(Long InstId) {
		List<Teaches> teach = new ArrayList<>();

		List<Course> course = new ArrayList<>();

		teach = teachesDao.findByInstructorId(InstId);
		for (Teaches teaches : teach) {
			System.out.println(teaches.getCourseId().getCourseCode());
			course.add(teaches.getCourseId());

		}
		jsonArray = new JSONArray();
		if(list==null)
			System.out.println("list is null");
	    for(Course t: list)
	    {
	    	JSONArray jObj = new JSONArray();
	    	jObj.add(t.getCourseId().toString());
	    	jObj.add(t.getCourseTitle());
	    	jObj.add(t.getCourseCode());
	    	jObj.add(String.valueOf(t.getCredit()));
	    	jObj.add(String.valueOf(t.getSemester()));
	    	jObj.add(String.valueOf(t.getSession()));
	    	jObj.add(t.getAcceptingDept());
	    	jObj.add(t.getOfferingDept());
	    	
	    	
	    	jsonArray.add(jObj);  	
	    	

	    }
	    JSONObject parameters = new JSONObject();

    	parameters.put("draw", 1);

    	parameters.put("recordsTotal", 1 );
    	
    	parameters.put("recordsFiltered", 1 );
    	
    	parameters.put("data", jsonArray);
    	
    	String courseJson = parameters.toJSONString();
    	
		return courseJson;

	}

}