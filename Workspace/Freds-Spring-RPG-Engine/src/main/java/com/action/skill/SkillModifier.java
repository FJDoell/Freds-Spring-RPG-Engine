package com.action.skill;

/**
 * Who AMONG that group gets targeted?<br>
 * NONE - For special, custom skills with no target.<br>
 * TARGET - Single target.<br>
 * EXCEPT_TARGET - All except target chosen among the group.<br>
 * @author darkm
 *
 */
public enum SkillModifier {
	NONE, TARGET, EXCEPT_TARGET;
}
