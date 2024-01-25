package com.dl.controller;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dl.entity.MyGroups;
import com.dl.service.GroupsService;

@RestController
public class GroupsController {

	@Autowired
	private GroupsService groupService;

	@PostMapping("/addGroup")
	public MyGroups saveNewGroup(@RequestBody MyGroups entity) {
		return groupService.addGroups(entity);
	}

	@GetMapping("/getAllGroups")
	public List<MyGroups> getAllGroups() {
		return groupService.getAllGroups();
	}

	@DeleteMapping("/groupDelete/{groupId}")
	public String deleteGroupById(@PathVariable int groupId) {
		groupService.deleteGroupsById(groupId);
		return "deleted successfully";
	}

	@PutMapping("/updateGroups/{groupId}")
	public MyGroups updateGroup(@PathVariable int groupId, @RequestBody MyGroups groups) {
		return groupService.updateGroups(groupId, groups);
	}

	@PutMapping("/{groupId}/assignPermissionsToGroups")
	public MyGroups assignPermissionsToGroups(@PathVariable int groupId, @RequestParam Set<Integer> permissions) {
		return groupService.assignPermissionsToGroups(groupId, permissions);
	}
}
