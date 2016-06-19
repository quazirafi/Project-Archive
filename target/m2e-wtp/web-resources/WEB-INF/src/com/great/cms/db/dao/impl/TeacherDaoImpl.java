package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.TeacherDao;
import com.great.cms.db.entity.Teacher;
//Tested
@Repository("TeacherDao")
public class TeacherDaoImpl extends GenericDaoImpl <Teacher, Long>implements TeacherDao {

	public TeacherDaoImpl() {
		super(Teacher.class);
		
	}

	@Override
	public Teacher findByUserId(Long userId)  {
		Teacher teacher = new Teacher();
		try{
			String query = "select o from " + type.getName() + " o where"
					+ " o.userId.userId = ?1";
			teacher=(Teacher) em.createQuery(query).setParameter(1, userId).getResultList().get(0);
		}catch(Exception e){
			System.out.println("*******Fail*********");
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
			
		}
		System.out.println("***********Success*********");
		
		return teacher;
	}

	@Override
	public Teacher findByEmployeeCode(String code) {
		
		Teacher teacher = null;
		try{
			String query = "select o from "+type.getName()+ " o where o.employeeCode = "+code;
			teacher=(Teacher)em.createQuery(query).getResultList().get(0);
		}catch(Exception e){
			System.out.println("******fail********");
			
		}
		System.out.println("***********success*********");
		
		return teacher;
	}

	@Override
	public List<Teacher> findByDesigId(Integer desigId) {
		
		List<Teacher> teacher = null;
		try{
			String query = "select o from "+type.getName()+ " o where o.desigId.desigId = "+desigId;
			teacher=em.createQuery(query).getResultList();
		}catch(Exception e){
			System.out.println("******fail********");
			
		}
		    System.out.println("***********success*********");
		
		return teacher;
	}

	@Override
	public List<Teacher> findByDeptId(Integer deptId) {
		
		
		List<Teacher> teacher = null;
		try{
			String query = "select o from "+type.getName()+ " o where o.deptId.deptId = "+deptId;
			teacher=em.createQuery(query).getResultList();
		}catch(Exception e){
			System.out.println("******fail********");
			
		}
		System.out.println("***********Success*********");
		
		return teacher;
	}


}
