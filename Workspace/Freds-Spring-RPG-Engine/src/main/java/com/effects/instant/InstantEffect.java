package com.effects.instant;

import javax.persistence.Entity;

import com.effects.Effect;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
public class InstantEffect extends Effect {
}
