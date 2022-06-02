package com.service.effect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.character.CharacterModel;
import com.model.effects.InstantEffect;

@Service
public class InstantEffectService {
	
	@Autowired
	EffectApplyService effectServ;
	
	/**
	 * Executed on addition of effect.
	 */
	public CharacterModel onApply(InstantEffect ie, CharacterModel c) {
		effectServ.applyEffect(ie, c);
		return c;
	}

	/**
	 * Executed on removal of an effect. Not particularly useful for an instant.
	 */
	public CharacterModel onRemove(InstantEffect ie, CharacterModel c) {
		effectServ.removeEffect(ie, c);
		c.getInstantEffects().remove(ie);
		return c;
	}
}
