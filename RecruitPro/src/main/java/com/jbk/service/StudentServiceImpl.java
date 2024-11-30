package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.StudentDaoImpl;
import com.jbk.entities.Student;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDaoImpl studentDaoImpl;
	@Override
	public int Create(Student student) {
		int status = studentDaoImpl.studentdao(student);
		
		return status;
	}
	@Override
	public Student getStudent(int id) {
		Student student = studentDaoImpl.getStudent(id);
		
		return student;
	}
	@Override
	public List<Student> getAllStudent() {
		List<Student> student=studentDaoImpl.getAllStudent();
		return student;
	}
	@Override
	public int DeleteStudent(int id) {
		int status = studentDaoImpl.DeleteStudent(id);
		return status;
	}
	@Override
	public int createMultipleStudent(List<Student> liststudent) {
		int multipleStudent = studentDaoImpl.createMultipleStudent(liststudent);
		return multipleStudent;
	}
	@Override
	public int updateStudent(Student student) {
		
		    int updateStudent = studentDaoImpl.updateStudent(student);
		    return updateStudent;
		}

	}


