package com.great.cms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.User;
import com.great.cms.service.UserService;

@Service("UserService")
public class UserServiceImpl implements UserService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1928575921848237676L;

	@Autowired
	UserDao userDao;
	
	@Override
	public User getUserByID(Integer id) {
		
		User user;
		
		user = userDao.findById(id);
		
		if(user == null) System.out.println("user is null");
		return user;
	}

	@Override
	public User getUserByName(String userName) {
		User user= null;
		
		user=userDao.findUserByName(userName);
		
		if(user == null) System.out.println("user is null");
		return user;
	}
	
	@Override
	public List<User> getAllUser() {
		List<User> users = null;
		
		users=userDao.findAllUser();
		
		if(users == null) System.out.println("user is null");
		return users;
	}


}

