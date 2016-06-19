package com.great.cms.controller.StdController;


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

import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.User;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.CourseService;
import com.great.cms.service.UserService;



@Controller
public class StudentCourseController {
	
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private CourseRegistrationService courseRegistrationService;

	JSONArray jsonArray;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxstdcourse")
	public @ResponseBody
	String getStdCourse(@RequestParam("username") String username ,Model model) {

		System.out.println("In course Controller");
		User user = userService.getUserByName(username);
		// TODO: use username to return filtered course list
		List<Course> courses = null;
		courses = courseService.getCourseListByUserType(user);
		model.addAttribute("username", username);
		model.addAttribute("user",user);
     System.out.println("courseController" +user.getUserName());
		jsonArray = new JSONArray();
		if (courses == null)
			System.out.println("CourseController : LIST IS NULL");

		for (Course c : courses) {
			JSONArray jObj = new JSONArray();
			jObj.add(c.getCourseId());
			jObj.add(c.getCourseCode());
			jObj.add(c.getCourseTitle());
			jObj.add(c.getCredit());
			jsonArray.add(jObj);
		}
		JSONObject parameters = new JSONObject();

		parameters.put("draw", 1);
		parameters.put("recordsTotal", 1);
		parameters.put("recordsFiltered", 1);
		parameters.put("data", jsonArray);
		String taskJson = parameters.toJSONString();

		System.out.println("going to course page std course");
		return taskJson;
	}
	

}
