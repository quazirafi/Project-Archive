package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.SubmissionDao;
import com.great.cms.db.entity.Submission;

@Repository("SubmissionDao")
public class SubmissionDaoImpl extends GenericDaoImpl<Submission, Integer>
		implements SubmissionDao {

	public SubmissionDaoImpl() {
		super(Submission.class);
	}

	@Override
	public Submission findByVersionAndTime(int version, String time) {

		System.out.println("findByVersionAndTime Called");
		Submission submission = null;
		

		// String query = "select sub from "+ type.getName()+" sub where " +
		// "sub.submissionVer =? 1"
		// + "	and sub.submissionTime = ?2";
		
		String query = "select s from " + type.getName()
				+ " s where s.submissionTime like :time";
		
		try {
			submission = (Submission) em.createQuery(query)
										.setParameter("time", time)
										.getResultList()
										.get(0);
			
			
		} catch (Exception e) {
			
			System.out.println("Exception in findByVersionAndTime, time = "
							+ time + " version = " + version + " error trace : ");
			e.printStackTrace();
			return null;
		}
		
		System.out.println("findByVersionAndTime successful, time = "
				+ time + " version = " + version + " error trace : ");

		System.out.println("submission = " + submission);
		return submission;
	}
}
