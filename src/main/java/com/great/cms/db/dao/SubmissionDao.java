package com.great.cms.db.dao;

import com.great.cms.db.entity.Submission;

public interface SubmissionDao extends GenericDao<Submission, Integer>{

	public Submission findByVersionAndTime(int version,String time);
}
