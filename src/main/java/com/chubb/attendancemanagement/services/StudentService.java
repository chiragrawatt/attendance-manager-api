package com.chubb.attendancemanagement.services;

import java.util.List;

import com.chubb.attendancemanagement.collections.Attendance;
import com.chubb.attendancemanagement.collections.Student;


public interface StudentService {
	
	public Student save(Student student);
	
	public Student update(Student student);
	
	public List<Student> getAllStudents();
	
	public Student getStudentById(String studentId);
	
	public Student markAttendance(String rollNo, Attendance attendance);
	
	public boolean deleteStudent(String studentId);
}
