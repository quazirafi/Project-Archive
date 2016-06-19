package com.great.cms.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.great.cms.bean.QuestionBean;
import com.great.cms.db.dao.CourseDao;
import com.great.cms.db.dao.QuestionDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.Question;
import com.great.cms.service.QuestionService;

@Controller

public class QuestionController {

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
    private CourseDao coursedao;
	
	@Autowired
	private QuestionService questionService;

	

	private JSONArray jsonArray;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxquestion")
	public @ResponseBody
	String getSubmissionList(Model model, @RequestParam("course_code") String CourseCode) {
		System.out.println("Course Code"+CourseCode);
		List<Question> list= null;

		Course course=coursedao.findByCourseCode(CourseCode);
		
        list=questionDao.findByCourseId(course.getCourseId());
		
		jsonArray = new JSONArray();

		if (list == null)
			System.out
					.println("Question Controller -> getSubmissionList : LIST IS NULL");

		for (Question s : list) {
			JSONArray jsonObj = new JSONArray();
			QuestionBean bean= new QuestionBean();
			bean.setCourseCode(s.getCourseId().getCourseCode());
			bean.setType(s.getQuestionTypeId().getQuestionTypeName());
			bean.setDeptName(s.getCourseId().getAcceptingDept());
			bean.setSession(s.getCourseId().getSession());
			jsonObj.add(bean.getCourseCode());
			jsonObj.add(bean.getSession());
			jsonObj.add(bean.getType());
			jsonObj.add(bean.getDeptName());
			/*
			 * if( s.getTaskTypeId().getTaskTypeId()==1) jsonObj.add("Project");
			 * else jsonObj.add("Assignment");
			 */

			jsonArray.add(jsonObj);
		}

		JSONObject parameters = new JSONObject();

		parameters.put("draw", 1);

		parameters.put("recordsTotal", 1);

		parameters.put("recordsFiltered", 1);

		parameters.put("data", jsonArray);

		String QuestionJson = parameters.toJSONString();

		return QuestionJson;

	}
	
}
