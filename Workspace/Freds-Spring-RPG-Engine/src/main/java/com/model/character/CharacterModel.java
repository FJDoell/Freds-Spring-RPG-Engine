package com.model.character;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.model.Restrictions;
import com.model.effects.ByTurnEffect;
import com.model.effects.InstantEffect;
import com.model.effects.resists.ElementResistance;
import com.model.equip.Equipment;
import com.model.stats.BaseStats;
import com.model.stats.MultStats;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "characters")
/**
 * Contains the minimal data needed for a battler. Used as the basis for enemies
 * and allies alike.
 * 
 * @author darkm
 *
 */
public class CharacterModel {
	// Unique identifier for this character
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@Column(name = "character_name", length = 50, nullable = false, unique = false)
	String name;

	// Level of this character, the base stat is multiplied by this
	@Column(name = "character_level", nullable = false, unique = false)
	int level;

	// Base EXP required per level, also the EXP earned per level
	@Column(name = "character_exp_per_level", nullable = false, unique = false)
	double expPerLevel;

	// Base stats
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_baseStats_id")
	BaseStats baseStats;

	// Mult stats
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_multStat_id")
	MultStats baseMultStats;

	// Equipment
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_equipSet_id")
	Set<Equipment> equipment;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_resistance_id")
	Set<ElementResistance> natResistances;
	
	@Transient
	Set<ByTurnEffect> byTurnEffects;
	@Transient
	Set<InstantEffect> instantEffects;
	@Transient
	Set<Restrictions> restrictions;
	// Bonus stats
	@Transient
	BaseStats bonusStats;
	@Transient
	MultStats bonusMultStats;
	@Transient
	Set<ElementResistance> bonusResistances;
	// HP: Health of this character.
	@Transient
	int hp;
	@Transient
	int maxHp;
	// MP: Resource for skill usage, regenerates over time
	@Transient
	int mp;
	@Transient
	int maxMp;

	public CharacterModel(String name, int level, double expPerLevel, BaseStats baseStats,
			MultStats multStats, Set<ElementResistance> resistances) {
		super();
		this.name = name;
		this.level = level;
		this.expPerLevel = expPerLevel;
		this.baseStats = baseStats;
		this.baseMultStats = multStats;
		this.maxHp = baseStats.getHp();
		this.maxMp = baseStats.getMp();
		this.natResistances = resistances;
	}

}
