package com.rps.controller;
import com.rps.entities.datamodel.GameResult;
import com.rps.entities.datamodel.Move;
import com.rps.service.GameLogic;
import com.rps.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    private final IGameService gameService;

    @Autowired
    public GameController( IGameService gameService ) {
        this.gameService = gameService;
    }


    //New game vs Bot
    @PostMapping(path = "/rps/play", consumes = "application/json")
    public GameResult newGame( @RequestBody Move player){
        return this.gameService.newGame(new GameLogic(player)); // injecting player in game logic
    }

    //Getting all results stored in the database
    @GetMapping("/rps/result/")
    public List<GameResult> getAllResults(){
        return this.gameService.getAllResults();
    }

}
