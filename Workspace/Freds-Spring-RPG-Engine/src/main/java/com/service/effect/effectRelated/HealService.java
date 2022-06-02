package com.service.effect.effectRelated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Restrictions;
import com.model.character.CharacterModel;
import com.service.MessageService;

@Service
public class HealService {

	@Autowired
	MessageService messageServ;

	public CharacterModel healDamage(CharacterModel c, int damage) {
		if (!c.getRestrictions().contains(Restrictions.CANNOT_BE_HEALED)) {
			c.setHp(c.getHp() + damage);
			checkMaxHp(c);
		}
		return c;
	}

	public CharacterModel checkMaxHp(CharacterModel c) {
		if (c.getHp() >= c.getMaxHp()) {
			c.setHp(c.getMaxHp());
			messageServ.fullHp(c.getName());
		}
		return c;
	}

}
