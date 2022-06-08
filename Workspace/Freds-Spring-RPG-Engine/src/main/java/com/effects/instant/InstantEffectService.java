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
		effectServ.removeEffect(ie, c);
		return c;
	}
}
