package com.character;

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

}
