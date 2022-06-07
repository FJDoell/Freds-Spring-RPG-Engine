package com.effects;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MappedSuperclass;

import com.effects.elements.Elements;

import lombok.Data;

@MappedSuperclass
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Effect {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;

	@Column(name="effectNum")
	private double effectNum = 0.0;

	@Column(name = "effect_name", length = 50, nullable = false, unique = true)
	private String name = "";
	
	@Enumerated(EnumType.ORDINAL)
	private EffectType applyEffect;
	
	@Enumerated(EnumType.ORDINAL)
	private EffectType removeEffect;
	
	// ELEMENT MOD
	@ElementCollection(targetClass = Elements.class)
	@JoinTable(name = "elements", joinColumns = @JoinColumn(name = "elementId"))
	@Column(name = "elements", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	Set<Elements> elements;

}
