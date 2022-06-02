package com.service.character;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exceptions.MissingTypeException;
import com.model.builders.stats.BaseStatBuilder;
import com.model.character.CharacterModel;
import com.model.effects.ByTurnEffect;
import com.model.effects.InstantEffect;
import com.model.effects.resists.ElementResistance;
import com.model.equip.Equipment;
import com.model.stats.BaseStats;
import com.repository.CharacterRepo;
import com.service.effect.ByTurnEffectService;
import com.service.effect.InstantEffectService;
import com.service.effect.effectRelated.ElementService;

/**
 * Handles stuff to do with characters specifically
 * 
 * @author darkm
 *
 */
@Service
public class CharacterService {

	@Autowired
	CharacterRepo repo;

	@Autowired
	InstantEffectService instantEffectService;

	@Autowired
	ByTurnEffectService byTurnEffectService;
	
	@Autowired
	EquipService equipServ;
	
	@Autowired
	ElementService elementServ;

	////////////////////////////////
	// Calculate the totals of STATS
	////////////////////////////////
	/**
	 * Given a character, return a BaseStats object containing
	 * the totals of all their bonuses added together.
	 * @param c
	 * @return
	 */
	public BaseStats getTotalStats(CharacterModel c) {
		BaseStats totalStats = 
				new BaseStatBuilder()
				.withHp(calcTotalHp(c))
				.withMp(calcTotalMp(c))
				.withAtk(calcTotalAtk(c))
				.withDef(calcTotalDef(c))
				.withBaseInt(calcTotalIntelligence(c))
				.withWis(calcTotalWis(c))
				.withSpd(calcTotalSpd(c))
				.build();
		return totalStats;
	}
	
	public int calcTotalHp(CharacterModel c) {
		int baseTotal = c.getBaseStats().getHp() + c.getBonusStats().getHp();
		double multTotal = c.getBaseMultStats().getHp() + c.getBonusMultStats().getHp();
		return (int) (baseTotal * multTotal);
	}
	
	public int calcTotalMp(CharacterModel c) {
		int baseTotal = c.getBaseStats().getMp() + c.getBonusStats().getMp();
		double multTotal = c.getBaseMultStats().getMp() + c.getBonusMultStats().getMp();
		return (int) (baseTotal * multTotal);
	}
	
	public int calcTotalAtk(CharacterModel c) {
		int baseTotal = c.getBaseStats().getAtk() + c.getBonusStats().getAtk();
		double multTotal = c.getBaseMultStats().getAtk() + c.getBonusMultStats().getAtk();
		return (int) (baseTotal * multTotal);
	}
	
	public int calcTotalDef(CharacterModel c) {
		int baseTotal = c.getBaseStats().getDef() + c.getBonusStats().getDef();
		double multTotal = c.getBaseMultStats().getDef() + c.getBonusMultStats().getDef();
		return (int) (baseTotal * multTotal);
	}
	
	public int calcTotalIntelligence(CharacterModel c) {
		int baseTotal = c.getBaseStats().getBaseInt() + c.getBonusStats().getBaseInt();
		double multTotal = c.getBaseMultStats().getBaseInt() + c.getBonusMultStats().getBaseInt();
		return (int) (baseTotal * multTotal);
	}
	
	public int calcTotalWis(CharacterModel c) {
		int baseTotal = c.getBaseStats().getWis() + c.getBonusStats().getWis();
		double multTotal = c.getBaseMultStats().getWis() + c.getBonusMultStats().getWis();
		return (int) (baseTotal * multTotal);
	}
	
	public int calcTotalSpd(CharacterModel c) {
		int baseTotal = c.getBaseStats().getSpd() + c.getBonusStats().getSpd();
		double multTotal = c.getBaseMultStats().getSpd() + c.getBonusMultStats().getSpd();
		return (int) (baseTotal * multTotal);
	}
	
	public HashSet<ElementResistance> getTotalResistances(CharacterModel c) throws MissingTypeException {
		HashSet<ElementResistance> resistTotal = new HashSet<ElementResistance>();
		resistTotal.addAll(elementServ.addResistances(c.getBonusResistances(), c.getNatResistances()));
		return resistTotal;
	}
	
	// Add equipment
	public CharacterModel addEquip(CharacterModel c, Equipment equip) {
		equipServ.addEquip(c, equip);
		return c;
	}
	
	// Remove equipment
	public CharacterModel removeEquip(CharacterModel c, Equipment equip) {
		equipServ.removeEquip(c, equip);
		return c;
	}
	
	// INSTANT EFFECTS
	public CharacterModel instantEffects(CharacterModel c) {
		for (InstantEffect i : c.getInstantEffects())
			instantEffectService.onApply(i, c);
		return c;
	}

	// TURN EFFECT CHECKS
	public CharacterModel tickTurns(CharacterModel c) {
		for (ByTurnEffect te : c.getByTurnEffects())
			byTurnEffectService.onApply(te, c);
		return c;
	}
}
