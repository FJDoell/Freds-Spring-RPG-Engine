package com.action.skill.criteria;

/**
 * Target choosing tags, they decide how a skill's target should be chosen given a group of
 * target characters.
 * Targets will be shuffled using Collections.shuffle().
 * @author darkm
 *
 */
public enum PickTargetCriteria {
	// ANY
	RANDOM,
	// BY STAT
	HIGHEST_HP, LOWEST_HP,
	HIGHEST_MP, LOWEST_MP,
	HIGHEST_ATK, LOWEST_ATK,
	HIGHEST_DEF, LOWEST_DEF,
	HIGHEST_INT, LOWEST_INT,
	HIGHEST_WIS, LOWEST_WIS,
	HIGHEST_SPD, LOWEST_SPD;
}
