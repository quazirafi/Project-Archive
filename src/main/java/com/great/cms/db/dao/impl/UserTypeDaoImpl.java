package com.great.cms.db.dao.impl;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.UserTypeDao;
import com.great.cms.db.entity.UserType;

//Tested
@Repository("UserType")
public class UserTypeDaoImpl extends GenericDaoImpl<UserType, Integer> implements UserTypeDao {
	

	public UserTypeDaoImpl( ) {
		super(UserType.class);
		
	}

	@Override
	public UserType findByUserTypeName(String Name) {
		UserType user = null;
		try{
			user = (UserType) em.createQuery("select o from " + type.getName() + " o where o.userTypeName="+Name+" ").getResultList().get(0);
 	
 		}
		catch(Exception e){
			System.out.println("*******failure*******");
        }
		    System.out.println("*******successful*****");
		return user;
		
		
	}

	
    
}
