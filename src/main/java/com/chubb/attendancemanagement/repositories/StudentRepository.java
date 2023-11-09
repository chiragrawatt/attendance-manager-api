package com.chubb.attendancemanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chubb.attendancemanagement.collections.Student;


public interface StudentRepository extends MongoRepository<Student, String> {
	
	@Query("{rollNo: ?0}")
	public Student getStudentByRollNo(String rollNo);
}
