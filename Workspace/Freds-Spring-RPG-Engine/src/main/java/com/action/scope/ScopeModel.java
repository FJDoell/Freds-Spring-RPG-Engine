package com.action.scope;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import com.action.skill.SkillModifier;
import com.action.skill.SkillTargetGroup;
import com.character.Restrictions;

import lombok.Data;

/**
 * Contains data related to scoping and target handling.
 * 
 * @author darkm
 *
 */
@Entity
@Data
public class ScopeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	// Who can be selected by this skill?
	@Enumerated(EnumType.ORDINAL)
	SkillTargetGroup targetGroup;

	// What restrictions make this target invalid? (Or make this action fail?)
	@ElementCollection(targetClass = Restrictions.class)
	@JoinTable(name = "skill_restrictions", joinColumns = @JoinColumn(name = "restrict_id"))
	@Column(name = "skill_restrictions", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	Set<Restrictions> invalidTargetRestrictions;

	// Who among this group is targeted?
	@Enumerated(EnumType.ORDINAL)
	SkillModifier groupModifier;
}
