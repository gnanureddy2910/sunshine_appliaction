package com.dl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dl.entity.StoreAttributeDetails;
import com.dl.repository.StoreAttributeDetailsRepossitory;

@Service
public class StoreAttributeDetailsService {

	@Autowired
	private StoreAttributeDetailsRepossitory storeAttributeDetailsRepo;

	public StoreAttributeDetails addStoreAttributeDetails( StoreAttributeDetails attributeDetails) {

		return storeAttributeDetailsRepo.save(attributeDetails);
	}

	public List<StoreAttributeDetails> getAllActivitys() {

		return storeAttributeDetailsRepo.findAll();
	}

	public String deleteGroupsById(int storeAttributeId) {

		storeAttributeDetailsRepo.deleteById(storeAttributeId);
		return "deleted sucessfully";
	}

	public StoreAttributeDetails updateGroups(int storeAttributeId, StoreAttributeDetails storeAttributeDetails) {

		StoreAttributeDetails existingStoreAttributeDetails = storeAttributeDetailsRepo.findById(storeAttributeId)
				.get();
		existingStoreAttributeDetails.setAttributeValue(storeAttributeDetails.getAttributeValue());

		return storeAttributeDetailsRepo.save(existingStoreAttributeDetails);
	}
}