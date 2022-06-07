package com.character.mods.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterModel;
import com.stats.StatService;

/**
 * Handles equipping and unequipping. Adjusting bonus stats accordingly.
 * 
 * @author darkm
 */
@Service
public class EquipService {

	@Autowired
	StatService statServ;

	public CharacterModel addEquip(CharacterModel c, Equipment equip) {
		// get the character equip set
		EquipmentSet set = getEquipSet(c);

		// add to equip set
		set.getEquipment().add(equip);

		// set equip set
		addEquipmentFlatStats(c, equip);
		addEquipmentMultStats(c, equip);
		return c;
	}

	public EquipmentSet getEquipSet(CharacterModel c) {
		EquipmentSet set = (EquipmentSet) c.getMods().get(ModConfig.MOD_ID.getId());
		if (set == null) {
			set = new EquipmentSet();
			c.getMods().put(set.getModId(), set);
		}
		return set;
	}

	public CharacterModel removeEquip(CharacterModel c, Equipment equip) {
		// get the character equip set
		EquipmentSet set = getEquipSet(c);

		// add to equip set
		set.getEquipment().add(equip);

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
