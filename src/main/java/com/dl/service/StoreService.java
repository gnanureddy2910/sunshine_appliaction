package com.dl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.entity.Stores;
import com.dl.repository.StoreRepository;

import lombok.extern.slf4j.Slf4j;
//import com.dl.repository.VisitRepository;

@Service
@Slf4j
public class StoreService {

	@Autowired
	private StoreRepository storesRepo;

	public Stores saveNewStore(Stores stores) {
		return storesRepo.save(stores);
	}

	public List<Stores> getAllStores() {
		log.info("method started");
		return storesRepo.findAll();
	}

	public Stores updateStores(int storeId, Stores stores) {
		Stores existingStores = storesRepo.findById(storeId).get();
		existingStores.setStoreName(stores.getStoreName());
		existingStores.setStoreCategory(stores.getStoreCategory());

		return storesRepo.save(existingStores);
	}

}
