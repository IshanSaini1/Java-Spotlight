package com.kata.series.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kata.series.model.Holiday;

@Repository
public class HolidayRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public HolidayRepository(@Autowired DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Holiday> fetchAllHolidays() {
		var rowMapper = BeanPropertyRowMapper.newInstance(Holiday.class);
		return jdbcTemplate.query("SELECT * FROM holidays", rowMapper);
	}
}
