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
	private static final String SCORE_LOVE = "Love";
	private static final String SCORE_FIFTEEN = "Fifteen";
	private static final String SCORE_THIRTY = "Thirty";
	private static final String SCORE_FORTY = "Forty";
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
					return ADVANTAGE + " " + getHighScorerPlayerName();
				} else {
					return GAME + " " + getHighScorerPlayerName();
				}
			}else {
				return getPlayerScore(playerOneScore) +" "+ getPlayerScore(playerTwoScore);
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
	
	private String getHighScorerPlayerName() {
		return playerOneScore > playerTwoScore ? playerOne : playerTwo;
	}
	
	private String getPlayerScore(int playerScore) {
		if(playerScore==0)
			return SCORE_LOVE;
		else if(playerScore==1)
			return SCORE_FIFTEEN;
		else if(playerScore==2)
			return SCORE_THIRTY;
		else
			return SCORE_FORTY;
	}
}
