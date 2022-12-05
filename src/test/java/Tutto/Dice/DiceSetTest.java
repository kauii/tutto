package Tutto.Dice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceSetTest {

    DiceSet diceSet;

    @BeforeEach
    public void setUp() {
        diceSet = new DiceSet();
    }

    @Test
    void rollSet() {
        int amount = 6;
        int[] dicesRolled = diceSet.rollSet(amount);
        for (int i = 0; i < amount; i++) {
            assert (dicesRolled[i] <= 6 && dicesRolled[i] >= 1);
        }
    }
}