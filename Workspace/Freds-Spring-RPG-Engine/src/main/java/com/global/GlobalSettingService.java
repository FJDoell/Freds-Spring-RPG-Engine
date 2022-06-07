package com.global;

import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * Universally used general settings, such as minimum damage dealt.
 * 
 * Anything that should be CONSISTENT across the ENTIRE game goes here.
 * @author darkm
 *
 */
@Service
@Data
public class GlobalSettingService {
	final int MINIMUM_DAMAGE = 1;
	final int MAX_DAMAGE = 9999;
	final ResistanceStacking RESIST_STACK_STYLE = ResistanceStacking.STACK_MULTIPLY;
	final ResistanceStacking RESIST_STACK_DAMAGE = ResistanceStacking.STACK_ADD;
	final DamageFormulaOrder DAMAGE_FORMULA_ORDER = DamageFormulaOrder.ADD_FIRST;
}
