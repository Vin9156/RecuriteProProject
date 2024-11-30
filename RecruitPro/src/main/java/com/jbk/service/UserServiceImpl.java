package com.jbk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.LoginRequest;
import com.jbk.dao.UserDaoImpl;
import com.jbk.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Override
	public int createuser(User user) {
		int status = userDaoImpl.userdao(user);
		return status;
	}


	@Override
	public User LoginUser(LoginRequest loginrequest) {
		User user = userDaoImpl.LoginUser(loginrequest);
		return user;

}


	@Override
	public int deleteUser(String username) {
		int status = userDaoImpl.deleteUser(username);
		return status;
	}


	@Override
	public User getUsername(String Username) {
		User user = userDaoImpl.getUsername(Username);
		return user;
	}
}
