package com.dl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.entity.Day;
import com.dl.repository.DayRepository;

@Service
public class DayService {
	@Autowired
	private DayRepository dayRepo;

	public Day getActivitys( Day day) {
		return dayRepo.save(day);
	}

	public List<Day> getAllActivitys() {

		return dayRepo.findAll();
	}

	public Day deleteDayById(int dayNo) {

		Optional<Day> optionalDay = dayRepo.findById(dayNo);
		// here ispresent is an inbuilt method
		if (optionalDay.isPresent()) {
			Day day = optionalDay.get();
			day.setActive(false);

			return dayRepo.save(day);

		} else {

			throw new RuntimeException("day not found with id: " + dayNo);
		}

	}

	public Day updateGroups(int dayNo, Day day) {

		Day existingDay = dayRepo.findById(dayNo).get();
		existingDay.setDay(day.getDay());

		return dayRepo.save(existingDay);
	}
}
