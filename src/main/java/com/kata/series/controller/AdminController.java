package com.kata.series.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kata.series.model.EazyClass;
import com.kata.series.model.Person;
import com.kata.series.repository.EazyClassRepository;
import com.kata.series.repository.PersonRepository;
import com.kata.series.service.AdminService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private PersonRepository personRepo;

	@Autowired
	private EazyClassRepository eazyClassRepo;

	@RequestMapping("/displayClasses")
	public ModelAndView displayClasses(Model model) {
		List<EazyClass> list = new ArrayList<>();
		var optList = adminService.findAllClasses();
		list = (optList.isPresent()) ? optList.get() : null;
		ModelAndView modelAndView = new ModelAndView("classes.html");
		modelAndView.addObject("eazyClass", new EazyClass());
		modelAndView.addObject("eazyClasses", list);
		return modelAndView;
	}

	@RequestMapping("/addNewClass")
	public ModelAndView addNewClass(Model model, @ModelAttribute("eazyClass") EazyClass eazyClass, HttpSession http) {
		Person person = (Person) http.getAttribute("person");
		var isSaved = adminService.addNewClass(person, eazyClass);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
		return modelAndView;
	}

	@RequestMapping("/deleteClass")
	public ModelAndView deleteClass(Model model, @RequestParam int id) {
		adminService.deleteClassById(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
		return modelAndView;
	}

	@RequestMapping("/displayStudents")
	public ModelAndView displayStudents(Model model, @RequestParam Integer classId, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("students.html");
		Optional<EazyClass> eazyClass = eazyClassRepo.findById(classId);
		session.setAttribute("eazyClass", eazyClass.get());
		modelAndView.addObject("person", new Person());
		modelAndView.addObject("eazyClass", eazyClass.get());

		return modelAndView;
	}

	@PostMapping("/addStudent")
	public ModelAndView addStudent(Model model, @ModelAttribute("person") Person person, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
		Person personEntity = personRepo.findByEmail(person.getEmail());
		if (personEntity == null || !(personEntity.getPersonId() > 0)) {
			modelAndView
					.setViewName("redirect:/admin/displayStudents?classId=" + eazyClass.getClassId() + "&error=true");
			return modelAndView;
		}
		personEntity.setEazyClass(eazyClass);
		personRepo.save(personEntity);
		eazyClass.getPersons().add(personEntity);
		eazyClassRepo.save(eazyClass);
		modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + eazyClass.getClassId());
		return modelAndView;
	}

	@GetMapping("/deleteStudent")
	public ModelAndView deleteStudent(Model model, @RequestParam int personId, HttpSession session) {
		EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
		Optional<Person> person = personRepo.findById(personId);
		person.get().setEazyClass(null);
		eazyClass.getPersons().remove(person.get());
		EazyClass eazyClassSaved = eazyClassRepo.save(eazyClass);
		session.setAttribute("eazyClass", eazyClassSaved);
		ModelAndView modelAndView = new ModelAndView(
				"redirect:/admin/displayStudents?classId=" + eazyClass.getClassId());
		return modelAndView;
	}

}
