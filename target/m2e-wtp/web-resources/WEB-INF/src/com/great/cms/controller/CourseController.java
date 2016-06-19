package com.great.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.great.cms.db.entity.Task;
import com.great.cms.db.entity.User;
import com.great.cms.service.CourseRegistrationService;
import com.great.cms.service.CourseService;
import com.great.cms.service.TaskService;
import com.great.cms.service.UserService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	TaskService taskService;

	@Autowired
	private CourseRegistrationService courseRegistrationService;

	JSONArray jsonArray;
	
	

	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxcourse")
	public @ResponseBody
	String getCourse(@RequestParam("username") String username, Model model) {

		System.out.println("In course Controller");
		User user = userService.getUserByName(username);
		model.addAttribute("username", username);
		model.addAttribute("user",user);
		// TODO: use username to return filtered course list
		List<Course> courses = null;
		courses = courseService.getCourseListByUserType(user);
		
     System.out.println("courseController " +user.getUserName());
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
		System.out.println(taskJson);
		System.out.println("going to teacher course page course");
		return taskJson;
	}
	
	
	//initialization of public view
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/publicview",method=RequestMethod.GET)
	public String tester(@RequestParam(value="session",required=false) String rsession,
			Model model,HttpSession courseSession){
		System.out.println("INISDE");
		int session;
		if (rsession!=null)
			session = Integer.parseInt(rsession);
		else
			session = 2011;
		courseSession.setAttribute("courseSession", session);
		System.out.println(rsession);
		List<Course> courses = (List<Course>) courseService.getCourseBySession(session);
		for (Course c:courses)
			System.out.println(c);
		model.addAttribute("courses",courses);
		
		return "publicview";
				
	}
	
	
	
	@RequestMapping(value="/courseTaskViewReq",method=RequestMethod.GET)
	public String tester2(Model model,HttpSession session,@RequestParam("courseId") String strCourseId){
		int courseId = Integer.parseInt(strCourseId);
		int currentSession = Integer.parseInt(session.getAttribute("courseSession").toString());
		String courseTitle = courseService.getCourseById(courseId);
		//model.addAttribute("courseTitle", courseTitle);
		session.setAttribute("courseTitle",courseTitle);
		System.out.println(courseTitle);
		List<Task> tasks = taskService.getTaskListByCourseId(courseId);
		model.addAttribute("tasks", tasks);
		return "CourseTaskView";
	}
}