package com.main.menu;

import java.util.HashSet;
import java.util.Set;

/**
 * The basis for all menu classes.
 * Extend this and autowire MenuService.
 * @author darkm
 *
 */
public abstract class CoreMenu {

	protected String menuName = "MENU NAME";
	protected String menuDescription = "Your menu description.";
	protected String selected = "MAIN";
	protected Set<String> options = new HashSet<String>();
	protected Set<String> opDescs = new HashSet<String>();
	
//	protected MenuService menuServ;
	
	public void initMenu(String name, String desc) {
		options.clear();
		opDescs.clear();
		menuName = name;
		menuDescription = desc;
	}
}
