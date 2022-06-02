package com.model.builders.stats;

import org.springframework.stereotype.Component;

import com.model.stats.MultStats;

/**
 * Builder for stat multipliers.
 * Defaults to 1.0 for all multipliers of stats.
 * Useful for characters.
 * @author darkm
 *
 */
@Component
public class BaseMultStatBuilder {
	double hp = 1.0;
	double mp = 1.0;
	double atk = 1.0;
	double def = 1.0;
	double baseInt = 1.0;
	double wis = 1.0;
	double spd = 1.0;

	BaseMultStatBuilder() {
	}

	public BaseMultStatBuilder withHp(int hp) {
		this.hp = hp;
		return this;
	}

	public BaseMultStatBuilder withMp(int mp) {
		this.mp = mp;
		return this;
	}

	public BaseMultStatBuilder withAtk(int atk) {
		this.atk = atk;
		return this;
	}

	public BaseMultStatBuilder withDef(int def) {
		this.def = def;
		return this;
	}

	public BaseMultStatBuilder withBaseInt(int baseInt) {
		this.baseInt = baseInt;
		return this;
	}

	public BaseMultStatBuilder withWis(int wis) {
		this.wis = wis;
		return this;
	}

	public BaseMultStatBuilder withSpd(int spd) {
		this.spd = spd;
		return this;
	}
	
	public MultStats build() {
		return new MultStats(
				this.hp,
				this.mp,
				this.atk,
				this.def,
				this.baseInt,
				this.wis,
				this.spd);
	}

}
