package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.TeachesDao;
import com.great.cms.db.entity.Teaches;
//Tested
@Repository("TeachesDao")
public class TeachesDaoImpl extends GenericDaoImpl<Teaches, Integer> implements TeachesDao {

	public TeachesDaoImpl() {
		super(Teaches.class);
		
	}

	@Override
	public List<Teaches> findByInstructorId(Long InstructorId) throws RuntimeException {
		List<Teaches> list = null;
		try{
			String query="select o from "+type.getName()+ " o where o.instructorId.instructorId = "+InstructorId;
			list = em.createQuery(query).getResultList();
			
	}catch(Exception e){
			System.out.println("*******fail******"+e.getMessage());
			
		}
	        System.out.println("*******Success********");
		return list;
	}

	@Override
	public Teaches findByCourseId(Integer courseId) throws RuntimeException {
		
		Teaches list = null;
		try{
			String query="select o from "+type.getName()+ " o where o.courseId.courseId = "+courseId;
			list = (Teaches)em.createQuery(query).getResultList();
			
	}catch(Exception e){
			System.out.println("*******fail******");
		}
	        System.out.println("*******success********");
		return list;
	}



}
