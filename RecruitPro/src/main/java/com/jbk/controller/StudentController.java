package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entities.Student;
import com.jbk.entities.User;
import com.jbk.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentServiceImpl studentServiceImpl;
	@PostMapping("/create")
	public String StudentModule(@RequestBody Student student) {
		int status = studentServiceImpl.Create(student);
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
	@GetMapping("/fetch/{id}")
	public Object getStudent(@PathVariable int id) {
		Student student = studentServiceImpl.getStudent(id);
		if(student!=null) {
			return student;
			
		}else {
			return "user not find";
		}
	}
	@GetMapping("/show-student")
	public List <Student> getAllStudent(){
		List <Student> list=studentServiceImpl.getAllStudent();
		if(!list.isEmpty()) {
			return list;
		}else {
			return null;
		}
	}
		
	@DeleteMapping("/delete-student/{id}")
	public String DeleteUser(@PathVariable int id) {
		int status = studentServiceImpl.DeleteStudent(id);
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
	@PostMapping("/create-multiplestudent")
	public String createMultipleStudent(@RequestBody List<Student> stdlist) {
		int status = studentServiceImpl.createMultipleStudent(stdlist);
		System.out.println("ststus =="+status);
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
	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) {
	    int status = studentServiceImpl.updateStudent(student);
	    switch (status) {
	        case 1:
	            return "Update successful";
	        case 2:
	            return "Student not found";
	        case 3:
	            return "Error during update";
	        default:
	            throw new IllegalArgumentException("Unexpected value: " + status);
	    }
	}

	}
	



