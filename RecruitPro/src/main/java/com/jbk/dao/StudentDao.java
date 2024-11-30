package com.jbk.dao;

import java.util.List;

import com.jbk.entities.Student;
import com.jbk.entities.User;

public interface StudentDao {

	public int studentdao(Student student);
	
	public Student getStudent(int id);
	
	public List <Student> getAllStudent();
	
	public int DeleteStudent(int id);
	
	public int createMultipleStudent(List<Student> liststudent);
	
	public int updateStudent(Student student);
}
