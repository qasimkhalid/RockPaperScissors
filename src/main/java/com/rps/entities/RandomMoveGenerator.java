package com.rps.entities;

import java.util.List;
import java.util.Random;

public class RandomMoveGenerator {

    public String getRandomMove( List<String> legalMove ) {
        Random random = new Random();
        return legalMove.get(random.nextInt(legalMove.size()));
    }
}
