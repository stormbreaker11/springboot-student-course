package com.spring.courses.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity(name = "studentdb")
@ToString
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	private String studentName;
	private String studentEmail;

	@OneToMany(mappedBy = "courseid", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Courses> courses;

}
