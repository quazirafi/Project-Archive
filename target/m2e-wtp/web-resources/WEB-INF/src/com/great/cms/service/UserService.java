package com.great.cms.service;

import java.util.List;

import com.great.cms.db.entity.User;

public interface UserService {

	public User getUserByID(Integer id);
	public User getUserByName(String userName);
	
	//this is done for practicing purposes
	public List<User> getAllUser();

}

