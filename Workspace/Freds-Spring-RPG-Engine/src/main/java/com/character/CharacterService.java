package com.character;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.character.actor.Actor;

/**
 * Handles stuff to do with characters specifically
 * 
 * @author darkm
 *
 */
@Service
public class CharacterService {

	/**
	 * Check if this Character is an Actor or a Monster.
	 * 
	 * @param c
	 * @return True - Actor.<br>
	 *         False - Monster.
	 */
	public boolean isActor(CharacterModel c) {
		if (Actor.class.isAssignableFrom(c.getClass())) {
			System.out.println("This is an actor");
			return true;
		}
		System.out.println("This is a monster");
		return false;
	}
	
	/**
	 * Get all actors from a given character list.
	 * @param charList
	 * @return
	 */
	public List<CharacterModel> getActors(List<CharacterModel> charList) {
		List<CharacterModel> returned = new ArrayList<CharacterModel>();
		for(CharacterModel c : charList)
			if(isActor(c))
				returned.add(c);
		return returned;
	}
	
	/**
	 * Get all non-actors from a given list of characters.
	 * @param charList
	 * @return
	 */
	public List<CharacterModel> getMonsters(List<CharacterModel> charList) {
		List<CharacterModel> returned = new ArrayList<CharacterModel>();
		for(CharacterModel c : charList)
			if(!isActor(c))
				returned.add(c);
		return returned;
	}

}
