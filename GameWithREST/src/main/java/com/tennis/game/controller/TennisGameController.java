package com.tennis.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tennis.game.service.PlayerOneScored;
import com.tennis.game.service.PlayerTwoScored;
import com.tennis.game.service.TennisGameService;

@RestController
public class TennisGameController {
	@Autowired
	private TennisGameService tennisGameService;
	@Autowired
	private PlayerOneScored playerOneScored;
	@Autowired
	private PlayerTwoScored playerTwoScored;

	@GetMapping(path = "/getGameScore")
	public String gameHandlerAPI(@RequestParam String playerOneScore, @RequestParam String playerTwoScore) {
		playerOneScored.setScoreForPlayerOne(playerOneScore);
		playerTwoScored.setScoreForPlayerTwo(playerTwoScore);
		return tennisGameService.getGameScore(playerOneScored.getPlayerOneScored(),
				playerTwoScored.getPlayerTwoScored());
	}
}
