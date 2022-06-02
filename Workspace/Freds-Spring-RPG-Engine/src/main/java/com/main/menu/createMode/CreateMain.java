package com.main.menu.createMode;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.MainMenuService;
import com.repository.CharacterRepo;
import com.repository.EquipmentRepo;

/**
 * Handles create mode for all sorts of repositories.
 * 
 * @author darkm
 *
 */
@Service
public class CreateMain {
	
	@Autowired
	EquipmentRepo equipRepo;
	
	@Autowired
	CharacterRepo charRepo;

	static Scanner input = new Scanner(System.in);
	static String menuName = "CREATE: MAIN MENU";
	static String menuDescription = "Welcome! Go to create something special below.";
	static String selected = "MAIN";
	static ArrayList<String> options = new ArrayList<String>();
	static ArrayList<String> opDescs = new ArrayList<String>();

	// MAIN MENU
	public static void mainMenu() {
		options.clear();
		opDescs.clear();
		menuName = "CREATE: MAIN MENU";
		menuDescription = "Welcome! Go to create something special below.";

		options.add("EquipType");
		opDescs.add("Create new equipment TYPE");
		options.add("Equipment");
		opDescs.add("Create new equipment");
		options.add("Character");
		opDescs.add("Create a new character");

		selected = MainMenuService.printMenu(input, menuName, menuDescription, options, opDescs);
		if (selected.equals("EQUIPMENT")) {

		} else if (selected.equals("CHARACTER")) {

		} else {
			mainMenu();
		}
	}

	public void createEquipment() {
		
	}
}
