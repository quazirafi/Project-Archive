package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.ProjectGroupSubmitDao;
import com.great.cms.db.entity.ProjectGroupSubmit;

@Repository("ProjectGroupSubmitDao")
public class ProjectGroupSubmitDaoImpl extends
		GenericDaoImpl<ProjectGroupSubmit, Integer> implements
		ProjectGroupSubmitDao {

	public ProjectGroupSubmitDaoImpl() {
		super(ProjectGroupSubmit.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectGroupSubmit> getSubmissionByProjectGroup(
			int projectGroupId) {
		
		List<ProjectGroupSubmit> list = null;

		String query = "select o from " + type.getName() + " o where "
				+ "o.projectGroupId.projectGroupId = ?1 ";
		try {
			list = em.createQuery(query)
					.setParameter(1, projectGroupId)
					.getResultList();
			
		} catch (Exception e) {
			
			System.out.println("getSubmissionByProjectGroup Failed. projectGroupId= "
							+ projectGroupId + " error trace :");
			
			e.printStackTrace();
			
			return null;
		}
		
		System.out.println("getSubmissionByProjectGroup succesful. projectGroupId   = "+ projectGroupId);
		return list;

	}

}
