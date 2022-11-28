package Tutto.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StraightLogicTest {

    StraightLogic logic = new StraightLogic();

    @Test
    void validateKeep() {
        // Check valid options
        assertTrue(logic.validateKeep(new int[]{1,2,3,4,5,6}));
        assertTrue(logic.validateKeep(new int[]{1}));
        assertTrue(logic.validateKeep((new int[]{4,2,6})));

        // Check invalid options
        assertFalse(logic.validateKeep(new int[]{1,2,3,4,5,1}));
        assertFalse(logic.validateKeep(new int[]{1,1}));
        assertFalse(logic.validateKeep(new int[]{1,4,2,4,3}));
    }

    @Test
    void pointsKeep() {
        // not used
    }

    @Test
    void validateNullRound() {
        assertTrue(logic.validateNullRound(new int[]{1,2,2}, new int[]{1,2,3}));
        assertFalse(logic.validateNullRound(new int[]{1,3,4}, new int[]{1,2,3,5}));
    }
}