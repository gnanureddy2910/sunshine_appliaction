package com.dl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dl.entity.Users;
import com.dl.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUsers")
	public Users addUser(@RequestBody Users user) {
		return userService.addUser(user);
	}

	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/getAllActiveUsers")
	public List<Users> getAllActiveUsers() {
		return userService.getAllActiveUsers();
	}

	@GetMapping("/getById/{userId}")
	public Optional<Users> getUsersById(@PathVariable int userId) {
		return userService.getUsersById(userId);
	}

	@DeleteMapping("/delete/{userId}")
	public Users deleteUserById(@PathVariable int userId) {
		return userService.deactivateUserById(userId);
	}

	@PutMapping("/update/{userId}")
	public Users updateUser(@PathVariable int userId, @RequestBody Users users) {
		return userService.updateUser(userId, users);
	}

	@GetMapping("/getFullUserDetails/{userId}")
	public Users getFullUserDetails(@PathVariable Integer userId) {
		return userService.getFullUserDetails(userId);
	}

	@PutMapping("/{userId}/assignRoles/{roleId}")
	public Users assignRolesToUsers(@PathVariable int userId, @PathVariable int roleId) {

		return userService.assignRolesToUsers(userId, roleId);
	}

	@PutMapping("/{userId}/assignStores")
	public Users assignStoresToUsers(@PathVariable int userId, @PathVariable int storeId) {

		return userService.assignStoresToUsers(userId, storeId);
	}

}
