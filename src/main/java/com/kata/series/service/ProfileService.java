package com.kata.series.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.series.mapper.PersonToProfileMapper;
import com.kata.series.model.Person;
import com.kata.series.model.Profile;
import com.kata.series.repository.PersonRepository;

@Service
public class ProfileService {

	@Autowired
	private PersonRepository personRepo;

	public Profile getBasicProfileDetails(String email) {
		Person person = personRepo.findByEmail(email);
		return PersonToProfileMapper.mapper.person2ProfileMapper(person);
	}
}
