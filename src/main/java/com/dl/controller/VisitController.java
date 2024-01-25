package com.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dl.entity.StoreAttributeDetails;
import com.dl.entity.Stores;
import com.dl.entity.Visit;
import com.dl.service.VisitService;

import lombok.Data;

@RestController
@RequestMapping
public class VisitController {

	@Autowired
	private VisitService visitService;

	@PostMapping("/addVisit")
	public Visit addVisit(@RequestBody Visit visit) {
		return visitService.addAllVisits(visit);
	}

	@GetMapping("/getAllVisits")
	public List<Visit> getAllVisits() {
		return visitService.getAllVisita();
	}

	@GetMapping("/getAllVisitaForPocAproval")
	public List<Visit> getAllVisitsForPocApproval() {
		return visitService.getAllVisitsForPocApproval();
	}

//	@GetMapping("/getAllVisitaForRSDAproval")
//	public List<Visit> getAllVisitaForRSDAprovel() {
//		return visitService.getAllVisitaForRSDAproval();
//	}
//
//	@GetMapping("/getAllVisitaForQCAprovel")
//	public List<Visit> getAllVisitaForQCAproval() {
//		return visitService.getAllVisitaForQCAproval();
//	}
//
//	@GetMapping("/getAllVisitaForHOAproval")
//	public List<Visit> getAllVisitaForHOAproval() {
//		return visitService.getAllVisitaForHOAproval();
//	}

//	@PutMapping("/updateVisitStatus/{visitId}")
//	public Visit updateVisitStatus(@PathVariable int visitId, @RequestBody Visit visit) {
//		return visitService.updateVisitStatus(visitId, visit);
//	}

	@DeleteMapping("/deleteVisit/{visitId}")
	public String deleteVisitById(@PathVariable int visitId) {
		visitService.deleteVisitById(visitId);
		return "deleted successfully";
	}

	@PutMapping("/updateVisit/{visitId}")
	public Visit updateVisit(@PathVariable int visitId, @RequestBody Visit visit) {
		return visitService.updateVisit(visitId, visit);
	}

	@PostMapping("/updateRecordsAccordingToStatus")
	public ResponseEntity<String> updateRecordsAccordingToStatus(@RequestBody VisitUpdateRequest visitUpdateRequest) {

		try {
			visitService.getRecordsAccordingToStatus(visitUpdateRequest.getVisitId(), visitUpdateRequest.getStatus(),
					visitUpdateRequest.getStoreId(), visitUpdateRequest.getComment(),
					visitUpdateRequest.getStoreAttributeDetailsList());
			return new ResponseEntity<>("Records updated successfully", HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<>("Error updating records: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Data
	static class VisitUpdateRequest {
		private String visitId;
		private String status;
		private Stores storeId;
		private String comment;

		private List<StoreAttributeDetails> storeAttributeDetailsList;

	}

	@GetMapping("/getVisitsForRequiredStoreId/{storeId}")
	public Object getVisitsForStore(@PathVariable int storeId) {
		return visitService.getAllVisitsForStore(storeId);
	}
}
