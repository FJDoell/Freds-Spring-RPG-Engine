package com.effects.instant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstantEffectRepo extends JpaRepository<InstantEffect, Integer>  {

}
