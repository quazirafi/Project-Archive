package com.great.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.great.cms.db.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	@Override
	public List<Course> findAll();

	public Course findByCourseId(Integer courseId);

	public List<Course> findBySession(int session);

	public Course findByCourseCode(String courseCode);

	public Course findByCourseTitle(String courseTitle);

	public List<Course> findByCredit(double credit);
}
