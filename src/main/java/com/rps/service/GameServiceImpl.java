package com.rps.service;
import com.rps.entities.datamodel.GameResult;
import com.rps.repository.GameResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements IGameService {

    @Autowired
    private GameResultRepo gameResultRepo;

    @Override
    public List<GameResult> getAllResults ( ) {
        return gameResultRepo.findAll();
    }

    @Override
    public GameResult newGame (IGameLogic gameLogic){

        GameResult gameResult = gameLogic.CalculateResult();
        gameResultRepo.save(gameResult);

        return gameResult;
    }

}
