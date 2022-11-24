package Tutto.Logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceLogicTest {
    DiceLogic logic = new DiceLogic();

    @Test
    void validateKeep() {
        // Check valid options
        assertTrue(logic.validateKeep(new int[]{1, 1, 1, 1, 1, 1}));
        assertTrue(logic.validateKeep(new int[]{5, 5, 5, 5, 1, 1}));
        assertTrue(logic.validateKeep(new int[]{1}));
        assertTrue(logic.validateKeep(new int[]{5}));
        assertTrue(logic.validateKeep(new int[]{2, 2, 2, 5}));
        assertTrue(logic.validateKeep(new int[]{6, 3, 6, 3, 6, 3}));

        // Check invalid options
        assertFalse(logic.validateKeep(new int[]{1, 1, 1, 1, 1, 4}));
        assertFalse(logic.validateKeep(new int[]{6, 6, 6, 6}));
        assertFalse(logic.validateKeep(new int[]{1, 2, 3, 4, 5, 6}));
        assertFalse(logic.validateKeep(new int[]{4, 4, 4, 6, 6, 5}));
        assertFalse(logic.validateKeep(new int[]{2, 3, 2, 3, 2, 5}));
        assertFalse(logic.validateKeep(new int[]{1, 1, 6, 6, 3, 6}));
    }

    @Test
    void pointsKeep() {
        // 1
        assert (logic.pointsKeep(new int[]{1}) == 100);
        assert (logic.pointsKeep(new int[]{1, 1}) == 200);
        assert (logic.pointsKeep(new int[]{1, 1, 1}) == 1000);
        assert (logic.pointsKeep(new int[]{1, 1, 1, 1}) == 1100);
        assert (logic.pointsKeep(new int[]{1, 1, 1, 1, 1}) == 1200);
        assert (logic.pointsKeep(new int[]{1, 1, 1, 1, 1, 1}) == 2000);

        // 5
        assert (logic.pointsKeep(new int[]{5}) == 50);
        assert (logic.pointsKeep(new int[]{5, 5}) == 100);
        assert (logic.pointsKeep(new int[]{5, 5, 5}) == 500);
        assert (logic.pointsKeep(new int[]{5, 5, 5, 5}) == 550);
        assert (logic.pointsKeep(new int[]{5, 5, 5, 5, 5}) == 600);
        assert (logic.pointsKeep(new int[]{5, 5, 5, 5, 5, 5}) == 1000);

        // Triplets
        assert (logic.pointsKeep(new int[]{2, 2, 2}) == 200);
        assert (logic.pointsKeep(new int[]{2, 2, 2, 2, 2, 2}) == 400);
        assert (logic.pointsKeep(new int[]{3, 3, 3}) == 300);
        assert (logic.pointsKeep(new int[]{3, 3, 3, 3, 3, 3}) == 600);
        assert (logic.pointsKeep(new int[]{4, 4, 4}) == 400);
        assert (logic.pointsKeep(new int[]{4, 4, 4, 4, 4, 4}) == 800);
        assert (logic.pointsKeep(new int[]{6, 6, 6}) == 600);
        assert (logic.pointsKeep(new int[]{6, 6, 6, 6, 6, 6}) == 1200);

        // Mixes
        assert (logic.pointsKeep(new int[]{5, 2, 2, 2}) == 250);
        assert (logic.pointsKeep(new int[]{3, 3, 1, 3}) == 400);
        assert (logic.pointsKeep(new int[]{6, 6, 6, 5, 5, 5}) == 1100);
        assert (logic.pointsKeep(new int[]{1, 2, 1, 2, 1, 2}) == 1200);
        assert (logic.pointsKeep(new int[]{4, 4, 4, 1, 1, 5}) == 650);
        assert (logic.pointsKeep(new int[]{1, 5, 4, 4, 4}) == 550);
    }

    @Test
    void validateNullRound() {
        assertTrue(logic.validateNullRound(new int[]{2, 3, 3, 4, 4, 6}));
        assertFalse(logic.validateNullRound(new int[]{1, 3, 3, 4, 4, 4}));
    }

    @Test
    void isTutto() {
        assertTrue(logic.isTutto(new int[]{2, 3, 5, 6, 2, 1}));
        assertFalse(logic.isTutto(new int[]{1, 3}));
    }
}