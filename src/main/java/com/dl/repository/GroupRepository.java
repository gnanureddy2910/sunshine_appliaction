package com.dl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.entity.MyGroups;

public interface GroupRepository extends JpaRepository<MyGroups, Integer> {

}
