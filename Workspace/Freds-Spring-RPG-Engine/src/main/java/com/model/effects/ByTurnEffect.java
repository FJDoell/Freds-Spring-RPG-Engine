package com.model.effects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class ByTurnEffect extends Effect {
	@Column(name="by_turn_interval")
	private int turnInterval = 1;
	@Column(name="execute_times")
	private int executeTimes = 1;
	@Column(name="max_stacks")
	private int maxStacks = 1;
	
	@Transient
	private int turnCounter = 0;
	
	@Transient
	private int stacks = 0;
}
