package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.StudentDao;
import com.great.cms.db.entity.Student;

@Repository("StudentDao")
public class StudentDaoImpl extends GenericDaoImpl<Student, Integer> implements StudentDao {

	public StudentDaoImpl() {
		super(Student.class);
	}

	@Override
	public Student getStudentByRegNo(int registrationNo) {
		Student student;
		String query = "select o from " + type.getName()
				+ " o where o.registrationNo = ?1";
		try {
			student = (Student) em.createQuery(query)
					.setParameter(1, registrationNo)
					.getResultList().get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;		
		}
		return student;
	}

	@Override
	public Student getStudentByUserId(Long userId) {
		
		Student student;
		String query = "select o from " + type.getName()
				+ " o where o.userId.userId = ?1";
		try {
			student = (Student) em.createQuery(query)
					.setParameter(1, userId)
					.getResultList().get(0);
			
		} catch (Exception e) {
			System.out.println("eroor in hql "+ e);
			return null;		
		}
		return student;
	}
}
