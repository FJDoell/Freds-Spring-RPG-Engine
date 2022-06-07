package com.character.mods.equipment;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.character.mods.CharacterMods;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="equipSets")
@Getter
public class EquipmentSet extends CharacterMods {
	// Unique identifier for this mod. Used in CharacterModel
	@Transient
	final String modId = ModConfig.MOD_ID.getId();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	// Equipment associated
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_equip_id")
	Set<Equipment> equipment;
}
