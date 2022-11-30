package com.tennis.game.service;

public class TennisGameService {
	
	private int playerOneScore;
	private int playerTwoScore;
	static final String SCORE_LOVE_ALL = "Love All";
	static final String SCORE_FIFTEEN_ALL = "Fifteen All";
	public TennisGameService(String playerOne, String playerTwo) {

	}

	public String getGameScore() {
		if(playerOneScore == playerTwoScore) {
			if(playerOneScore == 0) {
				return SCORE_LOVE_ALL;
			}
			else if(playerOneScore == 1) {
				return SCORE_FIFTEEN_ALL;
			}
		}
		return SCORE_LOVE_ALL;
	}
	
	public void playerOneScored() {
		playerOneScore++;
	}

	public void playerTwoScored() {
		playerTwoScore++;
	}
}
