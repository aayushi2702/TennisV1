package com.tennis.game.service;

public class TennisGameService {
	
	private int playerOneScore;
	private int playerTwoScore;
	static final String SCORE_LOVE_ALL = "Love All";
	public TennisGameService(String playerOne, String playerTwo) {

	}

	public String getGameScore() {
		return SCORE_LOVE_ALL;
	}
	
	public void playerOneScored() {
		playerOneScore++;
	}

	public void playerTwoScored() {
		playerTwoScore++;
	}
}
