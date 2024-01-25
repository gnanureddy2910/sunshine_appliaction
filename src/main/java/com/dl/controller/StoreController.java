package com.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dl.entity.Stores;
import com.dl.service.StoreService;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StoreController {

	@Autowired
	private StoreService storeService;

	@PostMapping("/addNewStore")
	public Stores saveNewStore(@RequestBody Stores store) {
		return storeService.saveNewStore(store);
	}

	@GetMapping("/getAllStore")
	public List<Stores> getAllStores() {
		log.info("method started");
		return storeService.getAllStores();
	}

	@PutMapping("/upbdateStore/{storeId}")
	public Stores updateStoresStatus(@PathVariable int storeId, @RequestBody Stores stores) {
		return storeService.updateStores(storeId, stores);
	}
}
