package com.service.character;

import org.springframework.beans.factory.annotation.Autowired;

import com.model.character.CharacterModel;
import com.model.equip.Equipment;
import com.service.StatService;

/**
 * Handles equipping and unequipping. Adjusting bonus stats accordingly.
 * 
 * @author darkm
 */
public class EquipService {
	
	@Autowired
	StatService statServ;

	public CharacterModel addEquip(CharacterModel c, Equipment equip) {
		addEquipmentFlatStats(c, equip);
		addEquipmentMultStats(c, equip);
		return c;
	}
	
	public CharacterModel removeEquip(CharacterModel c, Equipment equip) {
		removeEquipmentFlatStats(c, equip);
		removeEquipmentMultStats(c, equip);
		return c;
	}

	public CharacterModel addEquipmentFlatStats(CharacterModel c, Equipment equip) {
		c.setBonusStats(statServ.addFlatStats(c.getBonusStats(), equip.getBaseStats()));
		return c;
	}
	
	public CharacterModel removeEquipmentFlatStats(CharacterModel c, Equipment equip) {
		c.setBonusStats(statServ.subtractFlatStats(c.getBonusStats(), equip.getBaseStats()));
		return c;
	}
	
	public CharacterModel addEquipmentMultStats(CharacterModel c, Equipment equip) {
		c.setBonusMultStats(statServ.addMultStats(c.getBonusMultStats(), equip.getMultStats()));
		return c;
	}

	public CharacterModel removeEquipmentMultStats(CharacterModel c, Equipment equip) {
		c.setBonusMultStats(statServ.subtractMultStats(c.getBonusMultStats(), equip.getMultStats()));
		return c;
	}

}
