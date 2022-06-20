package com.party;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.global.GlobalSettingService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class TestPartyService {

	@Autowired
	PartyService serv;
	
	Party testParty;

	@Mock
	GlobalSettingService globalSettings;

	@BeforeAll
	void setup() {
		testParty = new Party();
		
		
		
		
	}

	@Test
	void test() {
	}
}
