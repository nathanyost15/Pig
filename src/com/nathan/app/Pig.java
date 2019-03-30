package com.nathan.app;

import java.util.Scanner;

import com.nathan.player.Player;

public class Pig {
	private static final Player human = new Player();
	private static final Player computer = new Player();
	private static final Player currentPlayer = human;
	
	public Pig() {		
	}
	
	public void playGame() {	
		
	}

	public void playNextRound() {	
		
		
		boolean gameRunning = true;
		while(gameRunning) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Would you like to roll? ");
			String sc_answer = scan.nextLine();
			if(sc_answer.equalsIgnoreCase("yes")) {
				int dieRoll = currentPlayer.takeTurn();
				System.out.println(String.format(ROLL_FMT, dieRoll));
				System.out.println(String.format(SCORE_FMT, currentPlayer.getScore(), currentPlayer.getTurnTotal()));
				if(dieRoll == 1) {
					currentPlayer = currentPlayer == human ? computer : human;
					System.out.println("Switching players!");
				}
			} else {
				currentPlayer.dumpTotalScoreIntoScore();
				System.out.println(String.format(DUMP_TOTAL_FMT, currentPlayer.getScore()));
				currentPlayer = currentPlayer == human ? computer : human;
			}
		}
	}
}
