package com.nathan.action;

import com.nathan.player.Player;

public class LoseTurnTotalActionImpl implements TurnAction {

	@Override
	public void doAction(Player currentPlayer, int rollAmount) {		
		currentPlayer.setTurnTotal(0);
	}
}
