package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.equip.Equipment;

@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, Integer> {

}
