package com.spring.courses.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "author_id")
	private long authorId;
	private String authorName;
	private String email;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bookid", nullable = false)
	private Book book;
}
