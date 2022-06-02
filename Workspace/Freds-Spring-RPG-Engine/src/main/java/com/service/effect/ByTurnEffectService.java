package com.service.effect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.character.CharacterModel;
import com.model.effects.ByTurnEffect;

@Service
public class ByTurnEffectService {
	
	@Autowired
	EffectApplyService effectServ;

	public CharacterModel onApply(ByTurnEffect te, CharacterModel c) {
		c.getByTurnEffects().add(te);
		if(te.getStacks() < te.getMaxStacks())
			te.setStacks(te.getStacks()+1);
		for(int i = 0; i < te.getStacks(); i++) {
			if(tickTurn(te)) {
				System.out.println("By turn effect applied: " + te.getName());
				applyEffect(te, c);
				te.setExecuteTimes(te.getExecuteTimes()+1);
			}
			if(te.getExecuteTimes() <= 0) {
				onRemove(te, c);
				c.getByTurnEffects().remove(te);
			}
		}
		return c;
	}
	
	public CharacterModel onRemove(ByTurnEffect te, CharacterModel c) {
		removeEffect(te, c);
		return c;
	}
	
	public CharacterModel applyEffect(ByTurnEffect te, CharacterModel c) {
		effectServ.applyEffect(te, c);
		return c;
	}
	
	public CharacterModel removeEffect(ByTurnEffect te, CharacterModel c) {
		effectServ.removeEffect(te, c);
		return c;
	}
	
	/**
	 * Tick the turn counter by one.
	 * If the turn counter is equal to the interval, execute onApply and reset to 0.
	 */
	public boolean tickTurn(ByTurnEffect te) {
		te.setTurnCounter(te.getTurnCounter()+1);
		if(te.getTurnCounter() >= te.getTurnInterval()) {
			return true;
		}
		return false;
	}
}
