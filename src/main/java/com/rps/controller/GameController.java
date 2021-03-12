package com.rps.controller;

import com.rps.entities.datamodel.GameResult;
import com.rps.entities.datamodel.Move;
import com.rps.helper.IOHelper;
import com.rps.service.GameLogic;
import com.rps.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GameController {

    private final IGameService gameService;

    @Autowired
    public GameController( IGameService gameService ) {
        this.gameService = gameService;
    }


    //New game vs Bot
    @PostMapping(path = "/rps/play", consumes = "application/json")
    public GameResult newGame( @RequestBody Move player ) {
        Map<String, List<String>> map = IOHelper.LoadMapFromJson();
        return this.gameService.newGame(
                new GameLogic(player, map)); // injecting player in game logic
    }

    //Getting all results stored in the database
    @GetMapping("/rps/result/")
    public List<GameResult> getAllResults() {
        return this.gameService.getAllResults();
    }

    public class Config{
        public double handicapBot = 0;
    }

}
