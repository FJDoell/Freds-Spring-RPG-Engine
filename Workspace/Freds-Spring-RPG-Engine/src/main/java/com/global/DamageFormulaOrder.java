package com.global;

/**
 * A setting for the global settings.
 * Whether when calculating final damage if the multiplier is applied before or after
 * flat additions.
 * <pre></pre>
 * --ADD_FIRST-- 
 * (100 - 25) * 0.75 = 56 <pre></pre>
 * (100 - 50) * 0.5 = 25 <pre></pre>
 * (100 + 25) * 1.25 = 156 <pre></pre>
 * (100 + 50) * 1.5 = 225 <pre></pre>
 * <pre></pre>
 * (100 * 0.5) - 50 = 0 <pre></pre>
 * (100 * 0.75) - 25 = 50 <pre></pre>
 * (100 * 0.75) - 25 = 50 <pre></pre>
 * (100 * 0.75) - 25 = 50 <pre></pre>
 * 
 * <pre></pre>
 * @author darkm
 *
 */
public enum DamageFormulaOrder {
	ADD_FIRST, MULTIPLY_FIRST;
}
