package com.effects.byTurn;

/**
 * How should stacking be handled on this specific ByTurnEffect when at max stacks?<br>
 * NONE - No further effects at max stacks.
 * TICK - Tick the effect up by one.
 * 
 * @author darkm
 *
 */
public enum StackHandling {
	NONE, TICK;
}
