package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effects.byTurn.ByTurnEffect;

@Repository
public interface ByTurnEffectRepo extends JpaRepository<ByTurnEffect, Integer> {

}
