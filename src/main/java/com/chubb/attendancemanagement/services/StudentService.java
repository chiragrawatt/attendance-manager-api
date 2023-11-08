package com.chubb.attendancemanagement.services;

import java.util.List;

import com.chubb.attendancemanagement.collections.Student;


public interface StudentService {
	
	public Student save(Student student);
	
	public List<Student> getAllStudents();
}
