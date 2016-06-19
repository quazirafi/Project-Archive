package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Teaches;

/**
 * @author ziniapc
 *
 */
public interface TeachesDao extends GenericDao<Teaches, Integer>{
	
	public List<Teaches> findByInstructorId(Long InstructorId) throws RuntimeException;
	
	public Teaches findByCourseId(Integer courseId) throws RuntimeException;

}
