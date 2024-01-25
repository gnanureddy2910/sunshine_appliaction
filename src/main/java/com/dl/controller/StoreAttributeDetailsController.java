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

import com.dl.entity.StoreAttributeDetails;
import com.dl.service.StoreAttributeDetailsService;

@RestController
public class StoreAttributeDetailsController {

	@Autowired
	private StoreAttributeDetailsService storeAttributeDetailsService;

	@PostMapping("/addStoreAttributeDetails")
	public StoreAttributeDetails addStoreAttributeDetails(@RequestBody  StoreAttributeDetails attributeDetails) {
		return storeAttributeDetailsService.addStoreAttributeDetails(attributeDetails);
	}

	@GetMapping("/getAllStoreAttributeDetails")
	public List<StoreAttributeDetails> getAllStoreAttributeDetails() {
		return storeAttributeDetailsService.getAllActivitys();
	}

	@DeleteMapping("/deleteStoreAttributeDetails/{storeAttributeId}")
	public String deleteStoreAttributeDetailsById(@PathVariable int storeAttributeId) {
		storeAttributeDetailsService.deleteGroupsById(storeAttributeId);
		return "deleted successfully";
	}

	@PutMapping("/updateStoreAttributeDetails/{storeAttributeId}")
	public StoreAttributeDetails updateStoreAttributeDetails(@PathVariable int storeAttributeId,
			@RequestBody StoreAttributeDetails storeAttributeDetails) {
		return storeAttributeDetailsService.updateGroups(storeAttributeId, storeAttributeDetails);
	}
}
