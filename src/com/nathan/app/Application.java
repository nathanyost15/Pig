package com.nathan.app;

public class Application {
	private static final String DUMP_TOTAL_FMT = "Dumping turn total into score, your new score is %s!";
	private static final String SCORE_FMT = "Score is: %s\nTurnTotal is: %s";
	private static final String ROLL_FMT = "You rolled a: %s";
	
	public static void main(String[] args) {
		Pig pigGame = new Pig();
		pigGame.playGame();
	}	
}
