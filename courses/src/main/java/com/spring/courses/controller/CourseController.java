package com.spring.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.courses.model.Courses;
import com.spring.courses.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("course")
@SecurityRequirement(name="course")
public class CourseController {

	@Autowired
	private CourseService service;

	@Operation(summary = "This is to Fetch All Courses from Database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = " Fetches all Course from database", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", description = " Page Not Found", content = @Content) })

	@GetMapping("/allcourses")
	public ResponseEntity<?> findAllStudent() {
		return new ResponseEntity<List<Courses>>(service.getAllCourses(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(value = "id") long courseId) {
		Courses findCourseById = service.findCourseById(courseId);
		if (findCourseById == null) {
			return new ResponseEntity<String>("No Course Found With Id " + courseId, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Courses>(findCourseById, HttpStatus.OK);
	}

}
