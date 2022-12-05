package Tutto.Dice;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiceTest {

    Dice dice;

    @BeforeEach
    public void setUp() {
        dice = new Dice();
    }

    @Test
    void roll() {
        int value = dice.roll();
        assert (value <= 6 && value >= 1);
    }
}