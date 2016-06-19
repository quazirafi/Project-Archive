package com.great.cms.db.dao.impl;


import org.springframework.stereotype.Repository;
import com.great.cms.db.dao.DepartmentDao;
import com.great.cms.db.entity.Department;

@Repository("DepartmentDao")
public class DepartmentDaoImpl extends GenericDaoImpl<Department, Integer> implements DepartmentDao {

	public DepartmentDaoImpl() {
		super(Department.class);
	}
	
	
	@Override
	public Department findByDeptCode(String deptCode) {
		Department list = null;
			try{
				String query = "select o from " + type.getName() + " o where " +
     				   "o.deptCode = ?1 " +
     				   "order by o.deptCode ";
     	list = (Department)em.createQuery(query)
     			 .setParameter(1, deptCode)
     			 .getResultList().get(0);
     	
     	
     		}
			catch(Exception e){
				System.out.println("Exception in findByDeptCode,dept code = "+deptCode + " error trace : ");
				e.printStackTrace();
				return null;
	        }
			    System.out.println("findByDeptCode was successful");
			    return list;
	}

	
}
