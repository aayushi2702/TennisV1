package com.tennis.game.service;

public class TennisGameService {

	private int playerOneScore;
	private int playerTwoScore;
	static final String SCORE_LOVE_ALL = "Love All";
	static final String SCORE_FIFTEEN_ALL = "Fifteen All";
	static final String SCORE_THIRTY_ALL = "Thirty All";
	private static final String SCORE_DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage";
	private static final String GAME = "Game";
	private static final String SCORE_LOVE_FIFTEEN = "Love Fifteen";
	private final String playerOne;
	private final String playerTwo;

	public TennisGameService(String playerOne, String playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public String getGameScore() {
		if (playerOneScore == playerTwoScore) {
			if (playerOneScore == 0) {
				return SCORE_LOVE_ALL;
			} else if (playerOneScore == 1) {
				return SCORE_FIFTEEN_ALL;
			} else if (playerOneScore == 2) {
				return SCORE_THIRTY_ALL;
			} else {
				return SCORE_DEUCE;
			}
		} else {
			if (Math.max(playerTwoScore, playerOneScore)>3) {
				if (pointDifferenceIsOne(playerOneScore, playerTwoScore)) {
					return ADVANTAGE + " " + getHighScorerPlayerName(playerOneScore, playerOneScore);
				} else {
					return GAME + " " + getHighScorerPlayerName(playerOneScore, playerOneScore);
				}
			}else {
				return SCORE_LOVE_FIFTEEN;
			}
		}
	}

	public void playerOneScored() {
		playerOneScore++;
	}

	public void playerTwoScored() {
		playerTwoScore++;
	}

	private boolean pointDifferenceIsOne(int playerOneScore, int playerTwoScore) {
		return Math.abs(playerOneScore - playerTwoScore) == 1;
	}
	
	private String getHighScorerPlayerName(int playerOneScore2, int playerOneScore3) {
		return playerOneScore > playerTwoScore ? playerOne : playerTwo;
	}
}
