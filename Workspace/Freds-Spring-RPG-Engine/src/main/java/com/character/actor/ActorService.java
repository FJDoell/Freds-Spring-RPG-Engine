package com.character.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterService;

@Service
public class ActorService {

	@Autowired
	private CharacterService charServ;
}
