package com.jbk.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entities.User;
import com.jbk.exceptions.ResourceNotFoundException;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public int userdao(User user) {

		Session session = sessionFactory.openSession();
		User dbUser = session.get(User.class, user.getUsername());
	    try {
	    	if(dbUser == null) {
				session.save(user);
				session.beginTransaction().commit();
				return 1;
			}else {
				return 2;
			}
		} catch (Exception e) {

			e.printStackTrace();
			return 3;
		}
	}

	@Override
	public User getUsername(String Username) {
		Session session = sessionFactory.openSession();
		User user=null;
		user = session.get(User.class, Username);
		if(user!=null) {
			return user;
		}else {
			throw new ResourceNotFoundException("User not found "+Username);
		}
	}

	@Override
	public int deleteUser(String username) {
		Session session = sessionFactory.openSession();
		User user=null;
		try {
			user = session.get(User.class, username);
			if(user!=null) {
				session.delete(user);
				return 1;
			}else {
				return 2;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 3;
	}

	@Override
	public User LoginUser(LoginRequest loginrequest) {
		try {
			Session session = sessionFactory.openSession();
			User dbuser = session.get(User.class, loginrequest.getUsername());
			if(dbuser!=null) {
				if(dbuser.getPassword().equals(loginrequest.getPassword())) {
					return dbuser;
				}
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	

}


