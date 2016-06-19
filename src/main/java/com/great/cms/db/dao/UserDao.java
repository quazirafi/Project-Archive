/**
 * 
 */
package com.great.cms.db.dao;

import java.util.List;

import com.great.cms.db.entity.User;

/**
 * @author ziniapc
 *
 */
public interface UserDao extends GenericDao<User, Integer> {


	
	
	
	public User findUserByName(String Name);
	
	public User findByEmail(String Email);
	
	//this method is created for practicing purposes
	public List<User> findAllUser();
	
	

	
}
