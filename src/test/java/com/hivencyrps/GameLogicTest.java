package com.hivencyrps;

import com.rps.entities.datamodel.GameResult;
import com.rps.entities.datamodel.Move;
import com.rps.helper.IOHelper;
import com.rps.service.GameLogic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {

    @Test
    @DisplayName("Player plays rock and bot plays paper")
    public void PaperWinsAgainstRockTest() {

        GameLogic gameLogicTest = new GameLogic(new Move("Qasim", "rock"), IOHelper.LoadMapFromJson()) {
            @Override
            public Move getBotMove() {
                return new Move("Bot", "paper");
            }
        };

        GameResult result = gameLogicTest.CalculateResult();
        assertEquals("Bot Won", result.getResult());
    }

    @Test
    @DisplayName("MatchShouldDraw")
    public void MatchShouldDraw() {

        GameLogic gameLogicTest = new GameLogic(new Move("Qasim", "rock"), IOHelper.LoadMapFromJson()) {
            @Override
            public Move getBotMove() {
                return new Move("Bot", "rock");
            }
        };

        GameResult result = gameLogicTest.CalculateResult();
        assertEquals("Game Draw", result.getResult());
    }


}
