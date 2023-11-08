package com.chubb.attendancemanagement.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.chubb.attendancemanagement.collections.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
	
}
