package com.dl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.entity.Activitys;
import com.dl.repository.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository activityRepo;

	public Activitys addActivity( Activitys activity) {
		return activityRepo.save(activity);
	}

	public List<Activitys> getAllActivitys() {

		return activityRepo.findAll();
	}

	public List<Activitys> getAllActiveActivitys() {
		return activityRepo.findByIsActiveTrue();
	}

	public Activitys deactivateActivitysById(int activityId) {
		Optional<Activitys> optionalUser = activityRepo.findById(activityId);
		// here ispresent is an inbuilt method
		if (optionalUser.isPresent()) {
			Activitys activitys = optionalUser.get();
			activitys.setActive(false);
			return activityRepo.save(activitys);

		} else {

			throw new RuntimeException("Activitys not found with id: " + activityId);
		}
	}

	public String deleteActivityById(int activityId) {

		activityRepo.deleteById(activityId);
		return "deleted sucessfully";
	}

	public Activitys updateActivity(int activityId, Activitys activitys) {

		Activitys existingActivitys = activityRepo.findById(activityId).get();
		existingActivitys.setActivityName(activitys.getActivityName());

		return activityRepo.save(existingActivitys);
	}
}
