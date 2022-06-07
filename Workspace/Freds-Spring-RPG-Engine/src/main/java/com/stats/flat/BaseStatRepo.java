package com.stats.flat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseStatRepo extends JpaRepository<BaseStats, Integer>  {

}