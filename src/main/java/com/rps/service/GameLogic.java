package com.rps.service;

import com.rps.entities.LegalMove;
import com.rps.entities.RandomMoveGenerator;
import com.rps.entities.datamodel.GameResult;
import com.rps.entities.datamodel.Move;

import java.util.Arrays;

public class GameLogic implements IGameLogic {

    private final Move playerMove;

    public GameLogic( Move player ) {
        this.playerMove = player;
    }

    @Override
    public Move getBotMove() {
        RandomMoveGenerator randomMoveGenerator = new RandomMoveGenerator();
        LegalMove botMove = randomMoveGenerator.getRandomMove();

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

        if (player.getMove() == bot.getMove()) {
            gameResult.setResult("Game Draw");
        }
        else {

            // Rock > Lizard
            // Rock > Scissors
            // Paper > Rock
            // Paper > Spock
            // Scissors > Paper
            // Scissors > Lizard
            // Spock >  Rock
            // Spock > Scissors
            // Lizard > Paper
            // Lizard > Spock

            boolean rockWins = player.getMove() == LegalMove.rock && ((bot.getMove() == LegalMove.scissors) || (bot.getMove() == LegalMove.lizard));
            boolean paperWins = player.getMove() == LegalMove.paper && ((bot.getMove() == LegalMove.rock) || (bot.getMove() == LegalMove.spock));
            boolean scissorsWins = player.getMove() == LegalMove.scissors && ((bot.getMove() == LegalMove.paper) || (bot.getMove() == LegalMove.lizard));
            boolean spockWins = player.getMove() == LegalMove.spock && ((bot.getMove() == LegalMove.rock) || (bot.getMove() == LegalMove.scissors));
            boolean lizardWins = player.getMove() == LegalMove.lizard && ((bot.getMove() == LegalMove.paper) || (bot.getMove() == LegalMove.spock));


            if (rockWins || paperWins || scissorsWins || spockWins || lizardWins) {
                gameResult.setResult(player.getName() + " Won");
            } else {
                gameResult.setResult("Bot Won");
            }
        }
        return gameResult;
    }
}
