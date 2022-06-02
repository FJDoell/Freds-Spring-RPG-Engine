package com.service.effect.effectRelated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Restrictions;
import com.model.character.CharacterModel;
import com.service.MessageService;

/**
 * Handles restrictions related to death.
 * @author darkm
 *
 */
@Service
public class DeathService {
	
	@Autowired
	MessageService messageServ;
	
	public CharacterModel checkDead(CharacterModel c) {
		if (c.getHp() <= 0) {
			if(!c.getRestrictions().contains(Restrictions.CANNOT_DIE)) {
				c.getRestrictions().add(Restrictions.CANNOT_MOVE);
				c.getRestrictions().add(Restrictions.CANNOT_BE_ATTACKED);
				c.getRestrictions().add(Restrictions.CANNOT_BE_HEALED);
				c.getRestrictions().add(Restrictions.CAN_BE_REVIVED);
				messageServ.deathMessage(c.getName());
			} else {
				// they can't die; HP is 1.
				messageServ.deathResist(c.getName());
				c.setHp(1);
			}
		}
		return c;
	}
}
