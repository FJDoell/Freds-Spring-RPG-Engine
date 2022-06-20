package com.global;

/**
 * A setting for the global settings.
 * Whether when calculating final damage if the multiplier is applied before or after
 * flat additions.
 * <br><br>
 * --ADD_FIRST--<br>
 * (100 - 25) * 0.75 = 56 <br>
 * (100 - 50) * 0.5 = 25 <br>
 * (100 + 25) * 1.25 = 156 <br>
 * (100 + 50) * 1.5 = 225 <br>
 * (100 + 25) * 0.75 = 93.75<br>
 * (100 - 25) * 1.25 = 93.75<br>
 * This makes weakness multipliers stronger, and makes resistances weaker.
 * <br><br>
 * --MULTIPLY FIRST--<br>
 * (100 * 0.75) - 25 = 50 <br>
 * (100 * 0.5) - 50 = 0 <br>
 * (100 * 1.25) + 25 = 150<br>
 * (100 * 1.5) + 50 = 200<br>
 * (100 * 1.25) - 25 = 100<br>
 * (100 * 0.75) + 25 = 100<br>
 * Resistance multipliers will be much more impactful.
 * Equivalent flat resists and multipliers will cancel out.
 * 
 * @author darkm
 *
 */
public enum DamageFormulaOrder {
	ADD_FIRST, MULTIPLY_FIRST;
}
