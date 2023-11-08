package com.chubb.attendancemanagement.collections;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;

@Document(collection = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
	@Id
	private String studentId;
	private String name;
	private String email;
	private List<Attendance> attendanceRecord;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Attendance> getAttendanceRecord() {
		return attendanceRecord;
	}
	public void setAttendanceRecord(List<Attendance> attendanceRecord) {
		this.attendanceRecord = attendanceRecord;
	}
	public Student(String studentId, String name, String email, List<Attendance> attendanceRecord) {
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.attendanceRecord = attendanceRecord;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", attendanceRecord="
				+ attendanceRecord + "]";
	}

}
