package com.great.cms.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.great.cms.bean.GroupBean;
import com.great.cms.bean.GroupInputBean;
import com.great.cms.service.ProjectGroupService;

@Controller
public class GroupController {

	@Autowired
	private ProjectGroupService projectGroupService;
	
	private JSONArray jsonArray;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxgroups")
	public @ResponseBody
	String getGroupListbyProjectId(@RequestParam("project_id") int projectID) {

		System.out
				.println("GroupController  -> getGroupListbyProjectId");

		//List<Groups> groupList = null;
		List<GroupBean> groupList = null;
		if( (Object) projectID == null)
			projectID = 0;
		
		groupList = projectGroupService.findGroupsByProjectId(projectID);

		System.out.println("GroupController  -> groupList " + groupList);

		// model.addAttribute("submissions",submissionList);

		jsonArray = new JSONArray();

		if (groupList == null)
			System.out
					.println("GroupController  -> getGroupListbyProjectId : LIST IS NULL");
		if (groupList.size() == 0)
			System.out
					.println("GroupController  -> getGroupListbyProjectId : LIST IS EMPTY");

		for(GroupBean grp : groupList){
			JSONArray jsonObj = new JSONArray();
			jsonObj.add(grp.getGroupId());
			jsonObj.add(grp.getGroupName());
				JSONArray memberArray = new JSONArray();
				for(String member : grp.getMemberList())
					memberArray.add(member);
			jsonObj.add(memberArray);
			
			jsonArray.add(jsonObj);
		}

		JSONObject parameters = new JSONObject();
		parameters.put("draw", 1);
		parameters.put("recordsTotal", 1);
		parameters.put("recordsFiltered", 1);
		parameters.put("data", jsonArray);
		String groupJson = parameters.toJSONString();
		System.out.print("Json Data:  " + groupJson);
		return groupJson;
	}
	
	
	
	

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxstdgroups")
	public @ResponseBody
	String getstdGroupListbyProjectId(@RequestParam("project_id") int projectID) {

		System.out
				.println("GroupController  -> getGroupListbyProjectId");

		//List<Groups> groupList = null;
		List<GroupBean> groupList = null;
		if( (Object) projectID == null)
			projectID = 0;
		
		groupList = projectGroupService.findGroupsByProjectId(projectID);

		System.out.println("GroupController  -> groupList " + groupList);

		// model.addAttribute("submissions",submissionList);

		jsonArray = new JSONArray();

		if (groupList == null)
			System.out
					.println("GroupController  -> getGroupListbyProjectId : LIST IS NULL");
		if (groupList.size() == 0)
			System.out
					.println("GroupController  -> getGroupListbyProjectId : LIST IS EMPTY");

		for(GroupBean grp : groupList){
			JSONArray jsonObj = new JSONArray();
			jsonObj.add(grp.getGroupId());
			jsonObj.add(grp.getGroupName());
				JSONArray memberArray = new JSONArray();
				for(String member : grp.getMemberList())
					memberArray.add(member);
			jsonObj.add(memberArray);
			
			jsonArray.add(jsonObj);
		}

		JSONObject parameters = new JSONObject();
		parameters.put("draw", 1);
		parameters.put("recordsTotal", 1);
		parameters.put("recordsFiltered", 1);
		parameters.put("data", jsonArray);
		String groupJson = parameters.toJSONString();
		System.out.print("Json Data:  " + groupJson);
		return groupJson;
	}
	@RequestMapping(value="/addgroup",method=RequestMethod.POST)
    public @ResponseBody String addGroup(GroupInputBean groupInputBean,
    		@RequestParam("project_id")int projectId)
    {
		System.out.println("ProjectGroupController  -> addgroup");		
		projectGroupService.addGroup(groupInputBean, projectId);
		return "{ \"success\" : true }";
    }
	
	@RequestMapping(value="/updategroup",method=RequestMethod.POST)
    public @ResponseBody String editGroup(GroupInputBean groupInputBean )
    {
		System.out.println("GroupController  -> editgroup");	
		//projectGroupService.editGroupOfProject(groupId, studentList);
		projectGroupService.editGroup(groupInputBean);
		return "{ \"success\" : true }";
    }
	
	@RequestMapping(value="/deletegroup",method=RequestMethod.POST)
    public @ResponseBody String deleteGroup(@RequestParam("group_id") int groupId  )
    {
		System.out.println("GroupController  -> deletegroup");
		
		projectGroupService.deleteGroupOfProject(groupId);
		
		return "{ \"success\" : true }";
    }
	

}