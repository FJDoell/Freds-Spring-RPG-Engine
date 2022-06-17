package com.character.mods.equipment;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.effects.byTurn.ByTurnEffect;
import com.effects.elements.ElementResistance;
import com.stats.flat.BaseStats;
import com.stats.mult.MultStats;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A model for equipment.
 * @author darkm
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name="equipment")
public class Equipment {
	// Unique identifier for this equipment
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "equipment_name", length = 50, nullable = false, unique = false)
	String equipName;

	@Enumerated(EnumType.ORDINAL)
	EquipType equipType;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_baseStats_id")
	BaseStats baseStats;

	// Mult stats
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_multStat_id")
	MultStats multStats;

	// By Turn Effects
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_byTurn_id")
	Set<ByTurnEffect> byTurnEffects;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_resistance_id")
	Set<ElementResistance> resistances;

	public Equipment(String equipName, EquipType equipType, BaseStats baseStats,
			MultStats multStats, Set<ByTurnEffect> byTurnEffects) {
		super();
		this.equipName = equipName;
		this.equipType = equipType;
		this.baseStats = baseStats;
		this.multStats = multStats;
		this.byTurnEffects = byTurnEffects;
	}
	
}
