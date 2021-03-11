package com.rps.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rps.entities.LegalMove;
import com.rps.entities.RandomMoveGenerator;
import com.rps.entities.datamodel.GameResult;
import com.rps.entities.datamodel.Move;
//import org.json.simple.JSONArray;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        Map<String, List> winningMap = null;

        try (FileReader reader = new FileReader("data/winMap.json"))
        {
            Type type = new TypeToken<Map>(){}.getType();
            winningMap = new Gson().fromJson(reader, type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (player.getMove() == bot.getMove()) {
            gameResult.setResult("Game Draw");
        }
        else {
            List moveFound = winningMap.get(String.valueOf(player.getMove()));
            if (moveFound.contains(String.valueOf(bot.getMove()))) {
                gameResult.setResult(player.getName() + " Won");
            }
            else{
                gameResult.setResult("Bot Won");
            }
        }
        return gameResult;
    }
}
