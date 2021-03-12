package com.rps.service;

import com.rps.entities.datamodel.GameResult;
import com.rps.entities.datamodel.Move;

import java.util.List;
import java.util.Map;

public interface IGameLogic {

    Move getBotMove();

    Move getPlayerMove();

    GameResult CalculateResult();
}
