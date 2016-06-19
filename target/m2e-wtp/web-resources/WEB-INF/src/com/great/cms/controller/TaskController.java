package com.great.cms.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.great.cms.bean.TaskBean;
import com.great.cms.db.dao.StudentDao;
import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.Task;
import com.great.cms.db.entity.User;
import com.great.cms.service.CourseTaskService;
import com.great.cms.service.ExamCommitteeService;
import com.great.cms.service.TaskService;
import com.great.cms.service.TaskTypeService;


@SessionAttributes("UserRole")
@Controller

public class TaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private TaskTypeService taskTypeService;
	@Autowired
	private CourseTaskService courseTaskService;
	@Autowired
	private ExamCommitteeService examCommitteeService;


	JSONArray jsonArray;
    
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxtasks")
	public @ResponseBody
	String getTaskList(Model model,@RequestParam("course_id")int courseId) {
		System.out.println("TeacherCourse Id in Task Controller: "+courseId);
		
		// TODO: static list of tasks displayed for course_id 1, change to dynamic
		List<Task> tasks = taskService.getTaskListByCourseId(courseId);
		
		model.addAttribute("tasks", tasks);
		
		jsonArray = new JSONArray();
		if (tasks == null)
			System.out.println("TaskController : LIST IS NULL");

		for (Task t : tasks) {
			JSONArray jObj = new JSONArray();
			jObj.add(t.getTaskId().toString());
			jObj.add(t.getTaskTitle());
			/*
			 * if( t.getTaskTypeId().getTaskTypeId()==1) jObj.add("Project");
			 * else jObj.add("Assignment");
			 */
			//jObj.add(t.getTaskTypeId().getTaskTypeId());
			switch(t.getTaskTypeId().getTaskTypeId()){
			case 1:
				jObj.add("Assignment");
				break;
			case 2:
				jObj.add("Project");
				break;
			case 3:
				jObj.add("Thesis");
			}
			jObj.add(t.getTaskDesc());
			jObj.add(t.getTaskDeadline().toString());
			jObj.add(String.valueOf(t.getIsOpen()));
			jObj.add(String.valueOf(t.getTaskTotalGroupNo()));
			jObj.add(String.valueOf(t.getTaskTotalSubmissonNo()));

			jsonArray.add(jObj);

		}
		JSONObject parameters = new JSONObject();

		parameters.put("draw", 1);

		parameters.put("recordsTotal", 1);

		parameters.put("recordsFiltered", 1);

		parameters.put("data", jsonArray);

		String taskJson = parameters.toJSONString();

		// System.out.print("DLSJDHSLKJDH:  "+taskJson);
		return taskJson;

	}
	
	
	
	@RequestMapping(value = "/edittask", method = RequestMethod.POST)
	public @ResponseBody
	String updateTask(TaskBean taskBean, BindingResult result) {
		taskService.updateTask(taskBean);
		return "{ \"success\" : true }";

	}
	
	@RequestMapping(value = "/addtask", method = RequestMethod.POST)
	public @ResponseBody
	String addTask(TaskBean taskBean, BindingResult result, @RequestParam("course_id") int courseId) {
		System.out.println("TaskController.java: Calling the addTask() method");
		//taskBean.setSession(2011);
		taskService.saveTask(taskBean, courseId);
		return "{ \"success\" : true }";
	}

	@RequestMapping(value = "/deletetask", method = RequestMethod.POST)
	public @ResponseBody
	String deletetask(@RequestParam("taskId") int id) {

		taskService.deleteTaskById(id);
		
		return "{ \"success\" : true }";
	}
	
	@RequestMapping(value = "/getsessions", method = RequestMethod.GET)
	public @ResponseBody String getSessionList(){
		String data =  examCommitteeService.getAllSession();
		//System.out.println("Session data in controller: " + data);
		return "{\"Result\":\"OK\",\"Options\":" + data + "}";
		//return data;
	}

	
}
