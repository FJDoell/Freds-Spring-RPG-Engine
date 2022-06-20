package com.party;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.character.actor.Actor;

import lombok.Data;

@Data
@Entity
public class Party {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_actor_active_id")
	List<Actor> active;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_actor_reserve_id")
	List<Actor> reserve;
	
	public Party() {
		this.id = 0;
		this.active = new ArrayList<Actor>();
		this.reserve = new ArrayList<Actor>();
	}

	public Party(List<Actor> active, List<Actor> reserve) {
		super();
		this.active = active;
		this.reserve = reserve;
	}
	
}
