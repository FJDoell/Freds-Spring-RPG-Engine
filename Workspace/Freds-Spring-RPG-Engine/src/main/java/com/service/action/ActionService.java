package com.service.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Restrictions;
import com.model.actions.Action;
import com.service.MessageService;

/**
 * This will handle the executing of actions.
 * @author darkm
 *
 */
@Service
public class ActionService {
	
	@Autowired
	MessageService messages;
	
	/**
	 * This will take the effects from this action, and apply them from the user to the target
	 */
	public void execute(Action a) {
		if(!a.getActor().getRestrictions().contains(Restrictions.CANNOT_MOVE)) {
			messages.takeActionMessage(a.getName(), a.getActor().getName(), a.getTarget().getName());
			a.getTarget().getInstantEffects().addAll(a.getInstantEffects());
			a.getTarget().getByTurnEffects().addAll(a.getByTurnEffects());
		} else {
			messages.cannotMoveMessage(a.getName(), a.getActor().getName());
		}
	}
}
