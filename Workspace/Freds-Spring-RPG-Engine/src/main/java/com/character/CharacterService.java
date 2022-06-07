package com.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.mods.equipment.EquipService;
import com.character.mods.equipment.Equipment;

/**
 * Handles stuff to do with characters specifically
 * 
 * @author darkm
 *
 */
@Service
public class CharacterService {

	@Autowired
	CharacterRepo repo;
	
	@Autowired
	EquipService equipServ;
	
	// Add equipment
	public CharacterModel addEquip(CharacterModel c, Equipment equip) {
		equipServ.addEquip(c, equip);
		return c;
	}
	
	// Remove equipment
	public CharacterModel removeEquip(CharacterModel c, Equipment equip) {
		equipServ.removeEquip(c, equip);
		return c;
	}
	
}
