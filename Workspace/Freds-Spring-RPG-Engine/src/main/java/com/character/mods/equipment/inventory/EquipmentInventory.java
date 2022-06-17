package com.character.mods.equipment.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.character.mods.equipment.Equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentInventory {
	
	private long totalStored;
	private Map<Long, Equipment> allItems = new TreeMap<Long, Equipment>();

	public boolean store(Equipment e) {
		if (!(e instanceof Storable)) {
			System.out.println("Item did not fit!");
            return false;
        }
		
		totalStored++;
		allItems.put(e.getId(), e);
		
		System.out.println("Item successfully deposited!");
		return true;
	}
	
	public List<Long> getAllKeys() {
		return new ArrayList<Long>(allItems.keySet());
	}
	
	public List<Equipment> getAllEquipments() {
		return new ArrayList<Equipment>(allItems.values());
	}
	
	public Equipment getStoredItem(long key) {
		return allItems.get(key);
	}
}
