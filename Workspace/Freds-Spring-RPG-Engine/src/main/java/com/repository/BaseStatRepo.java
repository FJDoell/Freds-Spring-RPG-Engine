package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.stats.BaseStats;

@Repository
public interface BaseStatRepo extends JpaRepository<BaseStats, Integer>  {

}