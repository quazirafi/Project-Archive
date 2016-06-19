package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.Teacher;


/**
 * @author ziniapc
 *
 */
public interface TeacherDao extends GenericDao<Teacher, Long> {
	
	public Teacher findByUserId(Long userId)throws RuntimeException;
	
	public Teacher findByEmployeeCode(String code) throws RuntimeException;
	
	public List<Teacher> findByDesigId(Integer desigId)throws RuntimeException;
	
	public List<Teacher> findByDeptId(Integer deptId);
	
	

}
