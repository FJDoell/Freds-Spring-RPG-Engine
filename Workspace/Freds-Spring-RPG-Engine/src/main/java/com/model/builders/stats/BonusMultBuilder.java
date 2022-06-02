package com.model.builders.stats;

import com.model.stats.MultStats;

/**
 * Builder for stat multipliers.
 * Defaults to 0.0 for all multipliers of stats.
 * @author darkm
 *
 */
public class BonusMultBuilder {
	double hp = 0.0;
	double mp = 0.0;
	double atk = 0.0;
	double def = 0.0;
	double baseInt = 0.0;
	double wis = 0.0;
	double spd = 0.0;

	BonusMultBuilder() {
	}

	public BonusMultBuilder withHp(int hp) {
		this.hp = hp;
		return this;
	}

	public BonusMultBuilder withMp(int mp) {
		this.mp = mp;
		return this;
	}

	public BonusMultBuilder withAtk(int atk) {
		this.atk = atk;
		return this;
	}

	public BonusMultBuilder withDef(int def) {
		this.def = def;
		return this;
	}

	public BonusMultBuilder withBaseInt(int baseInt) {
		this.baseInt = baseInt;
		return this;
	}

	public BonusMultBuilder withWis(int wis) {
		this.wis = wis;
		return this;
	}

	public BonusMultBuilder withSpd(int spd) {
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
