package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.effects.InstantEffect;

@Repository
public interface InstantEffectRepo extends JpaRepository<InstantEffect, Integer>  {

}
