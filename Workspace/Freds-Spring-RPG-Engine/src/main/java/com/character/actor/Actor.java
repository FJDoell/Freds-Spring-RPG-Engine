package com.character.actor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.character.CharacterModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "actors")
/**
 * A player-controlled party member.
 * @author darkm
 *
 */
public class Actor extends CharacterModel {
	// What total EXP do they have?
	@Column(name="actor_total_exp", nullable = false)
	double totalExp = 1.0;
	
	// What multiplier to apply to monster EXP when earned.
	@Column(name="actor_exp_rate", nullable = false)
	double expRate = 1.0;
	
}
