package com.model.character;

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
@Table(name = "monsters")
/**
 * An AI-controlled enemy.
 * @author darkm
 *
 */
public class Monster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_character_id")
	CharacterModel characterBase;
}
