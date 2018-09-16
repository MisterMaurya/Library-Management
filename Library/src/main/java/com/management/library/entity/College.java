package com.management.library.entity;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {

	private Integer id;
	private String collegeName;
	private Collection<Student> student = new HashSet<>();

	public College() {

	}

	public College(String collegeName) {
		super();
		this.collegeName = collegeName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COLLEGE_ID")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "COLLEGE_NAME")
	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@OneToMany(mappedBy = "college")
	public Collection<Student> getStudent() {
		return student;
	}

	public void setStudent(Collection<Student> student) {
		this.student = student;
	}

}
