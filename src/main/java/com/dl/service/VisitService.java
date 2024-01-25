
package com.dl.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dl.entity.Stores;
import com.dl.entity.StoreAttributeDetails;
import com.dl.entity.Visit;
import com.dl.repository.StoreAttributeDetailsRepossitory;
import com.dl.repository.VisitRepository;

import lombok.Data;

import org.springframework.transaction.annotation.Transactional;

@Service
public class VisitService {
	@Autowired
	private VisitRepository visitRepo;

	@Autowired
	private StoreAttributeDetailsRepossitory storeAttributeDetailsRepo;

	public Visit addAllVisits(Visit visit) {
		return visitRepo.save(visit);
	}

	public List<Visit> getAllVisita() {

		return visitRepo.findAll();
	}

	public String deleteVisitById(int visitId) {

		visitRepo.deleteById(visitId);
		return "deleted sucessfully";
	}

	public Visit updateVisit(int visitId, Visit visit) {

		Visit existingVisit = visitRepo.findById(visitId).get();
		existingVisit.setComment(visit.getComment());

		return visitRepo.save(existingVisit);
	}

	public List<Visit> getAllVisitsForPocApproval() {
		List<String> allowedStatusList = Arrays.asList("salesmen approved", "RSD rejected", "QC rejected",
				"HO rejected");

		List<Visit> visits = visitRepo.findByStatusInAndIsProcessed(allowedStatusList, false);

		return visits;
	}

	public List<Visit> getAllVisitsForRSDApproval() {

		List<String> allowedStatusList = Arrays.asList("POC approved");

		List<Visit> visits = visitRepo.findByStatusInAndIsProcessed(allowedStatusList, false);

		return visits;

	}

	public List<Visit> getAllVisitsForQCApproval() {

		List<String> allowedStatusList = Arrays.asList("POC approved");

		List<Visit> visits = visitRepo.findByStatusInAndIsProcessed(allowedStatusList, false);

		return visits;
	}

	public List<Visit> getAllVisitsForHOApproval() {

		List<String> allowedStatusList = Arrays.asList("POC approved");

		List<Visit> visits = visitRepo.findByStatusInAndIsProcessed(allowedStatusList, false);

		return visits;
	}

	/**
	 * This method performs multiple actions related to Visit records and associated
	 * details. It handles updating and inserting records in the database.
	 * 
	 * @param visitId                   The ID of the original visit.
	 * @param status                    The status to be set for the new visit
	 *                                  record.
	 * @param storeId                   The store ID associated with the visit.
	 * @param Comment                   A comment associated with the visit records.
	 * @param storeAttributeDetailsList A list of StoreAttributeDetails to be
	 *                                  associated with the new visit.
	 */
	@Transactional
	public void getRecordsAccordingToStatus(String visitId, String status, Stores storeId, String comment,
			List<StoreAttributeDetails> storeAttributeDetailsList) {

		// Action 1: Get visit_details of visitId v1 that came from postman.
		if (visitId != null) {
			Visit visitV1 = visitRepo.findById(Integer.parseInt(visitId))
					.orElseThrow(() -> new RuntimeException("Visit with ID " + visitId + " not found"));

			// Action 2: Update that record's isProcessed boolean to true.
			visitV1.setProcessed(true);
			visitRepo.save(visitV1);
		}

		// Action 4: Create a new record in the visit table.
		Visit visitV2 = new Visit();
		visitV2.setComment(comment);
		visitV2.setStatus(status);
		visitV2.setStoreId(storeId);

		// Action 5: Create a new record for StoreAttributeDetails table data associated
		// with v2.
		for (StoreAttributeDetails storeAttributeDetails : storeAttributeDetailsList) {
			StoreAttributeDetails newStoreAttributeDetails = new StoreAttributeDetails();
			newStoreAttributeDetails.setAttributeId(storeAttributeDetails.getAttributeId());
			newStoreAttributeDetails.setAttributeValue(storeAttributeDetails.getAttributeValue());
			newStoreAttributeDetails.setVisitId(visitV2);
			newStoreAttributeDetails.setStoreId(storeId);
			newStoreAttributeDetails.setActive(true);
			storeAttributeDetailsRepo.save(newStoreAttributeDetails);
		}

		// Action 6: Commit changes to the database.
		visitRepo.save(visitV2);
	}

	/**
	 * Retrieves simplified records of a particular store based on storeId, sorted in
	 * ascending order by visitId.
	 *
	 * @param storeId The identifier of the store for which visits are retrieved.
	 * @return A list of simplified Visit entities representing the records of the specified
	 *         store, sorted by visitId.
	 */
	public List<VisitDto> getAllVisitsForStore(int storeId) {
	    List<Visit> visits = visitRepo.findByStoreIdStoreIdOrderByVisitId(storeId);
	    if (visits.isEmpty()) {
	        // Return an empty list or handle the case as needed
	        return Collections.emptyList();
	    }

	    // Create a list to store simplified Visit entities
	    List<VisitDto> simplifiedVisits = new ArrayList<>();

	    for (Visit visit : visits) {
	        // Create a simplified Visit entity with only necessary fields
	        VisitDto simplifiedVisit = new VisitDto();
	        simplifiedVisit.setVisitId(visit.getVisitId());
	        simplifiedVisit.setComment(visit.getComment());
	        simplifiedVisit.setStatus(visit.getStatus());
//	        simplifiedVisit.setProcessed(visit.isProcessed());
	        
	        // Add the simplified Visit entity to the list
	        simplifiedVisits.add(simplifiedVisit);
	    }

	    return simplifiedVisits;
	}

	// Create a DTO class to represent the simplified Visit entity
	@Data
	public class VisitDto {
	    private int visitId;
	    private String comment;
	    private String status;
//	    private boolean processed;
	}


}
