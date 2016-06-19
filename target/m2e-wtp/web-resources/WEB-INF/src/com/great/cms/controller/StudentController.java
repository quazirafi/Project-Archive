package com.great.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.great.cms.repository.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@RequestMapping("/student")
	public String showStudents(Model model) {
		model.addAttribute("students", studentRepository.findAll());
		return "student";
	}

	@RequestMapping("/profile")
	public String showStudent(Model model, @RequestParam("regNo") int regNo) {
		System.out.println("RegNo: " + regNo);
		return "profile";
	}

}
