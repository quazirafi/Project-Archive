package com.great.cms.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.great.cms.service.SubmissionService;

@Controller
public class SubmissionController {
	
	// TODO: Redirect to another page if there is no download file
    // TODO: Auto Reload With Updated values in the table after we edit.
	// TODO: Please Fix the Date Picking thing.
	
	
	@Autowired
	private SubmissionDao submissionDao;

	@Autowired
	private SubmissionService submissionService;

	@Autowired
	private ProjectGroupSubmitService projGrpSubService;

	private JSONArray jsonArray;

	@SuppressWarnings("unchecked")
	@RequestMapping(method = RequestMethod.GET, value = "/ajaxsubmissions")
	public @ResponseBody
	String getSubmissionList(Model model, @RequestParam("group_id") int groupId) {
		System.out.println("Group Id: "+groupId);
		List<Submission> submissionList = null;

		submissionList = projGrpSubService
				.findSubmissionListByProjectGroupId(groupId);
		
		jsonArray = new JSONArray();

		if (submissionList == null)
			System.out
					.println("Hellllo Submission Controller -> getSubmissionList : LIST IS NULL");

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
		//return "ProjectFileView";

	}

	
	// Updating Submissions
	@RequestMapping(value = "/editsubmission", method = RequestMethod.POST)
	public @ResponseBody
	String editSubmission(SubmissionBean submissionBean,
			@RequestParam("file") MultipartFile multipartFile,
			@RequestParam("submissionId") int submissionId)
			throws FileNotFoundException {
        		
		submissionService.updateSubmissionWithFile(submissionBean,multipartFile,submissionId);
		return "{ \"success\" : true }";
	}
	
	

	// Adding Submissions
	//addsubmissionnofile
	@RequestMapping(value = "/addsubmission", method = RequestMethod.POST)
	public @ResponseBody
	String doUpload(SubmissionBean submissionBean,
			@RequestParam("file") MultipartFile multipartFile)
			throws FileNotFoundException {
		System.out
				.println("We're in addSubmission/doUpload method.\nfilename: "
						+ multipartFile.getOriginalFilename() + "\nComment: "
						+ submissionBean.getCommentTeacher());
		//Uploading file to a specific folder//

		// InputStream inputStream = null;
		 //FileOutputStream outputStream =null;
		
		 //if(multipartFile.getSize()>0){
		// try {
		// inputStream = multipartFile.getInputStream();
		// outputStream = new
		// FileOutputStream("G:\\Work\\Upload Repo\\"+multipartFile.getOriginalFilename());
		// int readBytes = 0;
		// byte[] buffer = new byte[8192];
		// while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
		// System.out.println("===ddd=======");
		// outputStream.write(buffer, 0, readBytes);
		// }
		// outputStream.close();
		// inputStream.close();
		//
		//
		//
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		// }

		// Saving the Submission Entity//
		submissionService.saveSubmission(submissionBean, multipartFile);

		// projGrpSubService.addProjectGroupSubmit(submission, 2,
		// multipartFile);
		return "Uploaded: " + multipartFile.getSize() + " bytes";
	}
	
	@RequestMapping(value = "/addsubmissionnofile", method = RequestMethod.POST)
	public @ResponseBody
	String doUploadWithNoFile(SubmissionBean submissionBean)
	{
		System.out.println("Add Submission with no file-Controller Layer");

		submissionService.saveSubmission(submissionBean);
		return "{ \"success\" : true }";
	}
	
	@RequestMapping(value = "/editsubmissionnofile", method = RequestMethod.POST)
	public @ResponseBody
	String doUploadEditWithNoFile(SubmissionBean submissionBean,@RequestParam("submissionId")int submissionId)
	{
		System.out.println("Edit Submission with no file upload hit in the Controller layer");

		submissionService.updateSubmission(submissionBean,submissionId);
		return "{ \"success\" : true }";
	}
	
	

	@RequestMapping(value = "/downloadfile", method = RequestMethod.GET)
	public @ResponseBody
	String provideDownloadable(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		System.out.println("Download file path: "
				+ request.getParameter("filename"));

		// submissionService.updateSubmission(submission);

		// Downloading the File
		System.out.println("File Name: "+request.getParameter("filename"));

		try {
			File file = new File("F:/Work/Upload Repo/"
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

	@RequestMapping(value = "/deletesubmission", method = RequestMethod.POST)
	public @ResponseBody
	String deleteSubmission(@RequestParam("submissionId") int submissionId) {

		submissionService.deleteSubmission(submissionId);
		return "{ \"success\" : true }";
	}

}