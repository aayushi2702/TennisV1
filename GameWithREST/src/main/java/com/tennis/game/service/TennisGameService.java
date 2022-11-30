package com.tennis.game.service;

import java.util.HashMap;
import java.util.Map;

public class TennisGameService {

	private int playerOneScore;
	private int playerTwoScore;
	private static final String SCORE_DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage";
	private static final String GAME = "Game";
	private static final String SCORE_LOVE = "Love";
	private static final String SCORE_FIFTEEN = "Fifteen";
	private static final String SCORE_THIRTY = "Thirty";
	private static final String SCORE_FORTY = "Forty";
	private static final String STRING_ALL = "All";
	private final String playerOne;
	private final String playerTwo;
	private static final Map<Integer, String> SCORE_MAP = new HashMap<>();

	static {
		SCORE_MAP.put(0, SCORE_LOVE);
		SCORE_MAP.put(1, SCORE_FIFTEEN);
		SCORE_MAP.put(2, SCORE_THIRTY);
		SCORE_MAP.put(3, SCORE_FORTY);
	}

	public TennisGameService(String playerOne, String playerTwo) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public String getGameScore() {
		if (playerOneScore == playerTwoScore) {
			return playerOneScore > 2 ? SCORE_DEUCE : getPlayerScore(playerOneScore) + " " + STRING_ALL;
		} else {
			if (Math.max(playerTwoScore, playerOneScore)>3) {
				return (pointDifferenceIsOne(playerOneScore, playerTwoScore) ? ADVANTAGE : GAME) + " " + getHighScorerPlayerName();
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
		return SCORE_MAP.get(playerScore);
	}
}
