package com.action;

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
import javax.persistence.Transient;

import com.action.scope.ScopeModel;
import com.character.CharacterModel;
import com.effects.byTurn.ByTurnEffect;
import com.effects.instant.InstantEffect;

import lombok.Data;

@Data
@Entity
/**
 * @author darkm
 *
 */
public class Action {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "action_name", length = 50, nullable = false, unique = false)
	String name;
	@Column(name = "action_spd")
	int bonusSpd;
	@Column(name = "action_repeat")
	int repeat;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_instant_effect_id")
	Set<InstantEffect> instantEffects;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_by_turn_effect_id")
	Set<ByTurnEffect> byTurnEffects;

	// A chain action is IMMEDIATELY executed after a previous action, with the same user.
	// The target is decided by the chain skill depending on what the target type is.
	// Never, ever chain an action with itself. It will infinitely loop. Use repeat instead.
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_chain_action_id")
	Action chainAction;
	
	@Enumerated(EnumType.ORDINAL)
	ChainActionHandling chainHandle;

	// SCOPE
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_scope_id")
	ScopeModel actionScope;

	@Transient
	CharacterModel actor;
	@Transient
	CharacterModel target;

	@Transient
	int totalSpd;

}
