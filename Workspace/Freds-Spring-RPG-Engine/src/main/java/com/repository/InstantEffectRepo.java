package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effects.instant.InstantEffect;

@Repository
public interface InstantEffectRepo extends JpaRepository<InstantEffect, Integer>  {

}
