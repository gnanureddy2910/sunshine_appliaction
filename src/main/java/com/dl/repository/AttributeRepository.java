package com.dl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dl.entity.Attributes;

public interface AttributeRepository extends JpaRepository<Attributes, Integer> {

}
