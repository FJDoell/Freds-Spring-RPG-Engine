package com.effects.instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterModel;
import com.effects.EffectApplyService;
import com.exceptions.MissingTypeException;

@Service
public class InstantEffectService {

	@Autowired
	EffectApplyService effectServ;

	/**
	 * Executed on addition of effect.
	 * 
	 * @throws MissingTypeException
	 */
	public CharacterModel onApply(InstantEffect ie, CharacterModel c) throws MissingTypeException {
		effectServ.applyEffect(ie, c);
		return c;
	}

	/**
	 * Executed on removal of an effect. Not particularly useful for an instant.
	 * 
	 * @throws MissingTypeException
	 */
	public CharacterModel onRemove(InstantEffect ie, CharacterModel c) throws MissingTypeException {
		effectServ.removeEffect(ie, c);
		c.getInstantEffects().remove(ie);
		return c;
	}

	public CharacterModel instantEffects(CharacterModel c) throws MissingTypeException {
		for (InstantEffect i : c.getInstantEffects())
			onApply(i, c);
		return c;
	}
}
