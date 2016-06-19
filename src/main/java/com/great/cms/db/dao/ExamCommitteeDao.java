package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.ExamCommittee;

public interface ExamCommitteeDao extends GenericDao<ExamCommittee, Integer> {
      public ExamCommittee findBySession(int session);
      public List<ExamCommittee> findBySessionAndSemester(int session, int semester);
}
