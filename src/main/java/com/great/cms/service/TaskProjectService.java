package com.great.cms.service;

import java.util.List;

import com.great.cms.bean.ProjectBean;
import com.great.cms.db.entity.Project;

public interface TaskProjectService {
	public List<Project> findProjectsByTaskID(int taskId);
	public List<Project> findProjects(int taskId, String session, String semester);
	public void addProjectOfTask(Project project, int taskId);
	public void updateProject(ProjectBean project);
	public void deleteProjectOfTask(int projectId);
	
		
}

