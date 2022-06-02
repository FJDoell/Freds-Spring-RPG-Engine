package com.model.builders.stats;

import org.springframework.stereotype.Component;

import com.model.stats.BaseStats;

/**
 * Builder for base stats.
 * Defaults to 1 for all stats.
 * Good for characters.
 * @author darkm
 *
 */
@Component
public class BaseStatBuilder {
	int hp = 1;
	int mp = 1;
	int atk = 1;
	int def = 1;
	int baseInt = 1;
	int wis = 1;
	int spd = 1;
	
	public BaseStatBuilder() { }
	
	public BaseStatBuilder withHp(int hp) {
		this.hp = hp;
		return this;
	}
	
	public BaseStatBuilder withMp(int mp) {
		this.mp = mp;
		return this;
	}
	
	public BaseStatBuilder withAtk(int atk) {
		this.atk = atk;
		return this;
	}
	
	public BaseStatBuilder withDef(int def) {
		this.def = def;
		return this;
	}
	
	public BaseStatBuilder withBaseInt(int baseInt) {
		this.baseInt = baseInt;
		return this;
	}
	
	public BaseStatBuilder withWis(int wis) {
		this.wis = wis;
		return this;
	}
	
	public BaseStatBuilder withSpd(int spd) {
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
