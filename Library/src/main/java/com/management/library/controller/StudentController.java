package com.management.library.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.library.entity.College;
import com.management.library.entity.Student;
import com.management.library.service.CollegeService;
import com.management.library.service.StudentService;
import com.management.library.util.FormatedDate;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@Autowired
	private CollegeService collegeService;

	@Autowired
	private FormatedDate dte;

	@RequestMapping(value = "/students")
	public String addStudent(@RequestParam Map<String, String> var) throws NumberFormatException, ParseException {
		String name = var.get("name");
		String dateOfBirth = var.get("dob");
		String collegeId = var.get("clgId");
		College college = collegeService.getColleges(collegeId);
		Student student = new Student(name, dte.dateOfBirth(dateOfBirth), college);
		String flag = studentService.addStudent(student);
		return flag;

	}

	@RequestMapping(value = "/students/{studentId}")
	public Student getStudentInfo(@PathVariable String studentId) {
		Student student = studentService.getStudentInfo(Integer.parseInt(studentId));
		return student;

	}

	@RequestMapping(value = "/getAllStudents")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@RequestMapping(value = "/students/{studentId}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable Integer studentId) {
		return studentService.deleteStudent(studentId);
	}
}
