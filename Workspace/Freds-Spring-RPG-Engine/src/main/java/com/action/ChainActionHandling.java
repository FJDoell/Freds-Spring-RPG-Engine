package com.action;

/**
 * Should a chain end when one fails, or continue the rest of the chain
 * regardless?<br>
 * CONTINUE - If an action fails, the chain will continue.<br>
 * BREAK - If an action fails in a chain, it will NOT execute the next chain
 * skill, even if it would succeed.
 * 
 * @author darkm
 *
 */
public enum ChainActionHandling {
	CONTINUE, BREAK;
}
