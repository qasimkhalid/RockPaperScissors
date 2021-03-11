package com.rps.entities;
import java.util.Random;

public class RandomMoveGenerator {

    public LegalMove getRandomMove() {
        Random random = new Random();
        return (LegalMove.values()
                [random.nextInt(LegalMove.values().length)]);
    }
}
