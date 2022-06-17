package com.effects.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterModel;
import com.character.Restrictions;
import com.messaging.MessageService;

@Service
public class ReviveService {
	
	@Autowired
	MessageService messageServ;

	public CharacterModel revive(CharacterModel c) {
		if(!c.getRestrictions().contains(Restrictions.CANNOT_BE_REVIVED) && c.getHp() <= 0) {
			c.getRestrictions().remove(Restrictions.DEAD);
			c.getRestrictions().remove(Restrictions.CANNOT_MOVE);
			c.getRestrictions().remove(Restrictions.CANNOT_BE_ATTACKED);
			c.getRestrictions().remove(Restrictions.CANNOT_BE_HEALED);
			c.getRestrictions().remove(Restrictions.CANNOT_BE_REVIVED);
			messageServ.reviveMessage(c.getName());
		} else {
			messageServ.noEffect(c.getName());
		}
		return c;
	}
	
}
