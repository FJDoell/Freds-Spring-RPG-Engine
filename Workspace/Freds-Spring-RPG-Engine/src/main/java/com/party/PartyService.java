package com.party;

import org.springframework.stereotype.Service;

import com.character.actor.Actor;

import lombok.Data;

@Service
@Data
public class PartyService {
	
	private Party currentParty = new Party();
	
	public Party addActor(Actor a) {
		
		
		
		return currentParty;
	}

}
