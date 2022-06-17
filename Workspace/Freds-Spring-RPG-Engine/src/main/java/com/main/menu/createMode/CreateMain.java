package com.main.menu.createMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterRepo;
import com.character.mods.equipment.EquipmentRepo;
import com.main.menu.CoreMenu;
import com.main.menu.MenuService;

/**
 * Handles create mode for all sorts of repositories.
 * 
 * @author darkm
 *
 */
@Service
public class CreateMain extends CoreMenu {

	@Autowired
	EquipmentRepo equipRepo;

	@Autowired
	CharacterRepo charRepo;

	@Autowired
	MenuService menuServ;

	// MAIN MENU
	public void mainMenu() {
		initMenu("CREATE: MAIN MENU", "Welcome! Go to create something special below.");

		options.add("Characters");
		opDescs.add("Create characters (monsters OR actors)");

		options.add("Equipment");
		opDescs.add("Create new equipment");

		options.add("Character");
		opDescs.add("Create a new character");

		selected = menuServ.generateChoices(menuName, menuDescription, options, opDescs);
		
		if (selected.equals("EQUIPMENT")) {

		} else if (selected.equals("CHARACTER")) {

		} else {
			mainMenu();
		}
	}

	public void createEquipment() {

	}
}
