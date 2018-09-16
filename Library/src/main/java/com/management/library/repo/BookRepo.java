package com.management.library.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.management.library.entity.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {

	@Query("SELECT u FROM Book u WHERE u.name = ?1")
	public Book findByName(String bookName);

}
