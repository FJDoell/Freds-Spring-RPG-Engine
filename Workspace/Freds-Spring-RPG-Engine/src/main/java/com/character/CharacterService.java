package com.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.actor.Actor;
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
	EquipService equipServ;
	
	/**
	 * Get the type of this character: Actor, or Monster?<br>
	 * True - Actor.<br>
	 * False - Monster.
	 * @param c
	 * @return
	 */
	public boolean getType(CharacterModel c) {
		if(Actor.class.isAssignableFrom(c.getClass())) {
			System.out.println("This is an actor");
			return true;
		}
		System.out.println("This is a monster");
		return false;
	}
	
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
