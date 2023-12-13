package com.kata.series.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDAOImpl implements PersonDAO {

	JdbcTemplate jdbcTemplate;

	public PersonDAOImpl( @Qualifier("h2") DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public Integer countPersonRows() {
		return jdbcTemplate.queryForObject("select count(*) from person", Integer.class);
	}

	@Override
	public Integer countPersonRowsWhereFirstNameis(String firstName) {
		return jdbcTemplate.queryForObject("select count(*) from person where first_name = ?", Integer.class,
				firstName);
	}

	@Override
	public String displayLastNameWhereIdis(Long id) {
		return jdbcTemplate.queryForObject("select last_name from person where id = ?", String.class, id);
	}

	@Override
	public Integer insertIntoPerson(String firstName, String lastName) {
		  return jdbcTemplate.update("insert into person (first_name, last_name) values (?,?)", Integer.class,firstName,lastName);
	}

	@Override
	public Integer updatePersonFirstNameById(Long id, String lastName) {
		return jdbcTemplate.update("update person set last_name = ? where id = ?",Integer.class,lastName ,id);
	}
	
	@Override
	public Integer deletePersonById(Long id) {
		return jdbcTemplate.update("delete from person where id = ?", Integer.class, id);
	}
	
	@Override
	public void createPersonTable() {
		jdbcTemplate.execute(" create table person ( id integer, first_name varchar (25), last_name varchar (25))");
	}
	
	
}
