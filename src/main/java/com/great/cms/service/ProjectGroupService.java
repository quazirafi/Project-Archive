package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.ProjectGroup;
import com.great.cms.db.entity.Student;
import com.great.cms.bean.GroupBean;
import com.great.cms.bean.GroupInputBean;

public interface ProjectGroupService {
	

	public List<GroupBean> findGroupsByProjectId(int projectId);
	public int findProjectGroupIdByGroupId(int groupId);
	public String findProjectTitleByGroupId(int groupId);
	// Discarded
	public void addGroupOfProject(int projectId, String groupName, List<Student>studentList,int taskId);
	public void addGroup(GroupInputBean groupInputBean, int projectId);
	// Discarded
	public void editGroupOfProject(int groupId, List<Student> studentList);
	public void editGroup(GroupInputBean groupBean);
	public void deleteGroupOfProject(int groupId);
}

