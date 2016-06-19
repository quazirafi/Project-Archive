package com.great.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.great.cms.service.CourseService;


@Controller


public class HomeController {
	
	@Autowired
	private CourseService courseService;
	//@Autowired
	//private TaskService taskService;
	
	@RequestMapping("/hello")
	public String showHello(){
		//System.out.println("Spring - Great Web Hello Controller!");
		return "hello";
	}
	@RequestMapping("/")
	public String showIndex(){
		//System.out.println("Spring - Great Web Hello Controller!");
		return "login";
	}
	
	@RequestMapping("/ajaxstdcourse")
	public String showCourse(){
		//System.out.println("Spring - Great Web Hello Controller!");
		return "stdcourse";
	}
	
	@RequestMapping("/ajaxcourse")
	public String showTeacherCourse(){
		//System.out.println("Spring - Great Web Hello Controller!");
		return "course";
	}
	@RequestMapping("/gototasks")
	public String showTasks(Model model, @RequestParam("course_id") int courseId){
		model.addAttribute("course_id", courseId);
		model.addAttribute("course_code", courseService.getCourseById(courseId));
		return "tasks";
	}

	@RequestMapping("/gotostdtasks")
	public String showstdTasks(Model model, @RequestParam("course_id") int courseId){
		model.addAttribute("course_id", courseId);
		model.addAttribute("course_code", courseService.getCourseById(courseId));
		return "stdtasks";
	}

	@RequestMapping(value="/projectgroups")
	public String showProjectGroup(Model model, @RequestParam("task_id")int taskId){
		System.out.println("Project Group  Page Mapping");
		model.addAttribute("task_id", taskId);
		System.out.println("task id in project groups: " + taskId);
		//return "project-groups";
		return "project-groups";
	}
	@RequestMapping(value="/viewAllProject")
	public String viewProjectGroupstd(Model model){
		System.out.println("Project Group  Page Mapping");
		
		//return "project-groups";
		return "ViewAllProjectInStudent";
	}
	
	@RequestMapping(value="/projectstdgroups")
	public String showstdProjectGroup(){
		System.out.println("student Project Group  Page Mapping");
		
		//return "project-groups";
		return "student-project-groups";
	}
	
	@RequestMapping("/submissions")
	public String showSubmission(){
		//System.out.println("Submission Page Mapping");
		return "submission";
	}
	@RequestMapping("/stdsubmissions")
	public String showstudentSubmission(){
		System.out.println("Submission Page Mapping");
		return "stdsubmission";
	}
	
}