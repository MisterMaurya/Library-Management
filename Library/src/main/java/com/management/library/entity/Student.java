package com.management.library.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {

	private Integer id;
	private String name;
	private Date dateOfBirth;
	private College college;
	private Collection<Book> books = new HashSet<>();

	public Student() {

	}

	public Student(Integer id, Collection<Book> books) {
		super();
		this.id = id;
		this.books = books;
	}

	public Student(String name, Date dateOfBirth, College college) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.college = college;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_OF_BIRTH")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "COLLEGE_ID")
	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@ManyToMany
	@JoinTable(name = "STUDENT_BOOK", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "BOOK_ID") })

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

}
