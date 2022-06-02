package com.model.character;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
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
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	// What total EXP do they have?
	@Column(name="actor_total_exp", nullable = false)
	double totalExp = 1.0;
	
	// What multiplier to apply to monster EXP when earned.
	@Column(name="actor_exp_rate", nullable = false)
	double expRate = 1.0;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_character_id")
	CharacterModel characterBase;
}
