package com.kata.series.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.series.model.Courses;

public interface CoursesRepository extends JpaRepository<Courses,Integer> {

}
