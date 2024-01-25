package com.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dl.entity.Day;
import com.dl.service.DayService;

@RestController
public class DayController {

	@Autowired
	private DayService dayService;

	@PostMapping("/addDay")
	public Day addDay(@RequestBody  Day day) {
		return dayService.getActivitys(day);
	}

	@GetMapping("/getAllDays")
	public List<Day> getAllDays() {
		return dayService.getAllActivitys();
	}

	@DeleteMapping("/deleteDay/{dayNo}")
	public String deleteDayById(@PathVariable int dayNo) {
		dayService.deleteDayById(dayNo);
		return "deleted successfully";
	}

	@PutMapping("/updateDay/{dayNo}")
	public Day updateDay(@PathVariable int dayNo, @RequestBody Day day) {
		return dayService.updateGroups(dayNo, day);
	}
}
