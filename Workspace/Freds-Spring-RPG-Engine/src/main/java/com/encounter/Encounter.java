package com.encounter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.character.actor.Actor;
import com.character.monster.Monster;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


/**
 * Each "encounter" can be thought of as an event. They play out in the
 * following order:<br>
 * Description is displayed.<br>
 * Battle is executed with the contained monsters.<br>
 * Any party members provided join the reserve.<br>
 * 
 * @author darkm
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "encounters")
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "description")
	String description;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_monster_id")
	List<Monster> monsters;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_actor_id")
	List<Actor> actors;
}
