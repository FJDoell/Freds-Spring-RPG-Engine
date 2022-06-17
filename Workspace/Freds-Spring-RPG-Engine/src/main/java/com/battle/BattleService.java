package com.battle;

import java.util.List;

import org.springframework.stereotype.Service;

import com.character.CharacterModel;

import lombok.Data;

/**
 * Handles an overall encounter, including giving EXP on slain monsters,
 * checking if all monsters were defeated, etc.
 * 
 * @author darkm
 *
 */
@Data
@Service
public class BattleService {
// This will be a lot...Good practice though!
	List<CharacterModel> allBattlers;
	
}
