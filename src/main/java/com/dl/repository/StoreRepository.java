package com.dl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dl.entity.Stores;

public interface StoreRepository extends JpaRepository<Stores, Integer> {

}
