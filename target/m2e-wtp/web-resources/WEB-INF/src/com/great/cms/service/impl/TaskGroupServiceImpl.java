package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.GroupsDao;
import com.great.cms.db.dao.StudentGroupDao;
import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.StudentGroup;
import com.great.cms.db.entity.Task;
//import com.great.cms.db.entity.TaskProject;
import com.great.cms.service.TaskGroupService;
//import com.great.cms.service.GroupsService;

@Service("TaskGroupService")
public class TaskGroupServiceImpl implements TaskGroupService,Serializable{

	@Autowired
	private GroupsDao groupsDao;
	
	@Autowired
	private StudentGroupDao studentGroupDao;
	
	@Override
	public List<Groups> findGroupsByTaskID(int taskId){
		
		System.out.println("findGroupsByTaskIDCalled, id = " + taskId);
		List <Groups> list = null;
		ArrayList<Groups> groupList = new ArrayList <Groups>();
		
		try{
			list = groupsDao.getGroupsByTaskID(taskId);
			
			for(Groups group : list){
				
				System.out.println("group id = " + group.getGroupId() + 
									"task = " + group.getTaskId().getTaskDesc());
				
			}
			
		}catch(Exception e){
			System.out.println("TaskGroupService failed error = ");
			e.printStackTrace();
			return null;
		}
		return list;
	}


	@Override
	public void addNewGroupOfTask(Task taskId, String groupName,
			List<Student> student) {
		Groups group;
		group = new Groups();
		group.setGroupName(groupName);
		group.setTaskId(taskId);
		groupsDao.save(group);
		for(Student s: student)
		{
			StudentGroup studentGroup =new StudentGroup();
			studentGroup.setGroupId(group);
			studentGroup.setStudentId(s);
			studentGroupDao.save(studentGroup);
			
			
		}
		
		
		
	}


	@Override
	public void editGroupofTask(int groupId, List<Student> studentList) {
		Groups grps = groupsDao.findById(groupId);
		List<StudentGroup> stdgrpList= studentGroupDao.findStudentByGroupId(groupId);
		for(StudentGroup sg:stdgrpList )
		{
			studentGroupDao.delete(sg);
		}
		for(Student s: studentList)
		{
			StudentGroup studentGroup =new StudentGroup();
			studentGroup.setGroupId(grps);
			studentGroup.setStudentId(s);
			studentGroupDao.save(studentGroup);
			
			
		}
		
		
	}


	@Override
	public void deleteGroupTask(int groupId) {
		groupsDao.deleteById(groupId);
		
	}
	

}
