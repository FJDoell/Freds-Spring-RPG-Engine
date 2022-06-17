package com.main.initialize;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterModel;
import com.character.actor.Actor;
import com.character.monster.Monster;
import com.main.menu.createMode.CreateMain;

/**
 * In charge of initializing the database with all starting data.
 * @author darkm
 *
 */
@Service
public class InitCore {
	
	@Autowired
	CreateMain createMainMenu;
	
	public void initialize() {
		
		Actor testAct = new Actor();
		checkTypeOfCharacter((CharacterModel) testAct);
		
		Monster testMon = new Monster();
		checkTypeOfCharacter((CharacterModel) testMon);
		
		createMainMenu.mainMenu();
	}
	
	public boolean checkTypeOfCharacter(CharacterModel c) {
		if(Actor.class.isAssignableFrom(c.getClass())) {
			System.out.println("This is an actor");
			return true;
		}
		System.out.println("This is a monster");
		return false;
	}

}
