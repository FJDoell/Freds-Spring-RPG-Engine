package com.encounter.stage;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.action.Action;
import com.encounter.Encounter;

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
@Table(name = "stages")
public class Stage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "randomized")
	boolean randomized = true;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_encounter_id")
	List<Encounter> encounters;

	// Next stage is what stage is next in the sequence.
	// Between stages the player may save their game.
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_next_stage_id")
	Action nextStage;
}
