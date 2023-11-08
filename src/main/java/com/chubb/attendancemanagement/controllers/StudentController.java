package com.chubb.attendancemanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chubb.attendancemanagement.collections.Student;
import com.chubb.attendancemanagement.services.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping()
	public List<Student> get() {
		return studentService.getAllStudents();
	}
	
	@PostMapping
	@RequestMapping("/save")
	public Student save(@RequestBody Student student) {
		return studentService.save(student);
	}
}
