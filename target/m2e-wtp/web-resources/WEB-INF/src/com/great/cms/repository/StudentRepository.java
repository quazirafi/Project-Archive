package com.great.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.great.cms.db.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Override
	public List<Student> findAll();
	//public Student findByIdStudent(Integer studentId);
	//public Student findByName(String name);
	public Student findByRegistrationNo(int regNo);
}
