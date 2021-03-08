package com.rps.service;

import com.rps.entities.datamodel.GameResult;
import com.rps.entities.datamodel.Move;

public interface IGameLogic {

    Move getBotMove();

    Move getPlayerMove();

    GameResult CalculateResult();
}
