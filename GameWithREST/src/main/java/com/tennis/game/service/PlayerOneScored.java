package com.tennis.game.service;

import org.springframework.stereotype.Component;

@Component
public class PlayerOneScored {

	private int playerOneScore;

	public void playerOneScored() {
		playerOneScore++;
	}

	public int getPlayerOneScored() {
		return playerOneScore;
	}

	public void setScoreForPlayerOne(String playerOneScore) {
		boolean isNumeric = true;
		try {
			Integer.parseInt(playerOneScore);
		} catch (Exception ex) {
			isNumeric = false;
		}
		if (isNumeric) {
			for (Integer i = 0; i < Integer.parseInt(playerOneScore); i++) {
				playerOneScored();
			}
		}else {
			throw new RuntimeException("Please enter Number for PlayerOne");
		}

	}

}
