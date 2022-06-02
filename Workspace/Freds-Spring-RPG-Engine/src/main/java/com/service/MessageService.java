package com.service;

import org.springframework.stereotype.Service;

/**
 * Handles all messages sent by actions, etc.
 * Pretty much universally used.
 * @author darkm
 *
 */
@Service
public class MessageService {
	
	public void takeActionMessage(String actionName, String userName, String targetName) {
		System.out.println(userName + " uses " + actionName + " on " + targetName);
	}
	
	public void cannotMoveMessage(String actionName, String userName) {
		System.out.println(userName + " can't move! Cancelled " + actionName + "!");
	}
	
	public void missMessage(String actionName, String userName, String targetName) {
		System.out.println(userName + " misses! (" + actionName + " on " + targetName + ")");
	}
	
	public void damageMessage(int damage, String targetName) {
		System.out.println(targetName + " takes " + damage + " damage!");
	}
	
	public void healMessage(int damage, String targetName) {
		System.out.println(targetName + " recovers " + damage + " HP!");
	}
	
	public void fullHp(String targetName) {
		System.out.println(targetName + " now has full HP!");
	}
	
	public void deathResist(String targetName) {
		System.out.println(targetName + " is barely hanging on!");
	}
	
	public void deathMessage(String targetName) {
		System.out.println(targetName + " is slain!");
	}
	
	public void reviveMessage(String targetName) {
		System.out.println(targetName + " is revived!");
	}
	
	public void noEffect(String targetName) {
		System.out.println("But it has no effect on " + targetName);
	}
	
	public void genericEndMessage(String message) {
		System.out.println("--------------" + message + "--------------");
	}
	
	public void endOfTurnMessage() {
		System.out.println("--------------END OF TURN--------------");
	}

}
