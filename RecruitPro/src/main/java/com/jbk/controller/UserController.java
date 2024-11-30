package com.jbk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.User;
import com.jbk.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	 
	@PostMapping("/create-user")
	public String userModule(@RequestBody @Valid User user) {
		int status = userServiceImpl.createuser(user);
		System.out.println("Status =>" + status);
		switch (status) {
		case 1: {
			return"successful";
			
		}
		case 2: {
			return"not successful";
			
		}
		case 3: {
			return"error";
			
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + status );
		}
	}
	
	@DeleteMapping("/delete-user")
	public String deleteUser(@RequestParam String username) {
		int status = userServiceImpl.deleteUser(username);
		System.out.println("Status =>" + status);
		switch (status) {
		case 1: {
			return"deleted successful";
			
		}
		case 2: {
			return"not exixts";
			
		}
		case 3: {
			return"error";
			
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + status );
		}
	}
	@GetMapping("/by-username/{username}")
	public Object getUserName(@PathVariable @Valid String username) {
		User user = userServiceImpl.getUsername(username);
		if(user!=null) {
			return user;
			
		}else {
			return "user not find =" + username;
		}
	}

}
