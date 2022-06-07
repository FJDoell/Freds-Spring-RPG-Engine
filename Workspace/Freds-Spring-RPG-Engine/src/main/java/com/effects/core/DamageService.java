package com.effects.core;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterModel;
import com.character.Restrictions;
import com.effects.elements.ElementResistance;
import com.effects.elements.ElementService;
import com.effects.elements.Elements;
import com.exceptions.MissingTypeException;
import com.global.GlobalSettingService;
import com.global.ResistanceStacking;
import com.messaging.MessageService;

/**
 * Handles damaging a target and checking for restrictions related to damage.
 * Restrictions used are listed below:
 * NO_DAMAGE, CANNOT_MOVE, CANNOT_BE_ATTACKED, CANNOT_BE_HEALED, CAN_BE_REVIVED
 * 
 * @author darkm
 *
 */
@Service
public class DamageService {
	
	@Autowired
	GlobalSettingService globalSettings;

	@Autowired
	MessageService messageServ;
	
	@Autowired
	ElementService elementServ;

	public CharacterModel dealDamage(CharacterModel c, Set<Elements> elements, int damage) throws MissingTypeException {
		if (!c.getRestrictions().contains(Restrictions.NO_DAMAGE)) {
			// ELEMENT MOD
			damage = calculateResistance(elementServ.getTotalResistances(c), elements, damage);
			
			if(damage < globalSettings.getMINIMUM_DAMAGE())
				damage = globalSettings.getMINIMUM_DAMAGE();
			if(damage > globalSettings.getMAX_DAMAGE())
				damage = globalSettings.getMAX_DAMAGE();
			c.setHp(c.getHp() - damage);
		}
		return c;
	}
	
	// ELEMENT MOD
	public int calculateResistance(Set<ElementResistance> resistSet, Set<Elements> elements, int damage) throws MissingTypeException {
		int totalDamageMod = 0;
		double totalMultiplier = 1.0;
		for(ElementResistance er : resistSet) {
			Elements elementMatcher = er.getElement();
			if(elements.contains(elementMatcher)) {
				if (globalSettings.getRESIST_STACK_STYLE().equals(ResistanceStacking.STACK_ADD)) {
					totalDamageMod = totalDamageMod + er.getResistFlat();
					totalMultiplier = totalMultiplier + er.getResistMultiplier() - 1.0;
				} else if (globalSettings.getRESIST_STACK_STYLE().equals(ResistanceStacking.STACK_MULTIPLY)) {
					totalDamageMod = totalDamageMod + er.getResistFlat();
					totalMultiplier = totalMultiplier * er.getResistMultiplier();
				} else if (globalSettings.getRESIST_STACK_STYLE().equals(ResistanceStacking.DO_NOT_STACK)) {
					if(Math.abs(er.getResistFlat()) > Math.abs(totalDamageMod))
						totalDamageMod = er.getResistFlat();
					if(Math.abs(er.getResistMultiplier() - 1.0) > Math.abs(totalMultiplier - 1.0))
						totalMultiplier = er.getResistMultiplier();
				} else {
					throw new MissingTypeException("INVALID RESIST STACKING TYPE " + globalSettings.getRESIST_STACK_STYLE() + ","
							+ "please define it in com.service.global.ResistanceStacking and handle it in DamageService.");
				}
				
			}
		}
		damage = damage - totalDamageMod;
		damage = (int) (damage * totalMultiplier);
		if (globalSettings.getRESIST_STACK_STYLE().equals(ResistanceStacking.STACK_ADD)) {
			damage = (int) (damage * totalMultiplier);
		}
		return damage;
	}
}
