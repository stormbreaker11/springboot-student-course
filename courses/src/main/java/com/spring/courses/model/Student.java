package com.spring.courses.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "studentdb")
@ToString
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private long studentId;
	private String studentName;
	private String studentEmail;

	/*
	 * @OneToMany(mappedBy = "courseid", fetch = FetchType.LAZY, cascade =
	 * CascadeType.ALL)
	 * 
	 * @JoinColumn( name = "courseid")
	 * 
	 */
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "student_id", referencedColumnName = "studentId")
	private Set<Courses> courses;

}
