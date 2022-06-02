package com.service.action;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.actions.Action;
import com.service.MessageService;
import com.service.character.CharacterService;

/**
 * This will handle the action queue and turn order.
 * @author darkm
 *
 */
@Service
public class TurnHandler {
	
	@Autowired
	ActionService actionServ;
	
	@Autowired
	CharacterService charServ;
	
	@Autowired
	MessageService messageServ;
	
	ArrayList<Action> allActions;
	
	/**
	 * Add an action to the queue.
	 * @param a
	 * @return
	 */
	public ArrayList<Action> addAction(Action a) {
		allActions.add(a);
		return allActions;
	}
	
	/**
	 * Standard turn execution. Handles sorting by SPD, executing, and clearing the action queue.
	 */
	public void executeTurn() {
		sortActionsBySpeed();
		executeActions();
		clearActions();
	}
	
	/**
	 * Sort the actions by SPD, accounting for bonus speed and actor speed.
	 * @return
	 */
	public ArrayList<Action> sortActionsBySpeed() {
		for(Action a : allActions) {
			a.setTotalSpd(charServ.calcTotalSpd(a.getActor()) + a.getBonusSpd());
		}
		allActions.sort((a1, a2) -> a2.getTotalSpd() - a1.getTotalSpd());
		return allActions;
	}
	
	/**
	 * Execute the actions list.
	 * @return
	 */
	public ArrayList<Action> executeActions() {
		for(Action a : allActions)
			actionServ.execute(a);
		return allActions;
	}
	
	/**
	 * Clear the action queue.
	 * It's public, so if you really wanted, an InstantEffect could trigger this! Insane.
	 */
	public ArrayList<Action> clearActions() {
		allActions.clear();
		messageServ.endOfTurnMessage();
		return allActions;
	}
}
