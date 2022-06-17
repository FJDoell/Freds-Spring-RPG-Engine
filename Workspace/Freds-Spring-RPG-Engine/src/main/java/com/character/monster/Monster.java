package com.character.monster;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.character.CharacterModel;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@Data
@EqualsAndHashCode(callSuper=false)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "monsters")
/**
 * An AI-controlled enemy.
 * @author darkm
 *
 */
public class Monster extends CharacterModel {
}
