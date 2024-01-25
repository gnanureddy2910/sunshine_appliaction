package com.dl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dl.entity.Permissions;

public interface PermissionRepository extends JpaRepository<Permissions, Integer> {

}
