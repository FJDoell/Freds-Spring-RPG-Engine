package com.character.mods.equipment.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.mods.equipment.Equipment;
import com.main.menu.CoreMenu;
import com.main.menu.MenuService;

@Service
public class InventoryMenu extends CoreMenu {
	
	private EquipmentInventory inventory;
	
	@Autowired
	MenuService menuServ;
	
	public void chooseItem() {
		initMenu("INVENTORY", "Your inventory is listed beow.");
		
		for(Long key : inventory.getAllKeys())
			options.add(String.valueOf(key));
		for(Equipment e : inventory.getAllEquipments())
			opDescs.add(e.toString());
		
		String selected = menuServ.generateChoices(menuName, menuDescription, options, opDescs);
		
		Equipment selectedItem = inventory.getStoredItem(Long.valueOf(selected));
		
		itemChoices(selectedItem);
	}
	
	public void itemChoices(Equipment e) {
		initMenu("Item " + e.toString(), " Choice");
		
		options.add("Throw away");
		
		options.add("Equip");
		
		
		
	}

}
