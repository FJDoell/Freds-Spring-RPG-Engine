package com.character;

import java.util.HashMap;
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

import com.character.mods.CharacterMods;
import com.effects.byTurn.ByTurnEffect;
import com.effects.elements.ElementResistance;
import com.effects.instant.InstantEffect;
import com.stats.flat.BaseStatBuilder;
import com.stats.flat.BaseStats;
import com.stats.mult.MultStats;

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

	// Mods
	HashMap<String, CharacterMods> mods;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_resistance_id")
	Set<ElementResistance> natResistances;

	@Transient
	Set<ByTurnEffect> byTurnEffects;
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

	public CharacterModel(String name, int level, double expPerLevel, BaseStats baseStats, MultStats multStats,
			Set<ElementResistance> resistances) {
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

	////////////////////////////////
	// Calculate the totals of STATS
	////////////////////////////////
	/**
	 * Given a character, return a BaseStats object containing the totals of all
	 * their bonuses added together.
	 * 
	 * @param this
	 * @return
	 */
	public BaseStats getTotalStats() {
		BaseStats totalStats = new BaseStatBuilder().withHp(getTotalHp()).withMp(getTotalMp())
				.withAtk(getTotalAtk()).withDef(getTotalDef()).withBaseInt(getTotalIntelligence())
				.withWis(getTotalWis()).withSpd(getTotalSpd()).build();
		return totalStats;
	}

	public int getTotalHp() {
		int baseTotal = this.getBaseStats().getHp() + this.getBonusStats().getHp();
		double multTotal = this.getBaseMultStats().getHp() + this.getBonusMultStats().getHp();
		return (int) (baseTotal * multTotal);
	}

	public int getTotalMp() {
		int baseTotal = this.getBaseStats().getMp() + this.getBonusStats().getMp();
		double multTotal = this.getBaseMultStats().getMp() + this.getBonusMultStats().getMp();
		return (int) (baseTotal * multTotal);
	}

	public int getTotalAtk() {
		int baseTotal = this.getBaseStats().getAtk() + this.getBonusStats().getAtk();
		double multTotal = this.getBaseMultStats().getAtk() + this.getBonusMultStats().getAtk();
		return (int) (baseTotal * multTotal);
	}

	public int getTotalDef() {
		int baseTotal = this.getBaseStats().getDef() + this.getBonusStats().getDef();
		double multTotal = this.getBaseMultStats().getDef() + this.getBonusMultStats().getDef();
		return (int) (baseTotal * multTotal);
	}

	public int getTotalIntelligence() {
		int baseTotal = this.getBaseStats().getBaseInt() + this.getBonusStats().getBaseInt();
		double multTotal = this.getBaseMultStats().getBaseInt() + this.getBonusMultStats().getBaseInt();
		return (int) (baseTotal * multTotal);
	}

	public int getTotalWis() {
		int baseTotal = this.getBaseStats().getWis() + this.getBonusStats().getWis();
		double multTotal = this.getBaseMultStats().getWis() + this.getBonusMultStats().getWis();
		return (int) (baseTotal * multTotal);
	}

	public int getTotalSpd() {
		int baseTotal = this.getBaseStats().getSpd() + this.getBonusStats().getSpd();
		double multTotal = this.getBaseMultStats().getSpd() + this.getBonusMultStats().getSpd();
		return (int) (baseTotal * multTotal);
	}

}
