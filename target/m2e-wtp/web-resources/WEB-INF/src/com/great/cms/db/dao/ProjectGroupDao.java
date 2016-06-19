package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.ProjectGroup;

public interface  ProjectGroupDao extends GenericDao<ProjectGroup, Integer> {
   public List<ProjectGroup>  findByProjectId(int projectId);
   public List<ProjectGroup>  findByGroupId(int groupId);
}
