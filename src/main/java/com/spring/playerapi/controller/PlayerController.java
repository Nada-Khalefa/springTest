package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.exception.StudentException;
import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;

//http://localhost:8080/api.player
@RestController
@RequestMapping("/api")
//http://localhost:8080/api.player/api
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
//http://localhost:8080/api.player/api/data
	@GetMapping("/data")
	public String getDate() {
		
		return "mydata";
	}
	
	//http://localhost:8080/api.player/api/players
	@GetMapping("/players")
	public List<Player> getPlayers(){
		
		return playerService.allPlayers();
	}
	
	//http://localhost:8080/api.player/api/players/id
	@GetMapping("/players/{id}")
	public Player getPlayerById(@PathVariable("id") int id) {
		Player p= playerService.showPlayer(id);
		if(p == null) {
			throw new StudentException("PLayer Not Found id: "+ id);
		}
		return p;
		
	}
	//http://localhost:8080/api.player/api/player?id=
//	@GetMapping("/player")
//	public Player getPlayerById(@RequestParam int id) {
//		
//		return playerService.showPlayer(id);
//		
//	}
	//http://localhost:8080/api.player/api/players
	@PostMapping("/players")
	public void savePlayer(@RequestBody Player player) {
		playerService.savePlayer(player);
	}
	
	
	
}
