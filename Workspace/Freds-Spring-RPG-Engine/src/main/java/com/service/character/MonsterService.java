package com.service.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonsterService {

	@Autowired
	private CharacterService charServ;
}
