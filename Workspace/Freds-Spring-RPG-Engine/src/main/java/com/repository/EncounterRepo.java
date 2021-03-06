package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encounter.Encounter;

@Repository
public interface EncounterRepo extends JpaRepository<Encounter, Integer> {

}
