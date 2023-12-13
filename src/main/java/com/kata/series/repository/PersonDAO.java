package com.kata.series.repository;

public interface PersonDAO {

	Integer countPersonRows();

	Integer countPersonRowsWhereFirstNameis(String firstName);

	String displayLastNameWhereIdis(Long id);
	
	Integer insertIntoPerson(String firstName, String lastName);
	
	Integer updatePersonFirstNameById(Long id, String lastName);

	Integer deletePersonById(Long id);

	void createPersonTable();
}
