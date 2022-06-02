package com.service.global;

/**
 * Determines how resistances stack.
 * Note that resistance stacking style is separate when adding resistances together, vs dealing with multi-element attacks!
 * <pre></pre>
 * Settings are as follows:
 * <pre></pre>
 * STACK_ADD: All resistances stack additively.
 * <pre></pre>
 * STACK_MULTIPLY: Stack multiplicatively.
 * <pre></pre>
 * DO_NOT_STACK: Highest resistance is used. Multi-element resists take the highest resists.
 * @author darkm
 *
 */
public enum ResistanceStacking {
	STACK_MULTIPLY, STACK_ADD, DO_NOT_STACK;
}
