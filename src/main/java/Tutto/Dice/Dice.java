package Tutto.Dice;

import java.util.Random;

public class Dice {

    Random rn = new Random();

    public int roll() {
        // Global var
        return rn.nextInt(1, 7);
    }

}
