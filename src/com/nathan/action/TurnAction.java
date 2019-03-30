package com.nathan.action;

import com.nathan.player.Player;

public interface TurnAction {
	void doAction(Player currentPlayer, int rollAmmount);
}
