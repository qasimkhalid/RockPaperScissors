package com.rps.service;
import com.rps.entities.RandomMoveGenerator;
import com.rps.entities.datamodel.GameResult;
import com.rps.entities.datamodel.Move;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GameLogic implements IGameLogic {

    private final Move playerMove;

    private Map<String, List<String>> map = null;

    public GameLogic( Move player, Map<String, List<String>> inputMap ) {
        this.playerMove = player;
        this.map = inputMap;
    }

    @Override
    public Move getBotMove() {
        RandomMoveGenerator randomMoveGenerator = new RandomMoveGenerator();
        List<String> legalMove = new ArrayList<String>(map.keySet());
        String botMove = randomMoveGenerator.getRandomMove(legalMove);

        return new Move("bot", botMove);
    }

    @Override
    public Move getPlayerMove() {
        return this.playerMove;
    }

    @Override
    public GameResult CalculateResult() {
        GameResult gameResult = new GameResult();

        Move player = getPlayerMove();
        Move bot = getBotMove();

        gameResult.setMoves(Arrays.asList(player, bot));

        if (player.getMove().equals(bot.getMove())) {
            gameResult.setResult("Game Draw");
        }
        else {
            List dominatesOver = map.get(player.getMove());
            if (dominatesOver.contains(bot.getMove())) {
                gameResult.setResult(player.getName() + " Won");
            }
            else{
                gameResult.setResult("Bot Won");
            }
        }
        return gameResult;
    }
}
