package Tutto.Logic;

import java.util.Random;

public class Dice {

    // Global var
    private int dValue = 0;
    private boolean locked = false;

    Random rn = new Random();

    public int roll() {
        dValue = rn.nextInt(1, 6);
        return dValue;
    }

    public int getValue() {
        return dValue;
    }

    public void setLocked() {
        locked = true;
    }

    public boolean getLocked() {
        return locked;
    }

}
