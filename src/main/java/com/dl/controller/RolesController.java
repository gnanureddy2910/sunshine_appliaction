package com.dl.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dl.entity.Roles;
import com.dl.service.RolesService;
@RestController
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @PostMapping("/addRole")
    public Roles saveRoles(@RequestBody Roles roles) {
        return rolesService.addRoles(roles);
    }

    @GetMapping("/getAllRoles")
    public List<Roles> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @DeleteMapping("/roleDelete/{rolesId}")
    public String deleteRoleById(@PathVariable int rolesId) {
        rolesService.deleteRolesById(rolesId);
        return "deleted successfully";
    }

    @PutMapping("/updateRoles/{rolesId}")
    public Roles updateRole(@PathVariable int rolesId, @RequestBody Roles roles) {
        return rolesService.updateRoles(rolesId, roles);
    }

    @PutMapping("/{roleId}/assignGroupsToRoles")
    public Roles assignGroupsToRoles(@PathVariable int roleId, @RequestParam Set<Integer> groups) {
        return rolesService.assignGroupsToRoles(roleId, groups);
    }

    @GetMapping("/getRolesGroupsPermissionsByRolesId/{rolesId}")
    public List<Object[]> getRolesGroupsPermissionsByRolesId(@PathVariable int rolesId) {
        return rolesService.getRolesGroupsPermissionsByRolesId(rolesId);
    }
}
