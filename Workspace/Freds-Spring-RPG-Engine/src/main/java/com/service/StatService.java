package com.service;

import com.model.stats.BaseStats;
import com.model.stats.MultStats;

/**
 * Handles adding and removing stat bonuses.
 * @author darkm
 *
 */
public class StatService {
	
	/**
	 * Add two base stats together and return the altered base stat.
	 * @param base
	 * @param add
	 * @return
	 */
	public BaseStats addFlatStats(BaseStats base, BaseStats add) {
		if (add.getHp() >= 1) {
			base.setHp(base.getHp() + add.getHp());
		}
		if (add.getMp() >= 1) {
			base.setMp(base.getMp() + add.getMp());
		}
		if (add.getAtk() >= 1) {
			base.setAtk(base.getAtk() + add.getAtk());
		}
		if (add.getDef() >= 1) {
			base.setDef(base.getDef() + add.getDef());
		}
		if (add.getBaseInt() >= 1) {
			base.setBaseInt(base.getBaseInt() + add.getBaseInt());
		}
		if (add.getWis() >= 1) {
			base.setWis(base.getWis() + add.getWis());
		}
		if (add.getSpd() >= 1) {
			base.setSpd(base.getSpd() + add.getSpd());
		}
		return base;
	}
	
	/**
	 * Subtract one base stat from another and return the result.
	 * @param base
	 * @param subtract
	 * @return
	 */
	public BaseStats subtractFlatStats(BaseStats base, BaseStats subtract) {
		if (subtract.getHp() >= 1) {
			base.setHp(base.getHp() - subtract.getHp());
		}
		if (subtract.getMp() >= 1) {
			base.setMp(base.getMp() - subtract.getMp());
		}
		if (subtract.getAtk() >= 1) {
			base.setAtk(base.getAtk() - subtract.getAtk());
		}
		if (subtract.getDef() >= 1) {
			base.setDef(base.getDef() - subtract.getDef());
		}
		if (subtract.getBaseInt() >= 1) {
			base.setBaseInt(base.getBaseInt() - subtract.getBaseInt());
		}
		if (subtract.getWis() >= 1) {
			base.setWis(base.getWis() - subtract.getWis());
		}
		if (subtract.getSpd() >= 1) {
			base.setSpd(base.getSpd() - subtract.getSpd());
		}
		return base;
	}
	
	/**
	 * Add two multiply stats together and return the result.
	 * @param base
	 * @param add
	 * @return
	 */
	public MultStats addMultStats(MultStats base, MultStats add) {
		if (add.getHp() >= 1) {
			base.setHp(base.getHp() + add.getHp());
		}
		if (add.getMp() >= 1) {
			base.setMp(base.getMp() + add.getMp());
		}
		if (add.getAtk() >= 1) {
			base.setAtk(base.getAtk() + add.getAtk());
		}
		if (add.getDef() >= 1) {
			base.setDef(base.getDef() + add.getDef());
		}
		if (add.getBaseInt() >= 1) {
			base.setBaseInt(base.getBaseInt() + add.getBaseInt());
		}
		if (add.getWis() >= 1) {
			base.setWis(base.getWis() + add.getWis());
		}
		if (add.getSpd() >= 1) {
			base.setSpd(base.getSpd() + add.getSpd());
		}
		return base;
	}
	
	/**
	 * Subtract one multiply stat from another and return the result.
	 * @param base
	 * @param subtract
	 * @return
	 */
	public MultStats subtractMultStats(MultStats base, MultStats subtract) {
		if (subtract.getHp() >= 1) {
			base.setHp(base.getHp() - subtract.getHp());
		}
		if (subtract.getMp() >= 1) {
			base.setMp(base.getMp() - subtract.getMp());
		}
		if (subtract.getAtk() >= 1) {
			base.setAtk(base.getAtk() - subtract.getAtk());
		}
		if (subtract.getDef() >= 1) {
			base.setDef(base.getDef() - subtract.getDef());
		}
		if (subtract.getBaseInt() >= 1) {
			base.setBaseInt(base.getBaseInt() - subtract.getBaseInt());
		}
		if (subtract.getWis() >= 1) {
			base.setWis(base.getWis() - subtract.getWis());
		}
		if (subtract.getSpd() >= 1) {
			base.setSpd(base.getSpd() - subtract.getSpd());
		}
		return base;
	}
	
	
}
