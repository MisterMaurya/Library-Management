package com.management.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.library.entity.College;
import com.management.library.repo.CollegeRepo;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepo clg;

	public String addCollege(College college) {
		try {
			clg.save(college);
		} catch (Exception e) {
			return "Something went wrong";
		}
		return "college Successfully added";

	}

	public College getColleges(String collegeId) {
		return clg.findById(Integer.parseInt(collegeId)).get();
	}

}
