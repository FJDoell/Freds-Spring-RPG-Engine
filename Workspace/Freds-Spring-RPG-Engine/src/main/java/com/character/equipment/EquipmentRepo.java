package com.character.equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, Integer> {

}
