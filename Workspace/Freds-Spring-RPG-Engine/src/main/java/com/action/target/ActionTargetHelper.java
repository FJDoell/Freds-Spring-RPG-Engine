package com.action.target;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.action.Action;
import com.action.scope.ScopeModel;
import com.character.CharacterModel;
import com.character.CharacterService;

@Service
public class ActionTargetHelper {
	
	@Autowired
	CharacterService charServ;

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
	
	/**
	 * Get the given characters' allies from the given group.
	 * @param c
	 * @param possibleTargets
	 * @return
	 */
	public List<CharacterModel> getAllies(CharacterModel c, List<CharacterModel> possibleTargets) {
		if(charServ.isActor(c)) {
			// actor
			return charServ.getActors(possibleTargets);
		}
		// monster
		return charServ.getMonsters(possibleTargets);
	}
	
	/**
	 * Get the given characters' enemies from the given group.
	 * @param c
	 * @param possibleTargets
	 * @return
	 */
	public List<CharacterModel> getEnemies(CharacterModel c, List<CharacterModel> possibleTargets) {
		if(charServ.isActor(c)) {
			// actor
			return charServ.getMonsters(possibleTargets);
		}
		// monster
		return charServ.getActors(possibleTargets);
	}
	
	

}
