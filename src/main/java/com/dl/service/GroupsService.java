package com.dl.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dl.entity.MyGroups;
import com.dl.entity.Permissions;
import com.dl.repository.GroupRepository;
import com.dl.repository.PermissionRepository;

import jakarta.transaction.Transactional;


@Transactional
@Service
public class GroupsService {

    @Autowired
    GroupRepository groupRepo;
    
    @Autowired
    PermissionRepository permissionRepo;

    public MyGroups addGroups(MyGroups groups) {
        return groupRepo.save(groups);
    }

    public List<MyGroups> getAllGroups() {
        return groupRepo.findAll();
    }

    public String deleteGroupsById(int groupId) {
        groupRepo.deleteById(groupId);
        return "deleted successfully";
    }

    public MyGroups updateGroups(int groupId, MyGroups groups) {
        MyGroups existingGroups = groupRepo.findById(groupId).get();
        existingGroups.setGroupName(groups.getGroupName());
        return groupRepo.save(existingGroups);
    }

    public MyGroups assignPermissionsToGroups(int groupId, Set<Integer> permissionId) {
        MyGroups group = groupRepo.findById(groupId).get();
        Set<Permissions> permissions = permissionRepo.findAllById(permissionId).stream().collect(Collectors.toSet());
        group.setAssignPermissions(permissions);
        return groupRepo.save(group);
    }
}
