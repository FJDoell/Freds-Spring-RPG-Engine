package com.effects.elements;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterModel;
import com.exceptions.MissingTypeException;
import com.global.GlobalSettingService;
import com.global.ResistanceStacking;

@Service
public class ElementService {

	@Autowired
	GlobalSettingService globalSets;

	public int checkAllElements(Set<ElementResistance> resistSet, int damage) {

		return damage;
	}

	public int elementCheck(int resistFlat, double resistMult, int damage) {
		damage = ((int) (damage * resistMult)) - resistFlat;
		if (damage <= 0) {

		}
		return damage;
	}

	public HashSet<ElementResistance> addResistances(Set<ElementResistance> set1, Set<ElementResistance> set2) throws MissingTypeException {
		HashSet<ElementResistance> allResists = new HashSet<ElementResistance>();
		if (set1.size() >= set2.size()) {
			// set 1 is bigger
			allResists = stackAll(set1, set2);
		} else {
			// set 2 is bigger
			allResists = stackAll(set2, set1);
		}
		return allResists;
	}
	
	public HashSet<ElementResistance> stackAll(Set<ElementResistance> larger, Set<ElementResistance> smaller) throws MissingTypeException {
		HashSet<ElementResistance> allResists = new HashSet<ElementResistance>();
		if (globalSets.getRESIST_STACK_STYLE().equals(ResistanceStacking.STACK_ADD)) {
			for (ElementResistance er : larger) {
				Elements erElem = er.getElement();
				for(ElementResistance er2 : smaller) {
					if(er2.getElement().equals(erElem)) {
						er = addResists(er, er2);
					}
				}
			}
		} else if (globalSets.getRESIST_STACK_STYLE().equals(ResistanceStacking.STACK_MULTIPLY)) {
			System.out.println("resist stacking is multiply; matching elements stack multiplictively.");
			for (ElementResistance er : larger) {
				Elements erElem = er.getElement();
				for(ElementResistance er2 : smaller) {
					if(er2.getElement().equals(erElem)) {
						er = multiplyResists(er, er2);
					}
				}
			}
		} else if (globalSets.getRESIST_STACK_STYLE().equals(ResistanceStacking.DO_NOT_STACK)) {
			System.out.println("resist stacking is none; adding highest resists of each element.");
			for (ElementResistance er : larger) {
				Elements erElem = er.getElement();
				for(ElementResistance er2 : smaller) {
					if(er2.getElement().equals(erElem)) {
						er = compareResistance(er, er2);
					}
				}
			}
		} else {
			throw new MissingTypeException("INVALID RESIST STACKING TYPE " + globalSets.getRESIST_STACK_STYLE() + ","
					+ "please define it in com.service.global.ResistanceStacking and handle it in ElementService.");
		}
		// Finally, append the result to a new set, which has the additions.
		allResists.addAll(larger);
		return allResists;
	}

	/**
	 * Multiplies two resists together, for example:
	 * Resist 1: 12, 1.2.
	 * Resist 2: 14, 1.8.
	 * Result: 26, 2.16
	 * @param resist1
	 * @param resist2
	 * @return
	 */
	public ElementResistance multiplyResists(ElementResistance resist1, ElementResistance resist2) {
		resist1.setResistFlat(resist1.getResistFlat() + resist2.getResistFlat());
		resist1.setResistMultiplier(resist1.getResistMultiplier() * resist2.getResistMultiplier());
		return resist1;
	}

	/**
	 * Adds two resists together. For example:
	 * Resist 1: 12, 1.2.
	 * Resist 2: 14, 1.8.
	 * Result: 26, 3.0.
	 * @param resist1
	 * @param resist2
	 * @return
	 */
	public ElementResistance addResists(ElementResistance resist1, ElementResistance resist2) {
		resist1.setResistFlat(resist1.getResistFlat() + resist2.getResistFlat());
		resist1.setResistMultiplier(resist1.getResistMultiplier() + resist2.getResistMultiplier());
		return resist1;
	}
	
	/**
	 * Compares two resistances, and returns one which has the highest flat and multiplied resistance
	 * between the two.
	 * @param resist1
	 * @param resist2
	 * @return
	 */
	public ElementResistance compareResistance(ElementResistance resist1, ElementResistance resist2) {
		if(resist2.getResistFlat() > resist1.getResistFlat()) {
			resist1.setResistFlat(resist2.getResistFlat());
		}
		if(resist2.getResistMultiplier() > resist1.getResistMultiplier()) {
			resist1.setResistMultiplier(resist2.getResistMultiplier());
		}
		return resist1;
	}

	/**
	 * gets total resistances for given character.
	 * @param c
	 * @return
	 * @throws MissingTypeException
	 */
	public HashSet<ElementResistance> getTotalResistances(CharacterModel c) throws MissingTypeException {
		HashSet<ElementResistance> resistTotal = new HashSet<ElementResistance>();
		resistTotal.addAll(addResistances(c.getBonusResistances(), c.getNatResistances()));
		return resistTotal;
	}
}
