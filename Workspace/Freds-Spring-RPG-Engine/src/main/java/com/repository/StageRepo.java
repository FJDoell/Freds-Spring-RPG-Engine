package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.stage.Stage;

@Repository
public interface StageRepo extends JpaRepository<Stage, Integer> {

}
