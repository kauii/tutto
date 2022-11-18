package Tutto.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceLogicTest {
    DiceLogic logic=new DiceLogic();

    @Test
    void validateKeep() {
    }

    @Test
    void pointsKeep() {
    }

    @Test
    void validateNullRound() {
        assertTrue (logic.validateNullRound(new int[]{2, 3, 3, 4, 4, 6}));
        assertFalse(logic.validateNullRound(new int[]{1,3,3,4,4,4}));
    }

    @Test
    void isTutto() {
        assertTrue(logic.isTutto(new int[]{2,3,5,6,2,1}));
        assertFalse(logic.isTutto(new int[]{1,3}));
    }
}