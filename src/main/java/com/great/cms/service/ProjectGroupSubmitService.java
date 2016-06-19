package com.great.cms.service;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.great.cms.db.entity.Submission;
public interface ProjectGroupSubmitService {

		public List<Submission> findSubmissionListByProjectGroupId(int projectGroupId);
		public void addProjectGroupSubmit(Submission submission,int projectGroupID,MultipartFile multipartFile);
		public void updateProjectGroupSubmit(Submission submission, int projectGroupID);
		
        
}
