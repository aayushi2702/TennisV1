package com.tennis.gametest.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.tennis.game.service.TennisGameService;

@RunWith(MockitoJUnitRunner.class)
class TennisGameServiceTests {

	private TennisGameService tennisGame = new TennisGameService("PlayerOneName", "PlayerTwoName");

	@Test
    void LoveAllTest() {
		assertThat(tennisGame.getGameScore()).isEqualTo("Love All");
    }
	
}
