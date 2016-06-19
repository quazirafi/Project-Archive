package com.great.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.great.cms.bean.GroupBean;
import com.great.cms.bean.ProjectBean;
import com.great.cms.db.dao.ProjectDao;
import com.great.cms.db.dao.ProjectGroupDao;
import com.great.cms.db.dao.StudentDao;
import com.great.cms.db.dao.StudentGroupDao;
import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.Project;
import com.great.cms.db.entity.ProjectGroup;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.StudentGroup;
import com.great.cms.db.entity.Submission;
import com.great.cms.db.entity.Task;
import com.great.cms.db.entity.User;
import com.great.cms.service.ProjectGroupService;
import com.great.cms.service.ProjectGroupSubmitService;
import com.great.cms.service.TaskGroupService;
import com.great.cms.service.TaskProjectService;

@SessionAttributes("UserRole")
@Controller
public class ProjectController {

	@Autowired
	private TaskProjectService taskProjectService;
	
	@Autowired
	private TaskGroupService taskGroupService;
	
	@Autowired
	private ProjectGroupService projectGroupService;
	
	@Autowired
	private ProjectGroupSubmitService projectGroupSubmitService;

	@Autowired
	private UserDao userDao;
	@Autowired
	private StudentDao stdDao;


	private JSONArray jsonArray;



	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxprojects")
	public @ResponseBody String getProjectList(Model model, @RequestParam("task_id") int taskId,@ModelAttribute("UserRole") User user)
	// @RequestParam(required = false) String session,
	// @RequestParam(required = false) String semester)
	{
		System.out.println("Project Controller -> getProjectList ");
		// System.out.println("Task Id: "+taskId);
		List<Project> projectList = null;

		projectList = taskProjectService.findProjectsByTaskID(taskId);

		// model.addAttribute("submissions",submissionList);

		jsonArray = new JSONArray();

		if (projectList == null)
			System.out.println("Project Controller -> getProjectList : LIST IS NULL");
		if (projectList.size() == 0)
			System.out.println("Project Controller -> getProjectList : LIST IS EMPTY");

		for (Project proj : projectList) {
			JSONArray jsonObj = new JSONArray();
			jsonObj.add(proj.getProjectId().toString());
			jsonObj.add(proj.getProjectTitle());
			jsonObj.add(proj.getProjectDesc());

			// proj.ge

			/*
			 * if( s.getTaskTypeId().getTaskTypeId()==1) jsonObj.add("Project");
			 * else jsonObj.add("Assignment");
			 */

			// System.out.println("proj id : " + proj.getProjectId());

			jsonArray.add(jsonObj);
		}

		JSONObject parameters = new JSONObject();

		parameters.put("draw", 1);

		parameters.put("recordsTotal", 1);

		parameters.put("recordsFiltered", 1);

		parameters.put("data", jsonArray);

		String submissionJson = parameters.toJSONString();

		// System.out.print("DLSJDHSLKJDH: "+taskJson);
		return submissionJson;

	}



	@RequestMapping(value = "/addproject", method = RequestMethod.POST)
	public @ResponseBody String addProject(Project project, @RequestParam("task_id") int taskId) {
		System.out.println("Project Controller -> addproject----------> " + taskId);
		// TODO: to which task are we adding this project!? Current function
		// param is static
		taskProjectService.addProjectOfTask(project, taskId);
		return "{ \"success\" : true }";
	}

	@RequestMapping(value = "/updateproject", method = RequestMethod.POST)
	public @ResponseBody String updateProject(ProjectBean project) {
		System.out.println("Project Controller -> updateProject");
		taskProjectService.updateProject(project);
		return "{ \"success\" : true }";
	}

	@RequestMapping(value = "/deleteproject", method = RequestMethod.POST)
	public @ResponseBody String deleteProject(@RequestParam("projectId") int projectId) {

		taskProjectService.deleteProjectOfTask(projectId);
		return "{ \"success\" : true }";
	}
	
	@RequestMapping(value="/projectViewReq",method=RequestMethod.GET)
	public String tester2(Model model,HttpSession session,@RequestParam(value="taskId",required=false) String strTaskId){
		int taskId = Integer.parseInt(strTaskId);
		List<Project> projects = taskProjectService.findProjectsByTaskID(taskId);
		model.addAttribute("projects", projects);
		model.addAttribute("taskId",taskId);
		return "ProjectView";
	}
	
	@RequestMapping(value="/projectGroupViewReq",method=RequestMethod.GET)
	public String tester3(Model model,HttpSession session,@RequestParam(value="taskId",required=false) String strTaskId){
		System.out.println("INside projectGroupViewReq");
		int taskId = Integer.parseInt(strTaskId);
		List<Groups> groups = taskGroupService.findGroupsByTaskID(taskId);
		for (Groups grp : groups){
			grp.setProjectTitle(projectGroupService.findProjectTitleByGroupId(grp.getGroupId()));
		}
		for (Groups grp : groups){
			System.out.println(grp);
		}
		model.addAttribute("groups", groups);
		model.addAttribute("taskId",taskId);
		return "GroupView";
	}
	
	@RequestMapping(value="/projectGroupView",method=RequestMethod.GET)
	public String tester4(Model model,HttpSession session,@RequestParam(value="projectId") String strProjectId,@RequestParam(value="projectTitle") String projectTitle){
		int projectId = Integer.parseInt(strProjectId);
		List<GroupBean> projectGroup = projectGroupService.findGroupsByProjectId(projectId);
		model.addAttribute("projectGroup", projectGroup);
		model.addAttribute("projectTitle",projectTitle);
		return "ProjectGroupView";
	}
	
	@RequestMapping(value="/projectFileView",method=RequestMethod.GET)
	public String tester5(Model model,HttpSession session,@RequestParam(value="groupId") int groupId,@RequestParam(value="projectTitle",required=false) String projectTitle,@RequestParam(value="groupName",required=false) String groupName){
		//int groupId = Integer.parseInt(strGroupId);
		//int projectGroupId = projectGroupService.findProjectGroupIdByGroupId(groupId);
		System.out.println("Group Id is : "+groupId);;
		List<Submission> submissions = null;
		submissions = projectGroupSubmitService.findSubmissionListByProjectGroupId(groupId);
		System.out.println("Hello"+groupId);
		model.addAttribute("projectTitle",projectTitle);
		model.addAttribute("submissions",submissions);
		model.addAttribute("groupName",groupName);
		for (Submission s:submissions)
			System.out.println(s);
		return "ProjectFileView";
	}

}
