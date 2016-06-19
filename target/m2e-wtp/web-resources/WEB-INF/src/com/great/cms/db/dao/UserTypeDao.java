package com.great.cms.db.dao;

import com.great.cms.db.entity.UserType;

/**
 * @author ziniapc
 *
 */

public interface UserTypeDao extends GenericDao<UserType, Integer> {
	
	public UserType findByUserTypeName(String Name);

}
