package com.chubb.attendancemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chubb.attendancemanagement.collections.Attendance;
import com.chubb.attendancemanagement.collections.Student;
import com.chubb.attendancemanagement.services.StudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public List<Student> get() {
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{studentId}")
	public Student getStudentById(@PathVariable String studentId) {
		return studentService.getStudentById(studentId);
	}
	
	@PostMapping("/add")
	public Student save(@RequestBody Student student) {
		System.out.println(student);
		return studentService.save(student);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.update(student);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public boolean deleteStudent(@PathVariable String studentId) {
		return studentService.deleteStudent(studentId);
	}
	
	@PostMapping("/mark/{rollNo}")
	public Student markAttendance(@PathVariable String rollNo, @RequestBody Attendance attendanceRecord) {
		return studentService.markAttendance(rollNo, attendanceRecord);
	}
}
