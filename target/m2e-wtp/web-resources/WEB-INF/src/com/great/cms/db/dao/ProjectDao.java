package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Project;

public interface ProjectDao extends GenericDao<Project, Integer> {

	@Override
	List<Project> findAll();
}
