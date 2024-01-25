package com.dl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.entity.Permissions;
import com.dl.repository.GroupRepository;
import com.dl.repository.PermissionRepository;

@Service
public class PermissionService {
	@Autowired
	PermissionRepository permissionRepo;
	@Autowired
	GroupRepository groupsRepo;

	public Permissions addPermissions( Permissions permission) {

		return permissionRepo.save(permission);
	}

	public List<Permissions> getAllPermission() {
		return permissionRepo.findAll();
	}

	public String deletePermissionById(int permissionId) {

		permissionRepo.deleteById(permissionId);
		return "deleted sucessfully";
	}

	public Permissions updatePermission(int permissionId, Permissions permission) {

		Permissions existingPermission = permissionRepo.findById(permissionId).get();
		existingPermission.setPermissionName(permission.getPermissionName());

		return permissionRepo.save(existingPermission);
	}
	
	


	
}
