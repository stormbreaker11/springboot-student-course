package com.spring.courses.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Book {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long bookid;
	private String bookname;
	private String bookAuthor;
	private long price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Courses courses;
}
