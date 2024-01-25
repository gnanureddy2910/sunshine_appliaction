package com.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dl.entity.Activitys;
import com.dl.service.ActivityService;

@RestController
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@PostMapping("/addActivitys")
	public Activitys addActivityss(@RequestBody  Activitys activitys) {
		return activityService.addActivity(activitys);

	}

	@GetMapping("/getAllActivitys")
	public List<Activitys> getAllActivitys() {
		return activityService.getAllActivitys();
	}

	@DeleteMapping("/deleteActivity/{activityId}")
	public String deleteActivityById(int activityId) {

		activityService.deleteActivityById(activityId);
		return "deleted sucessfully ";
	}

	@PutMapping("/updateActivitys/{activityId}")

	public Activitys updateActivity(int activityId, Activitys activitys) {

		return activityService.updateActivity(activityId, activitys);
	}
}
