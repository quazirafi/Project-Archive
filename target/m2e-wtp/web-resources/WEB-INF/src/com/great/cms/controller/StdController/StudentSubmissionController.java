package com.great.cms.controller.StdController;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.great.cms.bean.SubmissionBean;
import com.great.cms.db.dao.SubmissionDao;
import com.great.cms.db.entity.Submission;
import com.great.cms.service.ProjectGroupSubmitService;
import com.great.cms.service.StudentSubmissionService;
import com.great.cms.service.SubmissionService;

@Controller
public class StudentSubmissionController {
	
	
	@Autowired
	private SubmissionDao submissionDao;

	@Autowired
	private StudentSubmissionService submissionService;

	@Autowired
	private ProjectGroupSubmitService projGrpSubService;

	private JSONArray jsonArray;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxstdsubmissions")
	public @ResponseBody
	String getSubmissionList(Model model, @RequestParam("group_id") int groupId) {
		System.out.println("Student submission controller Group Id: "+groupId);
		List<Submission> submissionList = null;

		submissionList = projGrpSubService
				.findSubmissionListByProjectGroupId(groupId);

		
		jsonArray = new JSONArray();

		if (submissionList == null)
			System.out
					.println("Submission Controller -> getSubmissionList : LIST IS NULL");

		for (Submission s : submissionList) {
			JSONArray jsonObj = new JSONArray();
			jsonObj.add(s.getSubmissionId().toString());
			jsonObj.add(s.getSubmissionTime());
			jsonObj.add(s.getCommentTeacher());
			jsonObj.add(s.getSubmissionUrl());
			/*
			 * if( s.getTaskTypeId().getTaskTypeId()==1) jsonObj.add("Project");
			 * else jsonObj.add("Assignment");
			 */

			jsonArray.add(jsonObj);
		}

		JSONObject parameters = new JSONObject();

		parameters.put("draw", 1);

		parameters.put("recordsTotal", 1);

		parameters.put("recordsFiltered", 1);

		parameters.put("data", jsonArray);

		String submissionJson = parameters.toJSONString();

		return submissionJson;

	}
	

	// Adding Submissions
	//addsubmissionnofile
	@RequestMapping(value = "/addstdsubmission", method = RequestMethod.POST)
	public @ResponseBody
	String doUpload(SubmissionBean submissionBean,
			@RequestParam("file") MultipartFile multipartFile)
			throws FileNotFoundException {
		System.out
				.println("We're in Student addSubmission/doUpload method.\nfilename: "
						+ multipartFile.getOriginalFilename() + "\nComment: "
						+ submissionBean.getCommentTeacher());
		// Uploading file to a specific folder//

		 InputStream inputStream = null;
		 FileOutputStream outputStream =null;
		
		 if(multipartFile.getSize()>0){
		 try {
		 inputStream = multipartFile.getInputStream();
		 outputStream = new
		 FileOutputStream("F:\\300file\\"+multipartFile.getOriginalFilename());
		 int readBytes = 0;
		 byte[] buffer = new byte[8192];
		 while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
		 System.out.println("===ddd=======");
		 outputStream.write(buffer, 0, readBytes);
		 }
		 outputStream.close();
		 inputStream.close();
		//
		//
		//
		//
		 } catch (IOException e) {
		 //TODO Auto-generated catch block
		 e.printStackTrace();
		 }
		//
		 }

		// Saving the Submission Entity//
		submissionService.saveStdSubmission(submissionBean, multipartFile);

		// projGrpSubService.addProjectGroupSubmit(submission, 2,
		// multipartFile);
		return "Uploaded: " + multipartFile.getSize() + " bytes";
	}
	
	
	@RequestMapping(value = "/stddownloadfile", method = RequestMethod.GET)
	public @ResponseBody
	String providestdDownloadable(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("Download file path: "
				+ request.getParameter("filename"));

		// submissionService.updateSubmission(submission);

		// Downloading the File
		System.out.println("File Name: "+request.getParameter("filename"));

		try {
			File file = new File("F:/300file"
					+ request.getParameter("filename") + ".zip");
			
			
			FileInputStream inputStream = new FileInputStream(file);

			// MIME type of the file
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ file.getName() + "\"");

			// Read from the file and write into the response
			ServletOutputStream os = response.getOutputStream();

			byte[] buffer = new byte[1024];
			int len;
			while ((len = inputStream.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}

			os.flush();
			os.close();
			inputStream.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		return "{ \"success\" : true }";
	}

}
