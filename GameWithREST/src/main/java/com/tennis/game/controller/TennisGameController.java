package com.tennis.game.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tennis.game.service.TennisGameService;

@RestController
public class TennisGameController {
	
	private TennisGameService tennisGameService=new TennisGameService("PlayerOneName", "PlayerTwoName");

	@GetMapping(path = "/getGameScore")
	public String gameHandlerAPI(@RequestParam int playerOneScore,@RequestParam int playerTwoScore) {
		for(int i=0; i<playerOneScore; i++) {
			tennisGameService.playerOneScored();
		}
		for(int i=0; i<playerTwoScore; i++) {
			tennisGameService.playerTwoScored();
		}
		return tennisGameService.getGameScore();
	}
}
