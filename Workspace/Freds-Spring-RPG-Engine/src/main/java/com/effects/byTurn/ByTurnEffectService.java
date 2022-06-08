package com.effects.byTurn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterModel;
import com.effects.EffectApplyService;
import com.exceptions.MissingTypeException;

@Service
public class ByTurnEffectService {

	@Autowired
	EffectApplyService effectServ;

	public CharacterModel tickTurns(CharacterModel c) throws MissingTypeException {
		for (ByTurnEffect te : c.getByTurnEffects())
			onTick(te, c);
		return c;
	}

	public CharacterModel onTick(ByTurnEffect te, CharacterModel c) throws MissingTypeException {
		if (tickTurn(te)) {
			System.out.println("By turn effect applied: " + te.getName());
			for (int i = 0; i < te.getStacks(); i++)
				applyEffect(te, c);
			if(te.getExecuteCount() >= te.getExecuteTimes() * te.getStacks())
				onRemove(te, c);
		}
		return c;
	}

	/**
	 * Tick the turn counter by one. If the turn counter is equal to the interval,
	 * execute onApply and reset to 0.
	 */
	public boolean tickTurn(ByTurnEffect te) {
		te.setTurnCounter(te.getTurnCounter() + 1);
		if (te.getTurnCounter() >= te.getTurnInterval()) {
			return true;
		}
		return false;
	}

	public CharacterModel onRemove(ByTurnEffect te, CharacterModel c) throws MissingTypeException {
		removeEffect(te, c);
		return c;
	}

	public CharacterModel applyEffect(ByTurnEffect te, CharacterModel c) throws MissingTypeException {
		effectServ.applyEffect(te, c);
		te.setExecuteCount(te.getExecuteCount() + 1);
		return c;
	}

	public CharacterModel removeEffect(ByTurnEffect te, CharacterModel c) throws MissingTypeException {
		effectServ.removeEffect(te, c);
		return c;
	}

	public CharacterModel addEffect(ByTurnEffect te, CharacterModel c) throws MissingTypeException {
		boolean alreadyAdded = false;
		for (ByTurnEffect t : c.getByTurnEffects()) {
			if (t.getId() == te.getId()) {
				alreadyAdded = true;
				if (te.getStacks() < te.getMaxStacks()) {
					te.setStacks(te.getStacks() + 1);
				} else {
					if (te.getStackHandleType().equals(StackHandling.TICK))
						onTick(t, c);
				}
			}
		}
		if (!alreadyAdded)
			c.getByTurnEffects().add(te);
		return c;
	}
}
