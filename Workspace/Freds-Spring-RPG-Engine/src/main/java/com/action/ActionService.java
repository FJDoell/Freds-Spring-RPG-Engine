package com.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.action.target.ActionTargetHelper;
import com.battle.BattleService;
import com.character.CharacterModel;
import com.character.Restrictions;
import com.effects.byTurn.ByTurnEffect;
import com.effects.byTurn.ByTurnEffectService;
import com.effects.instant.InstantEffect;
import com.effects.instant.InstantEffectService;
import com.exceptions.MissingTypeException;
import com.messaging.MessageService;

/**
 * This will handle the executing of actions.
 * @author darkm
 *
 */
@Service
public class ActionService {
	
	@Autowired
	MessageService messages;
	
	@Autowired
	InstantEffectService instantServ;
	
	@Autowired
	ByTurnEffectService byTurnServ;
	
	@Autowired
	ActionTargetHelper targetServ;
	
	@Autowired
	BattleService battleServ;
	
	public Action setTargetsAndExecute(Action a) throws MissingTypeException {
		List<CharacterModel> targets = targetServ.getTargetGroup(a, battleServ.getAllBattlers());
		for(CharacterModel c : targets) {
			a.setTarget(c);
			execute(a);
		}
		return a;
	}
	
	/**
	 * This will take the effects from this action, and apply them from the user to the target
	 * @throws MissingTypeException 
	 */
	public Action execute(Action a) throws MissingTypeException {
		if(!a.getActor().getRestrictions().contains(Restrictions.CANNOT_MOVE)) {
			if(a.getTarget().getRestrictions().containsAll(a.getActionScope().getTargetRestrictions())) {
				messages.noEffect(a.getTarget().getName());
				// Only execute chain skill after failing if CONTINUE is enabled.
				if(a.getChainHandle().equals(ChainActionHandling.CONTINUE)) {
					executeChain(a);
				}
			} else {
				for(int i = 0; i < a.getRepeat(); i++) {
					messages.takeActionMessage(a.getName(), a.getActor().getName(), a.getTarget().getName());
					for(InstantEffect ie : a.getInstantEffects())
						instantServ.onApply(ie, a.getTarget());
					for(ByTurnEffect ie : a.getByTurnEffects())
						byTurnServ.addEffect(ie, a.getTarget());
					// Execute chain skill
					executeChain(a);
				}
			}
		} else {
			messages.cannotMoveMessage(a.getName(), a.getActor().getName());
		}
		return a;
	}
	
	/**
	 * Get the chain action and then execute it.
	 * @param a
	 * @return
	 * @throws MissingTypeException
	 */
	public Action executeChain(Action a) throws MissingTypeException {
		if(a.getChainAction() != null) {
			Action chainAct = a.getChainAction();
			// A chain action has the same user and target as the previous one.
			// But the way it handles that target can still be different.
			chainAct.setActor(a.getActor());
			chainAct.setTarget(a.getTarget());
			execute(chainAct);
		}
		return a;
	}
}
