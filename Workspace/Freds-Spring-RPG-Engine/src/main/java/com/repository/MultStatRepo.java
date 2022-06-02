package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.stats.MultStats;

@Repository
public interface MultStatRepo extends JpaRepository<MultStats, Integer>  {
	
}