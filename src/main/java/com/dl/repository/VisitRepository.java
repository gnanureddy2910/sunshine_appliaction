package com.dl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;

import com.dl.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {

	@Query("SELECT v FROM Visit v WHERE v.status IN (:statuses) AND v.isProcessed = false")
	List<Visit> findByStatusIn(@Param("statuses") List<String> statuses);

	List<Visit> findByStatusInAndIsProcessed(List<String> statusList, boolean isProcessed);

	List<Visit> findByIsProcessed(boolean isProcessed);

	List<Visit> findByStoreIdStoreIdOrderByVisitId(int storeId);
	

}