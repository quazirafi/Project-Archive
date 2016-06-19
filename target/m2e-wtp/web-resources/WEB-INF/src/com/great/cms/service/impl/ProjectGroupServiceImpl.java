package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.bean.GroupBean;
import com.great.cms.bean.GroupInputBean;
import com.great.cms.db.dao.GroupsDao;
import com.great.cms.db.dao.ProjectDao;
import com.great.cms.db.dao.ProjectGroupDao;
import com.great.cms.db.dao.StudentDao;
import com.great.cms.db.dao.StudentGroupDao;
import com.great.cms.db.dao.TaskDao;
import com.great.cms.db.entity.Groups;
import com.great.cms.db.entity.Project;
import com.great.cms.db.entity.ProjectGroup;
import com.great.cms.db.entity.Student;
import com.great.cms.db.entity.StudentGroup;
import com.great.cms.db.entity.Task;
import com.great.cms.service.ProjectGroupService;

@Service("ProjectGroupService")
public class ProjectGroupServiceImpl implements ProjectGroupService,Serializable{

	@Autowired
	private ProjectGroupDao projectGroupDao;
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private GroupsDao groupsDao;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentGroupDao studentGroupDao;
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public List<GroupBean> findGroupsByProjectId(int projectId) {
		
		List<ProjectGroup> projectGroupList = projectGroupDao.findAll();
		List<GroupBean> groupList = new ArrayList();
		if(projectGroupList!=null)
		for(ProjectGroup pg : projectGroupList)
		{
			// this if statement filters the groups
			if(pg.getProjectId().getProjectId() == projectId){
				GroupBean gb = new GroupBean();
				gb.setGroupId(pg.getGroupId().getGroupId());
				gb.setGroupName(pg.getGroupId().getGroupName());
				
					List<String> memberList = new ArrayList<>();
					List <StudentGroup> members = studentGroupDao.findStudentByGroupId(gb.getGroupId());
					if( !members.isEmpty() )
					for(StudentGroup sg : members)
						memberList.add("" + sg.getStudentId().getRegistrationNo() );
					
				gb.setMemberList((ArrayList<String>) memberList);
				groupList.add(gb);
			}
		}
		return groupList;
	}

	// Discarded method:
	@Override
	public void addGroupOfProject(int projectId, String groupName,
			List<Student> studentList,int taskId) {
		Groups group;
		group = new Groups();
		group.setGroupName(groupName);
		group.setTaskId(taskDao.findById(taskId));
		groupsDao.save(group);
		for(Student s: studentList)
		{
			StudentGroup studentGroup = new StudentGroup();
			studentGroup.setGroupId(group);
			studentGroup.setStudentId(s);
			studentGroupDao.save(studentGroup);
			
			
		}
		ProjectGroup projGrp = new ProjectGroup();
		projGrp.setGroupId(group);
		projGrp.setProjectId(projectDao.findById(projectId));
		
		projectGroupDao.save(projGrp);
		
	}
	
	@Override
	public void addGroup(GroupInputBean groupInputBean, int projectId) {
		Project project = this.projectDao.findById(projectId);
		// Getting the first element of TaskProjectList because
		// it is expected that there will always be only one element in the list.
		// Each Project is mapped to One TaskProject only.
		
		// Save the Group entity
		Task taskId = project.getTaskProjectList().get(0).getTaskId();
		Groups group = new Groups();
		
		// set a random group name, since we're not taking group name as input and it must be unique
		
		Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<7; i++)
	    	sb.append( (char) (random.nextInt((122-65) + 1) + 65) );
		group.setGroupName(sb.toString());
		group.setTaskId(taskId);
		this.groupsDao.save(group);
		
		// Save the ProjectGroup entity
		ProjectGroup projectGroup = new ProjectGroup();
		projectGroup.setGroupId(group);
		projectGroup.setProjectId(project);
		this.projectGroupDao.save(projectGroup);
		
		// Save all StudentGroup entities for this Group
		Student student;
		for(int reg : groupInputBean.getMemberRegList()){
			student = this.studentDao.getStudentByRegNo(reg);
			if(student != null){
				
				StudentGroup studentGroup = new StudentGroup();
				studentGroup.setStudentId(student);
				studentGroup.setGroupId(projectGroup.getGroupId());
				this.studentGroupDao.save(studentGroup);
			}
		}
	}

	@Override
	public void editGroupOfProject(int groupId, List<Student> studentList) {
		
		Groups group = groupsDao.findById(groupId);
		
		List<StudentGroup> studgroupList= studentGroupDao.findStudentByGroupId(groupId);
		
		for(StudentGroup sg:studgroupList )
		{
			studentGroupDao.delete(sg);
		}
		for(Student s: studentList)
		{
			StudentGroup studentGroup =new StudentGroup();
			studentGroup.setGroupId(group);
			studentGroup.setStudentId(s);
			studentGroupDao.save(studentGroup);	
		}		
	}
	
	@Override
	public void editGroup(GroupInputBean groupInputBean) {
		// TODO Auto-generated method stub
		Groups group = groupsDao.findById(groupInputBean.getGroupId());
		List<StudentGroup> studentGroupList = studentGroupDao.findStudentByGroupId(groupInputBean.getGroupId());
		for(StudentGroup sg:studentGroupList )
			studentGroupDao.delete(sg);
		for(int reg : groupInputBean.getMemberRegList()){
			Student student = this.studentDao.getStudentByRegNo(reg);
			if(student != null){
				
				StudentGroup studentGroup = new StudentGroup();
				studentGroup.setStudentId(student);
				studentGroup.setGroupId(group);
				this.studentGroupDao.save(studentGroup);
			}
		}
		
	}

	@Override
	public void deleteGroupOfProject(int groupId) {
		groupsDao.deleteById(groupId);
		
	}

	@Override
	public int findProjectGroupIdByGroupId(int groupId) {
		int projectGroupId=0;
		List<ProjectGroup> projectGroupList = projectGroupDao.findAll();
		if(projectGroupList!=null)
		for(ProjectGroup pg : projectGroupList)
		{
			// this if statement filters the groups
			if(pg.getGroupId().getGroupId() == groupId){
				projectGroupId = pg.getProjectGroupId();
			}
		}
		return projectGroupId;
	}	
	
	@Override
	public String findProjectTitleByGroupId(int groupId) {
		String projectTitle=null;
		List<ProjectGroup> projectGroupList = projectGroupDao.findAll();
		if(projectGroupList!=null)
		for(ProjectGroup pg : projectGroupList)
		{
			// this if statement filters the groups
			if(pg.getGroupId().getGroupId() == groupId){
				projectTitle = pg.getProjectId().getProjectTitle();
			}
		}
		return projectTitle;
	}	
}