package com.tennis.gametest.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.tennis.game.service.PlayerOneScored;
import com.tennis.game.service.PlayerTwoScored;
import com.tennis.game.service.TennisGameService;

@RunWith(MockitoJUnitRunner.class)
class TennisGameServiceTests {

	private TennisGameService tennisGame;
	private PlayerOneScored playerOneScored;
	private PlayerTwoScored playerTwoScored;
	
	@BeforeEach
	public void setUp() {
		tennisGame = new TennisGameService();
		playerOneScored = new PlayerOneScored();
		playerTwoScored = new PlayerTwoScored();
	}

	@ParameterizedTest
	@CsvSource({
		"0,0,Love All" ,
		"1,1,Fifteen All",
		"2,2,Thirty All",
		"3,3,Deuce",
		"4,3,Advantage PlayerOneName",
		"3,4,Advantage PlayerTwoName",
		"4,6,Game PlayerTwoName",
		"6,4,Game PlayerOneName",
		"0,1,Love Fifteen",
		"1,2,Fifteen Thirty",
		"2,1,Thirty Fifteen",
		"0,2,Love Thirty",
		"0,3,Love Forty",
		"0,4,Game PlayerTwoName",
		"1,0,Fifteen Love",
		"1,3,Fifteen Forty",
		"1,4,Game PlayerTwoName",
		"2,0,Thirty Love",
		"2,3,Thirty Forty",
		"2,4,Game PlayerTwoName",
		"3,0,Forty Love",
		"3,1,Forty Fifteen",
		"3,2,Forty Thirty",
		"3,4,Advantage PlayerTwoName",
		"3,5,Game PlayerTwoName",
		"4,0,Game PlayerOneName",
		"4,1,Game PlayerOneName",
		"4,2,Game PlayerOneName",
	})
	void parameterizedTestCaseforEachTest(String playerOneScore, String playerTwoScore, String expectedScore) {
		playerOneScored.setScoreForPlayerOne(playerOneScore);
		playerTwoScored.setScoreForPlayerTwo(playerTwoScore);
		assertThat(tennisGame.getGameScore(playerOneScored.getPlayerOneScored(), playerTwoScored.getPlayerTwoScored()))
				.isEqualTo(expectedScore);
	}
	
}
