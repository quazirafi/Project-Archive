package com.great.cms.db.dao;

import com.great.cms.db.entity.Department;

/**
 * @author ziniapc
 *
 */
public interface DepartmentDao extends GenericDao<Department, Integer> {
	
	
	public Department findByDeptCode(String deptCode);
	
    
	
	

}
