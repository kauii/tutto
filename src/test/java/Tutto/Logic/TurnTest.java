package Tutto.Logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TurnTest {
    Turn turn;

    @BeforeEach
    public void setUp() {
        turn = new Turn();
    }

    @Test
    void nextTurn() {
        // intentionally left blank
    }

    @Test
    void concatenate() {
        assert (Arrays.equals(turn.concatenate(new int[]{1, 2, 3}, new int[]{4, 5, 6}), new int[]{1, 2, 3, 4, 5, 6}));
        assert (Arrays.equals(turn.concatenate(new int[]{}, new int[]{4, 5, 6}), new int[]{4, 5, 6}));
        assert (Arrays.equals(turn.concatenate(new int[]{1, 2, 3}, new int[]{}), new int[]{1, 2, 3}));
        assert (Arrays.equals(turn.concatenate(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7, 8}), new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        assert (Arrays.equals(turn.concatenate(new int[]{}, new int[]{}), new int[]{}));
        assert (Arrays.equals(turn.concatenate(new int[]{4, 5, 6}, new int[]{4, 5, 6}), new int[]{4, 5, 6, 4, 5, 6}));
    }

    @Test
    void keepInput() {
        // intentionally left blank
    }

    @Test
    void getTurnPoints() {
        assert (turn.getTurnPoints() == 0);
    }

    @Test
    void getTutto() {
        assert (!turn.getTutto());
    }

    @Test
    void getNullRound() {
        assert (!turn.getNullRound());
    }
}