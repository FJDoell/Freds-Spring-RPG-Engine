package com.model.stats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "baseStats")
public class BaseStats {
	// Unique identifier for this baseStat set
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	long id;
	
	@Column(name = "hp")
	int hp = 0;
	
	@Column(name = "mp")
	int mp = 0;
	
	@Column(name = "atk")
	int atk = 0;
	
	@Column(name = "def")
	int def = 0;
	
	@Column(name = "baseInt")
	int baseInt = 0;
	
	@Column(name = "wis")
	int wis = 0;
	
	@Column(name = "spd")
	int spd = 0;

	public BaseStats(int hp, int mp, int atk, int def, int baseInt, int wis, int spd) {
		super();
		this.hp = hp;
		this.mp = mp;
		this.atk = atk;
		this.def = def;
		this.baseInt = baseInt;
		this.wis = wis;
		this.spd = spd;
	}
}
