package com.tennis.game.service;

public class TennisGameService {
	
	private int playerOneScore;
	private int playerTwoScore;
	static final String SCORE_LOVE_ALL = "Love All";
	static final String SCORE_FIFTEEN_ALL = "Fifteen All";
	static final String SCORE_THIRTY_ALL = "Thirty All";
	private static final String SCORE_DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage";
	private final String playerOne;
	private final String playerTwo;
	public TennisGameService(String playerOne, String playerTwo) {
		this.playerOne=playerOne;
		this.playerTwo=playerTwo;
	}

	public String getGameScore() {
		if(playerOneScore == playerTwoScore) {
			if(playerOneScore == 0) {
				return SCORE_LOVE_ALL;
			}
			else if(playerOneScore == 1) {
				return SCORE_FIFTEEN_ALL;
			}
			else if(playerOneScore == 2) {
				return SCORE_THIRTY_ALL;
			}else {
				return SCORE_DEUCE;
			}
		}else {
			return ADVANTAGE + " "+ (playerOneScore > playerTwoScore ? playerOne : playerTwo) ;
		}
	}
	
	public void playerOneScored() {
		playerOneScore++;
	}

	public void playerTwoScored() {
		playerTwoScore++;
	}
}
