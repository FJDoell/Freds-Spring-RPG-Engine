package com.effects;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterModel;
import com.character.CharacterService;
import com.effects.core.DamageService;
import com.effects.core.DeathService;
import com.effects.core.HealService;
import com.effects.core.ReviveService;
import com.effects.elements.Elements;
import com.exceptions.MissingTypeException;

/**
 * Handles the direct APPLYING of effects given.
 * @author darkm
 *
 */
@Service
public class EffectApplyService {
	
	@Autowired
	DamageService damageServ;
	
	@Autowired
	DeathService deathServ;
	
	@Autowired
	HealService healServ;
	
	@Autowired
	ReviveService reviveServ;
	
	@Autowired
	CharacterService charServ;
	
	/**
	 * Handles the effects themselves, for each ENUM added, this needs an equivalent ELSE statement.
	 * @param effectNum
	 * @param myEffectType
	 * @param c
	 * @return
	 * @throws MissingTypeException 
	 */
	public CharacterModel checkEffect(double effectNum, EffectType myEffectType, Set<Elements> effectElements, CharacterModel c) throws MissingTypeException {
		if(myEffectType.equals(EffectType.RAW_DAMAGE)) {
			damageServ.dealDamage(c, effectElements, (int)Math.round(c.getHp() - effectNum));
			return c;
		} else if(myEffectType.equals(EffectType.PERCENT_DAMAGE)) {
			damageServ.dealDamage(c, effectElements, (int)Math.round(c.getHp() - c.getMaxHp() * effectNum));
			return c;
		} else if(myEffectType.equals(EffectType.CHECK_HP)) {
			deathServ.checkDead(c);
			return c;
		} else if(myEffectType.equals(EffectType.RAW_HEAL)) {
			healServ.healDamage(c, (int)Math.round(charServ.calcTotalWis(c) + effectNum));
		} else if(myEffectType.equals(EffectType.PERCENT_HEAL)) {
			
		} else if(myEffectType.equals(EffectType.REVIVE)) {
			
		} else {
			throw new MissingTypeException("INVALID EFFECT TYPE " + myEffectType + ","
					+ "please define it in com.model.EffectType.java and handle it in EffectApplyService.");
		}
		return c;
	}

	/**
	 * Gets the apply effect from the given effect and uses checkEffect
	 * to apply any effects.
	 * @param effect
	 * @param c
	 * @return
	 * @throws MissingTypeException 
	 */
	public CharacterModel applyEffect(Effect effect, CharacterModel c) throws MissingTypeException {
		EffectType myEffectType = effect.getApplyEffect();
		double myEffectNum = effect.getEffectNum();
		Set<Elements> myEffectElements = effect.getElements();
		checkEffect(myEffectNum, myEffectType, myEffectElements, c);
		return c;
	}
	
	/**
	 * Gets the remove effect from the given effect and uses checkEffect
	 * to apply any effects.
	 * @param effect
	 * @param c
	 * @return
	 * @throws MissingTypeException 
	 */
	public CharacterModel removeEffect(Effect effect, CharacterModel c) throws MissingTypeException {
		EffectType myEffectType = effect.getRemoveEffect();
		double myEffectNum = effect.getEffectNum();
		Set<Elements> myEffectElements = effect.getElements();
		checkEffect(myEffectNum, myEffectType, myEffectElements, c);
		return c;
	}

}
