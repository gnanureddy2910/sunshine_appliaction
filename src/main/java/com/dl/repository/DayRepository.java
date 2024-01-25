package com.dl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.entity.Day;

public interface DayRepository extends JpaRepository<Day, Integer> {

}
