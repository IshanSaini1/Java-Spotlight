package com.kata.series.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.kata.series.model.Holiday;
import com.kata.series.repository.HolidayRepository;
import com.kata.series.repository.HolidayRepositoryJPA;

@Controller
public class HolidayController {
	
	@Autowired
	private HolidayRepository holidayRepository;
	
	@Autowired
	private HolidayRepositoryJPA holidayRepositoryJPA;

	@GetMapping("/holidays/{display}")
	public String displayHolidays(Model model, @PathVariable(required = false) String display) {
		List<Holiday> holidays  = holidayRepositoryJPA.findAll();
		switch (display) {
		case "festival":
			model.addAttribute(Holiday.TYPE.FESTIVAL.toString(),
					holidays.stream().filter(t -> t.getType().equals(Holiday.TYPE.FESTIVAL)).toList());
			break;
		case "federal":
			model.addAttribute(Holiday.TYPE.FEDERAL.toString(),
					holidays.stream().filter(t -> t.getType().equals(Holiday.TYPE.FEDERAL)).toList());
			break;
		default:
		case "all":
			model.addAttribute(Holiday.TYPE.FESTIVAL.toString(),
					holidays.stream().filter(t -> t.getType().equals(Holiday.TYPE.FESTIVAL)).toList());
			model.addAttribute(Holiday.TYPE.FEDERAL.toString(),
					holidays.stream().filter(t -> t.getType().equals(Holiday.TYPE.FEDERAL)).toList());
			break;
		}
		;
		return "holidays.html";
	}
	
	@Deprecated
	public String displayHolidays2(Model model, @PathVariable(required = false) String display) {
		List<Holiday> holidays  = holidayRepository.fetchAllHolidays();
		switch (display) {
		case "festival":
			model.addAttribute(Holiday.TYPE.FESTIVAL.toString(),
					holidays.stream().filter(t -> t.getType().equals(Holiday.TYPE.FESTIVAL)).toList());
			break;
		case "federal":
			model.addAttribute(Holiday.TYPE.FEDERAL.toString(),
					holidays.stream().filter(t -> t.getType().equals(Holiday.TYPE.FEDERAL)).toList());
			break;
		default:
		case "all":
			model.addAttribute(Holiday.TYPE.FESTIVAL.toString(),
					holidays.stream().filter(t -> t.getType().equals(Holiday.TYPE.FESTIVAL)).toList());
			model.addAttribute(Holiday.TYPE.FEDERAL.toString(),
					holidays.stream().filter(t -> t.getType().equals(Holiday.TYPE.FEDERAL)).toList());
			break;
		}
		;
		return "holidays.html";
	}

	// @GetMapping("/holidays")
	@Deprecated
	public String displayHolidays1(Model model, @RequestParam(required = false) boolean festival,
			@RequestParam(required = false) boolean federal) {
		List<Holiday> holidays = Arrays.asList(new Holiday(" Jan 1 ", "New Years Day", Holiday.TYPE.FESTIVAL),
				new Holiday(" Oct 31 ", "Halloween", Holiday.TYPE.FESTIVAL),
				new Holiday(" Dec 25 ", "Christmas", Holiday.TYPE.FESTIVAL),
				new Holiday(" Sep 5 ", "Labour Day", Holiday.TYPE.FEDERAL),
				new Holiday(" Nov 11 ", "Veterans Day", Holiday.TYPE.FEDERAL));
		Holiday.TYPE[] types = Holiday.TYPE.values();

		for (Holiday.TYPE t : types) {
			if (festival && t.equals(Holiday.TYPE.FESTIVAL)) {
				model.addAttribute(t.toString(),
						holidays.stream().filter(h -> h.getType().equals(Holiday.TYPE.FESTIVAL))
								.collect(Collectors.toCollection(() -> new ArrayList<Holiday>())));
			}
			if (federal && t.equals(Holiday.TYPE.FEDERAL)) {
				model.addAttribute(t.toString(), holidays.stream().filter(h -> h.getType().equals(Holiday.TYPE.FEDERAL))
						.collect(Collectors.toCollection(() -> new ArrayList<Holiday>())));
			}
			if (!federal && !festival) {
				model.addAttribute(t.toString(), holidays.stream().filter(h -> h.getType().equals(t))
						.collect(Collectors.toCollection(() -> new ArrayList<Holiday>())));
			}
		}
		// System.out.println(" DISPLAY : " + display);
		return "holidays.html";
	}

}
