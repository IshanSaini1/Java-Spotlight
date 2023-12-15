package com.kata.series.mapper;

import com.kata.series.model.Address;
import com.kata.series.model.Person;
import com.kata.series.model.Profile;

public class PersonToProfileMapper {

	public static final PersonToProfileMapper mapper = new PersonToProfileMapper();

	public Profile person2ProfileMapper(Person person) {
		Profile profile = new Profile();
		profile.setName(person.getName());
		profile.setMobileNumber(person.getMobileNumber());
		profile.setEmail(person.getEmail());
		// Map Address Fields
		if (null != person.getAddress()) {
			Address addr = person.getAddress();
			profile.setAddress1(addr.getAddress1());
			profile.setAddress2(addr.getAddress2());
			profile.setCity(addr.getCity());
			profile.setState(addr.getState());
			profile.setZipCode(addr.getZipCode());
		}
		return profile;
	}

	public Person profileToPerson(Person person ,Profile profile) {
		person.setName(profile.getName());
		person.setMobileNumber(profile.getMobileNumber());
		person.setEmail(profile.getEmail());
		person.setConfirmEmail(profile.getEmail());
		person.setPwd(person.getPwd());
		person.setConfirmPwd(person.getPwd());
		// Map Address Fields
		Address addr = new Address();
		person.setAddress(addr);
		addr.setAddress1(profile.getAddress1());
		addr.setAddress2(profile.getAddress2());
		addr.setCity(profile.getCity());
		addr.setState(profile.getState());
		addr.setZipCode(profile.getZipCode());
		
		return person;
	}
}
