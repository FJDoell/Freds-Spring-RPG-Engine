package com.character.mods.equipment;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.effects.byTurn.ByTurnEffect;
import com.stats.flat.BaseStats;
import com.stats.mult.MultStats;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class EquipmentBuilder {
	String equipName = "";
	EquipType equipType;
	BaseStats baseStats;
	MultStats multStats;
	Set<ByTurnEffect> byTurnEffects;
	
	public EquipmentBuilder withName(String name) {
		this.equipName = name;
		return this;
	}
	
	public EquipmentBuilder withEquipType(EquipType equipType) {
		this.equipType = equipType;
		return this;
	}
	
	public EquipmentBuilder withBaseStats(BaseStats baseStats) {
		this.baseStats = baseStats;
		return this;
	}
	
	public EquipmentBuilder withMultStats(MultStats multStats) {
		this.multStats = multStats;
		return this;
	}
	
	public Equipment build() {
		return new Equipment(this.equipName,
				this.equipType,
				this.baseStats,
				this.multStats,
				this.byTurnEffects
				);
	}
}
