package com.effects.elements;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Used to store a given element with a multiplier.
 * Can be associated with characters or equipment.
 * @author darkm
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "resistances")
public class ElementResistance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="element_resist_flat")
	private int resistFlat = 0;
	
	@Column(name="element_resist_mult")
	private double resistMultiplier = 1.0;
	
	@Enumerated(EnumType.ORDINAL)
	Elements element;
}
