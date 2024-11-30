package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.dao.LoginRequest;
import com.jbk.entities.User;
import com.jbk.service.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/login-user")
	public Object loginUser(@RequestBody LoginRequest loginRequest) {
	    System.out.println("in between");
		User user = userServiceImpl.LoginUser(loginRequest);
		if(user != null) {
			return user;
		}else {
			return "Invalid Credientials!!";
		}
	}
}