package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.ProjectGroupSubmit;

public interface ProjectGroupSubmitDao extends GenericDao<ProjectGroupSubmit, Integer> {
	
	public List<ProjectGroupSubmit> getSubmissionByProjectGroup(int projectGroupId);
}