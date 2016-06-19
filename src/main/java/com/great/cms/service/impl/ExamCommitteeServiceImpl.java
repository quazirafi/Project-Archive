package com.great.cms.service.impl;


import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.great.cms.db.dao.ExamCommitteeDao;
import com.great.cms.db.entity.ExamCommittee;
import com.great.cms.service.ExamCommitteeService;

@Service("ExamCommitteeService")
public class ExamCommitteeServiceImpl implements ExamCommitteeService{
	
	@Autowired
	ExamCommitteeDao examCommitteeDao;

	@Override
	public String getAllSession() {
		List<ExamCommittee> list = this.examCommitteeDao.findAll();
		JSONArray array = new JSONArray();
		for(ExamCommittee examCommittee : list){
			array.add(examCommittee.getSession());
		}
		System.out.println("The array here is:\n" + array.toJSONString());
		return array.toJSONString();
	}

}
