package com.spring.courses.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseid;
	private String courseName;

	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "book_id") private List<Book> book;
	 */
	/*
	 * @OneToMany(mappedBy = "bookid", cascade = { CascadeType.ALL}) private
	 * Set<Book> book;
	 */
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "course_books", joinColumns = {
			@JoinColumn(name = "course_id", referencedColumnName = "courseid") }, inverseJoinColumns = {
					@JoinColumn(name = "book_id", referencedColumnName = "bookid") })
	private Set<Book> book;

}
