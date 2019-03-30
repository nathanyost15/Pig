package com.nathan.action;

import com.nathan.player.Player;

public class ResolveTurnActionImpl implements TurnAction {
	
	@Override
	public void doAction(Player currentPlayer, int rollAmount) {
		int turnTotalScore = currentPlayer.getTurnTotal();
		turnTotalScore += rollAmount;
		currentPlayer.setTurnTotal(turnTotalScore);
	}
}
