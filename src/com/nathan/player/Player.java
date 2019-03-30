package com.nathan.player;

import com.nathan.dice.Die;

public class Player {
	private static final Die die = new Die(6);
	private static final int WIN_VALUE = 100;
	private int score;
	private int turnTotal;
	
	public Player() {
		score = 0;
		turnTotal = 0;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTurnTotal() {
		return turnTotal;
	}

	public void setTurnTotal(int turnTotal) {
		this.turnTotal = turnTotal;
	}
	
	public void addToTurnTotal(int ammount) {
		this.turnTotal += ammount;
	}
	
	public void dumpTotalScoreIntoScore() {
		setScore(getScore() + getTurnTotal());
		setTurnTotal(0);
	}
	
	public int takeTurn() {
		int dieRoll = die.getRoll();
		switch(dieRoll) {
			case 1:
				setTurnTotal(0);				
				break;
			default:
				addToTurnTotal(dieRoll);
		}
		return dieRoll;
	}
	
	public static Player getWinner(Player player1, Player player2) {
		return player1.getScore() >= WIN_VALUE ? player1 :  
			player2.getScore() >= WIN_VALUE ? player2 : null;
	}
}
