package com.great.cms.service;


import java.util.List;

import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.Task;

public interface TaskGroupService {
	public List<Groups> findGroupsByTaskID(int taskId);
	public void addNewGroupOfTask(Task taskId,String groupName, List<Student> student);
	public void editGroupofTask(int groupId, List<Student> studentList);
	public void deleteGroupTask(int groupId);
	
	
		
}