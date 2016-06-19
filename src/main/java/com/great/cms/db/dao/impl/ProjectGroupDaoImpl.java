package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.ProjectGroupDao;
import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.ProjectGroup;


@Repository("ProjectGroupDao")
public class ProjectGroupDaoImpl extends GenericDaoImpl<ProjectGroup, Integer> implements ProjectGroupDao{

	public ProjectGroupDaoImpl() {
		super(ProjectGroup.class);
	}

	@Override
	public List<ProjectGroup> findByProjectId(int projectId) {
	
		List<ProjectGroup> pr=null;
		
		//public ConfUser getConfUserByAccctMsisdn(long acctMsisdn){
		System.out.println("We are in ProjectGroupDao");
			try{
				//courseReg = (CourseRegistration) em.createQuery("select o from " + type.getName() + " o where o.idStudent.idStudent ="+id+" ").getResultList();
				String query = "select o from " + type.getName() + " o where " +
     				   "o.projectId.projectId = ?1 " ;
     	   pr =em.createQuery(query)
       			 .setParameter(1, projectId)
       			 .getResultList();
     	
     	
     		}
			catch(Exception e){
				System.out.println("*******failure******* trace of error "+ e);
				return null;
	        }
			System.out.println("*******successful*******");
			return pr;
	
	}

	@Override
	public List<ProjectGroup> findByGroupId(int groupId) {
List<ProjectGroup> pr=null;
		
		//public ConfUser getConfUserByAccctMsisdn(long acctMsisdn){
		System.out.println("We are in ProjectGroupDao");
			try{
				//courseReg = (CourseRegistration) em.createQuery("select o from " + type.getName() + " o where o.idStudent.idStudent ="+id+" ").getResultList();
				String query = "select o from " + type.getName() + " o where " +
     				   "o.groupId.groupId = ?1 " ;
     	   pr =em.createQuery(query)
       			 .setParameter(1, groupId)
       			 .getResultList();
     	
     	
     		}
			catch(Exception e){
				System.out.println("*******failure******* trace of error "+ e);
				return null;
	        }
			System.out.println("*******successful*******");
			return pr;
	}

}
