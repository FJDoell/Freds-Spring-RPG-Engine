package com.effects.byTurn;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ByTurnEffectRepo extends JpaRepository<ByTurnEffect, Integer> {

}
