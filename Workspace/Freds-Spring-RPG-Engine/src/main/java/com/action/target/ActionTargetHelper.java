package com.action.target;

import java.util.List;

import org.springframework.stereotype.Service;

import com.action.Action;
import com.action.scope.ScopeModel;
import com.character.CharacterModel;
import com.character.actor.Actor;
import com.character.monster.Monster;

@Service
public class ActionTargetHelper {

	/**
	 * This expects all current battlers to be passed as an argument.
	 * 
	 * @param a
	 * @param possibleTargets
	 * @return
	 */
	public List<CharacterModel> getTargetGroup(Action a, List<CharacterModel> possibleTargets) {
		ScopeModel scope = a.getActionScope();
		List<CharacterModel> returnedTargets;

		switch (scope.getTargetGroup()) {
		case ALL:
			return possibleTargets;
		case ALL_ALLIES:
			break;
		case ALL_ENEMIES:
			break;
		case USER:
			
			break;
		default:
			return null;
		}
		return null;
	}
	
	public List<CharacterModel> getAllies(CharacterModel c, List<CharacterModel> possibleTargets) {
		if(Actor.class.isAssignableFrom(c.getClass())) {
			System.out.println("This is an actor");
		} else if(Monster.class.isAssignableFrom(c.getClass())) {
			System.out.println("This is a monster");
		}
		return possibleTargets;
	}
	
	

}
