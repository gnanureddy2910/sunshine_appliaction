package com.dl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dl.entity.Permissions;
import com.dl.service.PermissionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PermissionController {

	@Autowired
	private PermissionService permissionservice;

	@PostMapping("/addPermission")
	public Permissions addNewPermission(@RequestBody Permissions permission) {
		return permissionservice.addPermissions(permission);

	}

	@GetMapping("/getAllPermission")
	public List<Permissions> getAllPermission() {
		log.info("method started");
		return permissionservice.getAllPermission();
	}

	@DeleteMapping("/deletePermission/{permissionId}")
	public String deletepermissionById(int permissionId) {

		permissionservice.deletePermissionById(permissionId);
		return "deleted sucessfully";
	}

	@PutMapping("/updatePermission/{permissionId}")

	public Permissions updatePermission(int permissionId, Permissions Permissions) {

		return permissionservice.updatePermission(permissionId, Permissions);
	}

}
