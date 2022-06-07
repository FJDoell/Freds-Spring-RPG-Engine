package com.stats.mult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultStatRepo extends JpaRepository<MultStats, Integer>  {
	
}