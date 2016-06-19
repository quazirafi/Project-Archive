package com.great.cms.controller.StdController;


import java.util.ArrayList;
import java.util.List;

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

import com.great.cms.bean.ProjectBean;
import com.great.cms.db.dao.ProjectDao;
import com.great.cms.db.dao.ProjectGroupDao;
import com.great.cms.db.dao.StudentDao;
import com.great.cms.db.dao.StudentGroupDao;
import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.Project;
import com.great.cms.db.entity.ProjectGroup;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.StudentGroup;
import com.great.cms.db.entity.User;
import com.great.cms.service.TaskProjectService;

@SessionAttributes("UserRole")
@Controller
public class StudentProjectController {
	
	
	@Autowired
	private TaskProjectService taskProjectService;

	@Autowired
	private UserDao userDao;
	@Autowired
	private StudentDao stdDao;

	@Autowired
	private StudentGroupDao stdGrpDao;

	@Autowired
	private ProjectGroupDao pgd;

	@Autowired
	private ProjectDao pg;

	private JSONArray jsonArray;

	
	// get porject for student
	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxstdprojects")
	public @ResponseBody String getProjectListforstd(Model model, @RequestParam("task_id") int taskId,
			@ModelAttribute("UserRole") User user)

	{
		System.out.println("StudentProjectController");
		Student std = stdDao.getStudentByUserId(user.getUserId());
        System.out.println("student name "+std.getFirstName());
		StudentGroup stdGrp = null;
		List<Project> projectList = null;

		projectList = findByStudentId(std.getStudentId(), taskId);

		// System.out.println("Project Controller -> getProjectList " +
		// projectList);

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
	
	
public List<Project> findByStudentId(int studentId, int taskId) {

		

		try {
			// taskAllProject
			List<Project> allprojectList =new ArrayList<>(); 
			allprojectList = taskProjectService.findProjectsByTaskID(taskId);
			// allgroup of that student
			List<StudentGroup> stdgrp = stdGrpDao.findGroupByStudentId(studentId);
			for(StudentGroup sg:stdgrp){
				//System.out.println("All student group "+sg.getGroupId().getGroupId());
			}

			List<ProjectGroup> allpg = pgd.findAll();
			for(ProjectGroup pg:allpg){
				//System.out.println("All"+pg.getProjectId().getProjectTitle());
			}

			 List<ProjectGroup> taskProjectGroup=new ArrayList<>();

			// project group of that task
			System.out.println("Project group of that task");
			for (Project p2 : allprojectList) {
				for (ProjectGroup p1 : allpg) {
					if (p2.getProjectId() == p1.getProjectId().getProjectId()) {
                        //System.out.println("Project group matches "+p1.getProjectId().getProjectTitle()+" group id "+p1.getProjectGroupId());
						taskProjectGroup.add(p1);
                        
					}
					else{
						System.out.println("nothing matches" +p1.getProjectId().getProjectTitle());
					}
				}

			}
			// project group of that student
			List<ProjectGroup> stdprjgrp = new ArrayList<>();;
			// project of that student
			List<Project> stdProject = new ArrayList<>();;

			// getting project-group of that student
			for (ProjectGroup p : allpg) {
				for (StudentGroup s : stdgrp) {
					if (p.getGroupId().getGroupId() == s.getGroupId().getGroupId()) {
						System.out.println("Project group matches by studentId"+p.getProjectId().getProjectTitle());
						stdprjgrp.add(p);
						

					}
					else
						System.out.println("something wrong");

				}

			}

			for (ProjectGroup p3 : stdprjgrp) {
				for (ProjectGroup p4 : taskProjectGroup) {
					if (p3.getProjectId().getProjectId() == p4.getProjectId().getProjectId()) {
						stdProject.add(p3.getProjectId());
						//System.out.println("project name matches" + p3.getProjectId().getProjectTitle());
					}
					
					else
						System.out.println("wrong again");
				}

			}

			return stdProject;
		} catch (Exception e) {
			System.out.println("exception in studentprojectController");
			e.printStackTrace();
			return null;
		}

	}

}
