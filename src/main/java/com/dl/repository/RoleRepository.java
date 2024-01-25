package com.dl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dl.entity.Roles;

public interface RoleRepository extends JpaRepository< Roles, Integer> {

	@Query(value="SELECT RolesEntity.rolesName, g.groupsName, p.permissionName FROM RolesEntity  "
            + "JOIN RolesEntity.GroupsEntity g "
            + "JOIN g.PermissionEntity p "
            + "WHERE RolesEntity.rolesId = :rolesId",nativeQuery = true)
    List<Object[]> getRolesGroupsPermissionsByRolesId(@Param("rolesId") int roleId);

}
