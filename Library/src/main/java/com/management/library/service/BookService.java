package com.management.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.library.entity.Book;
import com.management.library.entity.Student;
import com.management.library.repo.BookRepo;
import com.management.library.repo.StudentRepo;

@Service
public class BookService {
	@Autowired
	private BookRepo bkk;

	@Autowired
	private StudentRepo stu;

	public String addBook(Book book) {
		try {
			bkk.save(book);
		} catch (Exception e) {
			return "you can't add book";
		}
		return "book successfully saved";
	}

	public String assginBook(String bookName, Integer studentId) {

		Student student = stu.findById(studentId).get();
		Book book = bkk.findByName(bookName);
		if (book == null || student == null) {
			return "Record not found";
		}
		student.getBooks().add(book);
		stu.save(student);
		return "Book assign successfully";
	}

	public List<Book> getAllBooks() {
		List<Book> books = (List<Book>) bkk.findAll();
		return books;
	}

	public String updateBook(Integer bookId, Book book) {

		if (!bkk.existsById(bookId)) {
			return "unable to fetch the record";
		}
		Book books = bkk.findById(bookId).get();
		books.setName(book.getName());
		try {
			bkk.save(books);
		} catch (Exception e) {
			return "Something went wrong";
		}

		return "book name successfully updated";
	}

}
