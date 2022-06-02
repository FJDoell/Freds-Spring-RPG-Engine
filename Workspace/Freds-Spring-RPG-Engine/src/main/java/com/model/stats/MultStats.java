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
@Table(name = "multStats")
public class MultStats {
	// Unique identifier for this baseStat set
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name = "hp")
	double hp = 1.0;

	@Column(name = "mp")
	double mp = 1.0;

	@Column(name = "atk")
	double atk = 1.0;

	@Column(name = "def")
	double def = 1.0;

	@Column(name = "baseInt")
	double baseInt = 1.0;

	@Column(name = "wis")
	double wis = 1.0;

	@Column(name = "spd")
	double spd = 1.0;

	public MultStats(double hp, double mp, double atk, double def, double baseInt, double wis, double spd) {
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
