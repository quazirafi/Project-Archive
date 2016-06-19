package com.great.cms.controller.StdController;
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

public class StudentTaskController {

	
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
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxstdtasks")
	public @ResponseBody
	String getstdTaskList(Model model,@RequestParam("course_id")int courseId, @ModelAttribute("UserRole") User user) {
		try{

			System.out.println("StudentCourse Id in student Task Controller: "+courseId);
				
				// TODO: static list of tasks displayed for course_id 1, change to dynamic
				
				List<Task> tasks = taskService.getTaskListByCourseId(courseId);
				/*Student student=getRegistration(username);
				System.out.println("registration id" +student.getRegistrationNo());*/
				model.addAttribute("tasks", tasks);
				System.out.println("User in taskcontroller" +user.getUserName());
				//model.addAttribute("username", user);
				
				//model.addAttribute("student", student);
				
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
		catch(Exception e){
			System.out.println("Somting error"+e);
			
			return null;
		}

	}
}
