package com.management.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.library.entity.Student;
import com.management.library.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo stu;

	public String addStudent(Student student) {
		try {
			stu.save(student);
		} catch (Exception e) {
			return "Something went wrong";
		}
		return "Student successfully added";
	}

	public Student getStudentInfo(Integer studentId) {
		Student student = stu.findById(studentId).get();
		return student;
	}

	public List<Student> getAllStudent() {
		return (List<Student>) stu.findAll();
	}

	public String deleteStudent(Integer studentId) {

		try {
			stu.deleteById(studentId);
		} catch (Exception e) {
			return "Unable to process your request";
		}
		return "Student Successfully delete in your records";
	}

}
