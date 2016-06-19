package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.GroupsDao;
import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.Task;

@Repository("GroupsDao")
public class GroupsDaoImpl extends GenericDaoImpl<Groups, Integer> implements GroupsDao {

	public GroupsDaoImpl() {
		super(Groups.class);
	}

	@Override
	public List<Groups> getGroupsByTaskID(int taskId) {
		List<Groups> list = null;
		 Task t = new Task (taskId);
		String query = "select o from " + type.getName() + " o where " +
				   "o.taskId.taskId = ?1 ";
		list=em.createQuery(query)
				 .setParameter(1, taskId)
				 .getResultList();
		
		return list;
	}

}

