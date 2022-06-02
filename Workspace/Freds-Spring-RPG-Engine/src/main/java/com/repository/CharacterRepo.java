package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.character.CharacterModel;

@Repository
public interface CharacterRepo extends JpaRepository<CharacterModel, Integer> {
}
