package com.main.menu;

import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * This is where you'll put your actual menus!
 * I recommend putting the main menu here.
 * @author darkm
 *
 */
@Service
public class MenuService {

	public Menu generateInput(InputType inputType, String desiredInput) {
		Menu myMenu = new Menu(desiredInput);
		switch(inputType) {
		case INPUT_INT:
			myMenu.requestInputInt(desiredInput);
			break;
		case INPUT_INT_POSITIVE:
			myMenu.requestInputPositiveInt(desiredInput);
			break;
		case INPUT_STRING:
			myMenu.requestInputString(desiredInput);
			break;
		default:
			myMenu.invalidInputType();
			break;
		}
		return myMenu;
	}
	
	public String generateChoices(String menuName, String menuDescription, Set<String> options, Set<String> opDescs) {
		Menu myMenu = new Menu(menuName, menuDescription, options, opDescs);
		return myMenu.getReturnedChoice();
	}
}
