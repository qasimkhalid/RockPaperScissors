package com.rps.service;
import com.rps.entities.datamodel.GameResult;

import java.util.List;

public interface IGameService {

    GameResult newGame(IGameLogic gameLogic); // injection of game logic here

    List<GameResult> getAllResults();

}
