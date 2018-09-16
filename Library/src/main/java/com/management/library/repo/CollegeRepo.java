package com.management.library.repo;

import org.springframework.data.repository.CrudRepository;

import com.management.library.entity.College;

public interface CollegeRepo extends CrudRepository<College, Integer> {

	

}
