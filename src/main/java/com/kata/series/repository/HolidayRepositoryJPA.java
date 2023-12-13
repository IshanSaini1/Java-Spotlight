package com.kata.series.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.series.model.Holiday;

@Repository
public interface HolidayRepositoryJPA extends JpaRepository<Holiday, String> {

}
