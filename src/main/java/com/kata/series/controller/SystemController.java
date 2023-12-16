package com.kata.series.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is Used to fill the Persons Repo Table
 */
@Controller
@RequestMapping("/sys")
public class SystemController {
	/*
	 * 
	 * private Random rand = new Random();
	 * 
	 * @Autowired private PersonRepository personRepository;
	 * 
	 * @Autowired private RolesRepository roleRepo;
	 * 
	 * @Autowired private PasswordEncoder encoder;
	 * 
	 * @GetMapping("/admin/{num}") public String
	 * setAdminAccounts(@PathVariable("num") int num) { createAdmins(num); return
	 * "Admins Saved"; }
	 * 
	 * @GetMapping("/student/{num}") public String
	 * setStudentAccounts(@PathVariable("num") int num) { createStudents(num);
	 * return "Students Saved"; }
	 * 
	 * private Supplier<List<String>> supplyEmailDomains() { Supplier<List<String>>
	 * supplyList = () -> { return new ArrayList<String>(List.of("gmail.com",
	 * "yahoo.co.in", "rediffmail.com", "outlook.com")); }; return supplyList; }
	 * 
	 * private String generateEmail(Supplier<List<String>> domain) { List<String>
	 * litOfDomains = domain.get(); int lengthDomainList = litOfDomains.size();
	 * String domainSelected = litOfDomains.get(rand.nextInt(0, lengthDomainList));
	 * String email = RandomStringUtils.randomAlphabetic(6) + "@" + domainSelected;
	 * return email; }
	 * 
	 * private String generateMobileNumber() { Integer i = rand.nextInt(10000,
	 * 100000); Integer j = rand.nextInt(10000, 100000); return i.toString() +
	 * j.toString(); }
	 * 
	 * private String generateNameAndPassword() { return
	 * RandomStringUtils.randomAlphabetic(6); }
	 * 
	 * private Person createPersonObject(Integer role) { String namePassword =
	 * generateNameAndPassword(); Roles roleObject = roleRepo.findById(role).get();
	 * Person person = new Person();
	 * person.setPersonId(personRepository.findMaxIdInTable());
	 * person.setName(namePassword); person.setPwd(encoder.encode(namePassword));
	 * person.setEmail(generateEmail(supplyEmailDomains()));
	 * person.setMobileNumber(generateMobileNumber());
	 * person.setRoles(List.of(roleObject)); return person; }
	 * 
	 * private void createAdmins(Integer numOfAdmins) { for (int i = 0; i <
	 * numOfAdmins; i++) { Person person = createPersonObject(1);
	 * personRepository.save(person); } }
	 * 
	 * private void createStudents(Integer numOfStudents) { for (int i = 0; i <
	 * numOfStudents; i++) { Person person = createPersonObject(2);
	 * personRepository.save(person); } }
	 * 
	 */}
