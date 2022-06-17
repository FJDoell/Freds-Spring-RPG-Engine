package com.character;

/**
 * Essentially, these are used to "cancel out" effects.
 * 
 * They're like a bunch of flags that a character can contain,
 * and for classes to check for.
 * It's extremely customizable.
 * All restrictions MUST be CANNOT__ for consistency.
 * @author darkm
 *
 */
public enum Restrictions {
	// SPECIAL
	DEAD,
	// ACTION RELATED
	CANNOT_MOVE,
	CANNOT_ATTACK,
	CANNOT_HEAL,
	// TARGET RELATED
	CANNOT_BE_ATTACKED,
	CANNOT_BE_HEALED,
	CANNOT_BE_REVIVED,
	// EFFECT RELATED
	CANNOT_DIE,
	NO_DAMAGE
}
