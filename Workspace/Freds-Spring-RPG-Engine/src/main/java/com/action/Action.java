package com.action;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.character.CharacterModel;
import com.effects.byTurn.ByTurnEffect;
import com.effects.instant.InstantEffect;

import lombok.Data;

@Data
@Entity
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "action_name", length = 50, nullable = false, unique = false)
	String name;
	@Column(name = "action_spd")
	int bonusSpd;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_instant_effect_id")
	Set<InstantEffect> instantEffects;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_by_turn_effect_id")
	Set<ByTurnEffect> byTurnEffects;
	
	@Transient
	CharacterModel actor;
	@Transient
	CharacterModel target;
	
	@Transient
	int totalSpd;
}
