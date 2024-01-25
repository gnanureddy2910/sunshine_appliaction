package com.dl.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.entity.MyGroups;
import com.dl.entity.Roles;
import com.dl.repository.GroupRepository;
import com.dl.repository.RoleRepository;
@Service
public class RolesService {

    @Autowired
    RoleRepository rolesRepo;
    
    @Autowired
    GroupRepository groupRepo;

    public Roles addRoles(Roles roles) {
        return rolesRepo.save(roles);
    }

    public List<Roles> getAllRoles() {
        return rolesRepo.findAll();
    }

    public String deleteRolesById(int roleId) {
        rolesRepo.deleteById(roleId);
        return "deleted successfully";
    }

    public Roles updateRoles(int roleId, Roles roles) {
        Roles existingRoles = rolesRepo.findById(roleId).get();
        existingRoles.setRoleName(roles.getRoleName());
        return rolesRepo.save(existingRoles);
    }

    public Roles assignGroupsToRoles(int roleId, Set<Integer> groupId) {
        Roles roles = rolesRepo.findById(roleId).get();
        Set<MyGroups> groups = groupRepo.findAllById(groupId).stream().collect(Collectors.toSet());
        roles.setAssignGroups(groups);
        return rolesRepo.save(roles);
    }

    public List<Object[]> getRolesGroupsPermissionsByRolesId(int rolesId) {
        return rolesRepo.getRolesGroupsPermissionsByRolesId(rolesId);
    }
}
