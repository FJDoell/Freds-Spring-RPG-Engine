package com.character.monster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.character.CharacterService;

@Service
public class MonsterService {

	@Autowired
	private CharacterService charServ;
}
