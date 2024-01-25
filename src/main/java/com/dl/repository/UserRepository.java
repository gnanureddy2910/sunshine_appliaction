package com.dl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dl.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	@EntityGraph(attributePaths = {"assignRoles", "assignRoles.assignGroups", "assignRoles.assignGroups.assignPermissions"})
	@Query("SELECT DISTINCT u FROM Users u WHERE u.userId = :userId")
	Users findUserWithRolesGroupsAndPermissions(@Param("userId") Integer userId);

//	@Query("SELECT u FROM Users u WHERE u.isActive = true")
//	List<Users> findAllActiveUsers();

	List<Users> findByIsActiveTrue();

}
