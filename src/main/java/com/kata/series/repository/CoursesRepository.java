package com.kata.series.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.series.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses,Integer> {

	public List<Courses> findByOrderByNameDesc();
	
	public List<Courses> findByOrderByName();
}
