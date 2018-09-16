package com.management.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.library.entity.College;
import com.management.library.service.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	

	@RequestMapping(value = "/colleges/{collegeName}")
	public String addCollege(@PathVariable("collegeName") String collegeName) {
		College college = new College(collegeName);
		String flag = collegeService.addCollege(college);
		return flag;
	}

}
