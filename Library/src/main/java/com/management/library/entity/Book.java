package com.management.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	private String name;

	public Book() {

	}

	public Book(String name) {
		super();
		this.name = name;
	}

	@Column(name = "BOOK_ID")
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

//	@Column(name = "BOOK_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
