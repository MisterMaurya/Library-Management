package com.management.library.repo;

import org.springframework.data.repository.CrudRepository;

import com.management.library.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Integer>{
	
	
}
