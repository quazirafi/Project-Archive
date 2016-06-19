package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Groups;

public interface GroupsDao extends GenericDao<Groups, Integer> {

	List<Groups> getGroupsByTaskID(int taskId);
	
	
	
}
