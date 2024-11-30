package com.jbk.service;

import java.util.List;

import com.jbk.entities.Student;


public interface StudentService {
	
	public int Create(Student student);
	public Student getStudent(int id);
	public List<Student> getAllStudent();
	public int DeleteStudent(int id);
	public int createMultipleStudent(List<Student> liststudent);
	public int updateStudent(Student student);
}
