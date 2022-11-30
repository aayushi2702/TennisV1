package com.tennis.gametest.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.tennis.game.service.TennisGameService;

@RunWith(MockitoJUnitRunner.class)
class TennisGameServiceTests {

	private TennisGameService tennisGame;
	
	@BeforeEach
	public void setUp() {
		tennisGame = new TennisGameService("PlayerOneName", "PlayerTwoName");
	}

	@ParameterizedTest
	@CsvSource({
		"0,0,Love All" ,
	})
	void parameterizedTestCaseforEachTest(int playerOneScore, int playerTwoScore, String expectedScore) {
		for(int i=0; i<playerOneScore; i++) {
			tennisGame.playerOneScored();
		}
		for(int i=0; i<playerTwoScore; i++) {
			tennisGame.playerTwoScored();
		}
		assertThat(tennisGame.getGameScore()).isEqualTo(expectedScore);
	}
	
}
