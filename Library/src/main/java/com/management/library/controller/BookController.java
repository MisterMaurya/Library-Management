package com.management.library.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.library.entity.Book;
import com.management.library.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bkk;

	@RequestMapping(value = "/books")
	public String addBook(@RequestParam Map<String, String> var) {
		String name = var.get("name");
		Book book = new Book(name);
		return name + " " + bkk.addBook(book);
	}

	@RequestMapping(value = "/map")
	public String assginBook(@RequestParam Map<String, String> var) {
		return bkk.assginBook(var.get("bookName"), Integer.parseInt(var.get("studentId")));
	}

	@RequestMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		return bkk.getAllBooks();
	}

	@RequestMapping(value = "/books/{bookId}", method = RequestMethod.PUT)
	public String updateBook(@PathVariable Integer bookId, @RequestBody Book book) {
		return bkk.updateBook(bookId, book);
	}
}
