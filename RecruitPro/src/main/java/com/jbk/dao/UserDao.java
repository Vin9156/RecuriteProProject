package com.jbk.dao;

import com.jbk.entities.User;

public interface UserDao {

	public int userdao(User user);
	
	public User getUsername(String Username);
	
	public int deleteUser(String username);
	
	public User LoginUser(LoginRequest loginrequest);
}
