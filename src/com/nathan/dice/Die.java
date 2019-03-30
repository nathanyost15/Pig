package com.nathan.dice;

import java.util.Random;

public class Die {
	private static final Random random = new Random();	
	private final int SIDES;
	private final int MININUM_ROLL = 1 ;
	
	public Die(int sides) {
		this.SIDES = sides;
	}
	
	public int getRoll() {
		return random.nextInt(SIDES) + MININUM_ROLL;
	}
}
