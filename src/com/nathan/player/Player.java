package com.nathan.player;

import java.util.Arrays;
import java.util.Optional;

import com.nathan.util.Die;

public class Player {
	private static final Die die = new Die(6);
	private static final int WIN_VALUE = 100;	
	private int score;
	private int turnTotal;
	private int lastRoll;
	
	public Player() {
		score = 0;
		turnTotal = 0;
		lastRoll = 0;
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
	
	public int getRoll() {
		lastRoll = die.getRoll();
		return lastRoll;
	}
	
	public static Optional<Player> getWinner(Player player1, Player player2) {
		return Arrays.asList(player1, player2).stream()
				.filter(player -> player.getScore() >= WIN_VALUE)
				.findFirst();		
	}

	public int getLastRoll() {
		return lastRoll;
	}
}