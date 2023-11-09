package com.chubb.attendancemanagement.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chubb.attendancemanagement.collections.Attendance;
import com.chubb.attendancemanagement.collections.Student;
import com.chubb.attendancemanagement.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student markAttendance(String rollNo, Attendance attendance) {
		Student student = null;
		try {
			student = studentRepository.getStudentByRollNo(rollNo);
			Attendance storedAttendance = student.getAttendanceRecord().stream()
					.filter(att -> att.getDate().equals(attendance.getDate()))
					.findFirst().orElse(null);
			System.out.println("attendance" + storedAttendance);
			
			if(storedAttendance==null) {
				student.getAttendanceRecord().add(attendance);
			} else {
				int idx = student.getAttendanceRecord().indexOf(storedAttendance);
				student.getAttendanceRecord().set(idx, attendance);
			}
			studentRepository.save(student);
		} catch (Exception e) {
			System.out.println(e);
		}
		return student;
	}

	@Override
	public Student getStudentById(String studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public Student update(Student student) {
		System.out.println(student);
		Student currStudent = studentRepository.findById(student.getStudentId()).get();
		currStudent.setName(student.getName());
		currStudent.setEmail(student.getEmail());
		currStudent.setPhone(student.getPhone());
		studentRepository.save(currStudent);
		return student;
	}

	@Override
	public boolean deleteStudent(String studentId) {
		try {
			studentRepository.deleteById(studentId);
			return true;
		} catch(Exception ex) {
			System.out.println(ex);
		}
		return false;
	}
}
