package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.character.Monster;

@Repository
public interface MonsterRepo extends JpaRepository<Monster, Integer> {

}
