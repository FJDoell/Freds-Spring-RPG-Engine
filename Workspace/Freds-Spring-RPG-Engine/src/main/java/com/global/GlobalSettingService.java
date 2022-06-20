package com.global;

import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * Universally used general settings, such as minimum damage dealt.
 * 
 * Anything that should be CONSISTENT across the ENTIRE game goes here.
 * @author darkm
 *
 */
@Service
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GlobalSettingService {
	int MINIMUM_DAMAGE = 1;
	int MAX_DAMAGE = 9999;
	String GOLD_NAME = "Gold";
	int MAX_GOLD = 2_000_000_000;
	// PARTY
	int MAX_ACTIVE_MEMBERS = 0; // 0 is infinite
	int MAX_RESERVE_MEMBERS = 0;
	
	// GAME OVER
	// attempt to switch in reserve members on party wipe?
	boolean switchToReserveOnGameOver = true;
	
	ResistanceStacking RESIST_STACK_STYLE = ResistanceStacking.STACK_MULTIPLY;
	ResistanceStacking RESIST_STACK_DAMAGE = ResistanceStacking.STACK_ADD;
	DamageFormulaOrder DAMAGE_FORMULA_ORDER = DamageFormulaOrder.ADD_FIRST;
}
