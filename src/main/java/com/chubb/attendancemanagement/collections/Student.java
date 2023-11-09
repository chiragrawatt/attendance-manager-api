package com.chubb.attendancemanagement.collections;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Document(collection = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@ToString
public class Student {
	@Id
	private String studentId;
	private String name;
	private String rollNo;
	private String email;
	private String phone;
	private List<Attendance> attendanceRecord;
}
