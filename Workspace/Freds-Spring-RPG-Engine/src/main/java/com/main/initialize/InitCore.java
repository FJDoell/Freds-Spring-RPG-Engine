package com.main.initialize;

import org.springframework.stereotype.Service;

import com.main.menu.createMode.CreateMain;

/**
 * In charge of initializing the database with all starting data.
 * @author darkm
 *
 */
@Service
public class InitCore {
	
	public static void initialize() {
		CreateMain.mainMenu();
	}

}
