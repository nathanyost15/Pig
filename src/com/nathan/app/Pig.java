package com.nathan.app;

import java.util.Optional;
import java.util.Scanner;

import com.nathan.action.LoseTurnTotalActionImpl;
import com.nathan.action.ResolveTurnActionImpl;
import com.nathan.action.TurnAction;
import com.nathan.player.Player;

public class Pig {
	private static final String SWITCHING_PLAYERS = "Switching players!";
	private static final String DUMP_TOTAL_FMT = "Dumping turn total into score, your new score is %s!";
	private static final String SCORE_FMT = "Score is: %s\nTurnTotal is: %s";
	private static final String ROLL_FMT = "You rolled a: %s";
	private final Scanner scan = new Scanner(System.in);
	private final Player human = new Player();
	private final Player computer = new Player();
	private Player currentPlayer = human;
	private boolean gameRunning;
	
	public Pig() {
		gameRunning = true;
	}
	
	public void playGame() {			
		while(gameRunning) {			
			System.out.print("Would you like to roll? ");
			String answer = scan.nextLine();
			if(answer.equalsIgnoreCase("yes")) {
				takeTurn();
			} else {
				endTurn();
			}
		}		
	}

	private void endTurn() {
		currentPlayer.dumpTotalScoreIntoScore();
		System.out.println(String.format(DUMP_TOTAL_FMT, currentPlayer.getScore()));
		swapTurns();
	}

	private void takeTurn() {
		playNextRound();
		displayScore();
		checkWinnerIsFound();
		if(currentPlayer.getLastRoll() == 1) {
			swapTurns();
			System.out.println(SWITCHING_PLAYERS);
		}
	}

	private void checkWinnerIsFound() {
		Optional<Player> winner = Optional.ofNullable(Player.getWinner(human, computer));
		if(winner.isPresent()) {
			System.out.println("Winner has been found!");
			gameRunning = false;
		}
	}

	private void displayScore() {
		int dieRoll = currentPlayer.getLastRoll();
		System.out.println(String.format(ROLL_FMT, dieRoll));
		System.out.println(String.format(SCORE_FMT, currentPlayer.getScore(), currentPlayer.getTurnTotal()));
	}

	public void playNextRound() {	
		int rollAmount = currentPlayer.getRoll();
		TurnAction turnAction = getTurnAction(rollAmount);	
		turnAction.doAction(currentPlayer, rollAmount);
	}

	private void swapTurns() {
		currentPlayer = currentPlayer == human ? computer : human;
	}

	private TurnAction getTurnAction(int rollAmount) {
		TurnAction action = null;
		if(rollAmount == 1) {		
			action = new LoseTurnTotalActionImpl();				
		} else {
				action = new ResolveTurnActionImpl();
		}
		return action;
	}
}
