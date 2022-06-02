package com.service.effect.effectRelated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Restrictions;
import com.model.character.CharacterModel;
import com.service.MessageService;

@Service
public class ReviveService {
	
	@Autowired
	MessageService messageServ;

	public CharacterModel revive(CharacterModel c) {
		if(c.getRestrictions().contains(Restrictions.CAN_BE_REVIVED) && c.getHp() <= 0) {
			c.getRestrictions().remove(Restrictions.CANNOT_MOVE);
			c.getRestrictions().remove(Restrictions.CANNOT_BE_ATTACKED);
			c.getRestrictions().remove(Restrictions.CANNOT_BE_HEALED);
			c.getRestrictions().remove(Restrictions.CAN_BE_REVIVED);
			messageServ.reviveMessage(c.getName());
		} else {
			messageServ.noEffect(c.getName());
		}
		return c;
	}
	
}
