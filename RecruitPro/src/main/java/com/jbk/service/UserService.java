package com.jbk.service;

import com.jbk.dao.LoginRequest;
import com.jbk.entities.User;

public interface UserService {
	public int createuser(User user);
	public User getUsername(String Username);
	public int deleteUser(String username);
	public User LoginUser(LoginRequest loginrequest);
}
