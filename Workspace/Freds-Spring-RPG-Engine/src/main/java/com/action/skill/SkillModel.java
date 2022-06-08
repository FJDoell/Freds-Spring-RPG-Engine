package com.action.skill;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.action.Action;
import com.action.scope.ScopeModel;
import com.character.CharacterModel;

import lombok.Data;

@Entity
@Data
/**
 * A given skill is assigned to a character with a level when it is usable.
 * Skills also include targeting criteria and selection criteria.
 * @author darkm
 *
 */
public class SkillModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	// What level is this learned?
	@Column(name = "skill_level")
	int levelRequired;
	
	// What does this DO?
	@OneToOne(fetch = FetchType.EAGER)
	Action skillAction;
	
	// Who uses this?
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_character_id")
	CharacterModel character;
	
	// SCOPE
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_scope_id")
	ScopeModel skillScope;
	
}
