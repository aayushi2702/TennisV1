package com.tennis.game.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

@Service
public class TennisGameService {

	private static final String SCORE_DEUCE = "Deuce";
	private static final String ADVANTAGE = "Advantage";
	private static final String GAME = "Game";
	private static final String SCORE_LOVE = "Love";
	private static final String SCORE_FIFTEEN = "Fifteen";
	private static final String SCORE_THIRTY = "Thirty";
	private static final String SCORE_FORTY = "Forty";
	private static final String STRING_ALL = "All";
	private final String playerOne = "PlayerOneName";
	private final String playerTwo = "PlayerTwoName";
	private static final Map<Integer, String> SCORE_MAP = new HashMap<>();
	private static final Integer ONE = 1;
	private static final Integer TWO = 2;
	private static final Integer THREE = 3;
	private static final Integer ZERO = 0;

	static { 
		SCORE_MAP.put(ZERO, SCORE_LOVE);
		SCORE_MAP.put(ONE, SCORE_FIFTEEN);
		SCORE_MAP.put(TWO, SCORE_THIRTY);
		SCORE_MAP.put(THREE, SCORE_FORTY);
	}

//	public TennisGameService(String playerOne, String playerTwo) {
//		this.playerOne = playerOne;
//		this.playerTwo = playerTwo;
//	}

	public String getGameScore(Integer playerOneScored, Integer playerTwoScored) { 
		if (Objects.equals(playerOneScored, playerTwoScored)) {
			return playerOneScored > TWO ? SCORE_DEUCE : getPlayerScore(playerOneScored).concat(" ").concat(STRING_ALL);
		} else {
			if (Math.max(playerOneScored, playerTwoScored) > THREE) {
				return (pointDifferenceIsOne(playerOneScored, playerTwoScored) ? ADVANTAGE : GAME).concat(" ")
						.concat(getHighScorerPlayerName(playerOneScored, playerTwoScored));
			} else {
				return getPlayerScore(playerOneScored).concat(" ").concat(getPlayerScore(playerTwoScored));
			}
		}
	}

	private boolean pointDifferenceIsOne(Integer playerOneScore, Integer playerTwoScore) {
		return Math.abs(playerOneScore - playerTwoScore) == ONE;
	}

	private String getHighScorerPlayerName(Integer playerOneScore, Integer playerTwoScore) {
		return playerOneScore > playerTwoScore ? playerOne : playerTwo;
	}

	private String getPlayerScore(Integer playerScore) {
		return SCORE_MAP.get(playerScore);
	}
}
