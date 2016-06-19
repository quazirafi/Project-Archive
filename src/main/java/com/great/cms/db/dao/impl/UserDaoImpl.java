package com.great.cms.db.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.great.cms.db.dao.UserDao;
import com.great.cms.db.entity.User;

//Tested
@Repository("User")
public class UserDaoImpl extends GenericDaoImpl<User, Integer>implements UserDao {



	public UserDaoImpl( ) {
		super(User.class);
		
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByName(String Name) {
		User user = null;
		List<User> list = null;
		try{
			String query = "select o from " + type.getName() + " o where " +
  				   "o.userName = ?1 ";
//			user = (User) em.createNamedQuery(query).setParameter(1,Name).getResultList().get(0);
			System.out.println("In userDao    +");
			list = em.createQuery(query)
					.setParameter(1, Name)
					.getResultList();
			user = list.get(0);
			System.out.println("In userDao "+user.getUserName());
 	             
 		}
		catch(Exception e){
			System.out.println("*******failure Exception*******");
			e.printStackTrace();
			return user;
        }
		    System.out.println("*******successful*******");
		return user;
		
	}



	@Override
	public User findByEmail(String Email) {
		User user = null;
		try{
			user = (User) em.createQuery("select o from " + type.getName() + " o where o.userEmail="+Email).getResultList().get(0);
 	
 		}
		catch(Exception e){
			System.out.println("*******failure*******");
        }
		    System.out.println("*******successful*******");
		return user;
		
	}
	
	@Override
	public List<User> findAllUser(){
		List<User> users = null;
		try{
			users = (List<User>) em.createQuery("from User").getResultList();
 	
 		}
		catch(Exception e){
			System.out.println("*******failurehere*******");
        }
		    System.out.println("*******successful*******");
		return users;
	}

}