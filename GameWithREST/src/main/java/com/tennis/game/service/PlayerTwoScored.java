package com.tennis.game.service;

import org.springframework.stereotype.Service;

@Service
public class PlayerTwoScored {
	private int playerTwoScore;

	public void playerTwoScored() {
		playerTwoScore++;
	}

	public int getPlayerTwoScored() {
		return playerTwoScore;
	}

	public void setScoreForPlayerTwo(String playerTwoScore) {
		this.playerTwoScore=0;
		boolean isNumeric = true;
		try {
			Integer.parseInt(playerTwoScore);
		} catch (Exception ex) {
			isNumeric = false;
		}
		if (isNumeric) {
			for (int i = 0; i < Integer.parseInt(playerTwoScore); i++) {
				playerTwoScored();
			}
		}else {
			throw new RuntimeException("Please enter Number for PlayerTwo");
		}
	}
}
