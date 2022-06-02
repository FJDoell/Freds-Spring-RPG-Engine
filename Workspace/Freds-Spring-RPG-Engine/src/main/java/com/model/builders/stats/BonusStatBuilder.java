package com.model.builders.stats;

import org.springframework.stereotype.Component;

import com.model.stats.BaseStats;

/**
 * Builder for base stats.
 * Defaults to 0 for all stats.
 * Useful for equipment.
 * @author darkm
 *
 */
@Component
public class BonusStatBuilder {
	int hp = 0;
	int mp = 0;
	int atk = 0;
	int def = 0;
	int baseInt = 0;
	int wis = 0;
	int spd = 0;
	
	BonusStatBuilder() { }
	
	public BonusStatBuilder withHp(int hp) {
		this.hp = hp;
		return this;
	}
	
	public BonusStatBuilder withMp(int mp) {
		this.mp = mp;
		return this;
	}
	
	public BonusStatBuilder withAtk(int atk) {
		this.atk = atk;
		return this;
	}
	
	public BonusStatBuilder withDef(int def) {
		this.def = def;
		return this;
	}
	
	public BonusStatBuilder withBaseInt(int baseInt) {
		this.baseInt = baseInt;
		return this;
	}
	
	public BonusStatBuilder withWis(int wis) {
		this.wis = wis;
		return this;
	}
	
	public BonusStatBuilder withSpd(int spd) {
		this.spd = spd;
		return this;
	}
	
	public BaseStats build() {
		return new BaseStats(
				this.hp,
				this.mp,
				this.atk,
				this.def,
				this.baseInt,
				this.wis,
				this.spd);
	}
}
