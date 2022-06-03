package com.spring.courses.util;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.courses.model.Book;

public class FindAllBooksByCourse {

	public static List<Book> findBooks(long id, List<Book> findBooksByCourse) {
		List<Book> collect = findBooksByCourse.stream().filter(b -> b.getCourses().getCourseid() == id)
				.collect(Collectors.toList());
		return collect;
	}
}
