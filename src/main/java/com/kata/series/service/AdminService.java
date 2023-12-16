package com.kata.series.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kata.series.model.EazyClass;
import com.kata.series.model.Person;
import com.kata.series.repository.EazyClassRepository;
import com.kata.series.repository.PersonRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private EazyClassRepository eazyClassRepo;

	public EazyClass addNewClass(Person person, EazyClass newClass) {
		Optional<Person> personFromRepoOpt = personRepo.findById(person.getPersonId());
		Person personFromRepo = personFromRepoOpt.get();
		personFromRepo.setEazyClass(newClass);
		eazyClassRepo.save(newClass);
		personRepo.save(personFromRepo);
		return newClass;
	}

	public Optional<List<EazyClass>> findAllClasses() {
		List<EazyClass> list = eazyClassRepo.findAll();
		return Optional.ofNullable(list);
	}

	public EazyClass deleteClassById(Integer id) {
		EazyClass class2Delete;
		Optional<EazyClass> class2DeleteOpt = eazyClassRepo.findById(id);
		if (class2DeleteOpt.isPresent()) {
			class2Delete = class2DeleteOpt.get();
			List<Person> listOfPersons = class2Delete.getPersons().stream().peek(p -> p.setEazyClass(null)).toList();
			personRepo.saveAll(listOfPersons);
			eazyClassRepo.deleteById(class2Delete.getClassId());
			System.out.println("Delete Successful");
			return class2Delete;
		} else {
			System.out.println("Item with Id is not present in classes");
		}
		return null;

	}
}
