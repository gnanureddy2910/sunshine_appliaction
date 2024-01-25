package com.dl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.entity.Activitys;

public interface ActivityRepository extends JpaRepository<Activitys, Integer> {
	List<Activitys> findByIsActiveTrue();
}
