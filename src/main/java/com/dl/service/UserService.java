package com.dl.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dl.entity.Roles;
import com.dl.entity.Stores;
import com.dl.entity.Users;
import com.dl.repository.RoleRepository;
import com.dl.repository.StoreRepository;
import com.dl.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository usersRepo;
	@Autowired
	private RoleRepository rolesRepo;
	@Autowired
	private StoreRepository storeRepo;

	// add
	public Users addUser(Users users) {

		return usersRepo.save(users);
	}

	// getAll
	public List<Users> getAllUsers() {
		return usersRepo.findAll();
	}

	// get
	public List<Users> getAllActiveUsers() {
		return usersRepo.findByIsActiveTrue();
	}

	// getById
	public Optional<Users> getUsersById(int userId) {
		return usersRepo.findById(userId);
	}

	// delete
	public Users deactivateUserById(int userId) {
		Optional<Users> optionalUser = usersRepo.findById(userId);
		// here ispresent is an inbuilt method
		if (optionalUser.isPresent()) {
			Users user = optionalUser.get();
			user.setActive(false);

			return usersRepo.save(user);

		} else {

			throw new RuntimeException("User not found with id: " + userId);
		}
	}

	// update
	public Users updateUser(int userId, Users users) {
		Users existingUsers = usersRepo.findById(userId).get();
		existingUsers.setName(users.getName());
		existingUsers.setUserEmail(users.getUserEmail());
		existingUsers.setPassword(users.getPassword());
		existingUsers.setPhone(users.getPhone());
		return usersRepo.save(existingUsers);
	}

	// get
	public Users getFullUserDetails(Integer userId) {
		return usersRepo.findUserWithRolesGroupsAndPermissions(userId);
	}

	// put
	public Users assignRolesToUsers(int userId, int roleId) {

        Users users = usersRepo.findById(userId).get();
        Roles roles = rolesRepo.findById(roleId).get();
        Set<Roles> rolesList = users.getAssignRoles();
        rolesList.add(roles);
        users.setAssignRoles(rolesList);
        return usersRepo.save(users);
    }

    // put
    public Users assignStoresToUsers(int userId, int storeId) {
        Users users = usersRepo.findById(userId).get();
        Stores stores = storeRepo.findById(storeId).get();
        Set<Stores> storesList = users.getAssignStores(); // Fix typo here
        storesList.add(stores);
        users.setAssignStores(storesList); // Fix typo here
        return usersRepo.save(users);
    }
}
