package Tutto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    Player player;

    @BeforeEach
    public void setUp() {
        player = new Player("John Doe");
    }

    @Test
    void getName() {
        assert (player.getName().equals("John Doe"));
    }

    @Test
    void getScore() {
        assert (player.getScore() == 0);
        player.addScore(100);
        assert (player.getScore() == 100);
    }

    @Test
    void addScore() {
        player.addScore(1000);
        assert (player.getScore() == 1000);
        player.addScore(250);
        assert (player.getScore() == 1250);
        // Subtract fewer points than available
        player.addScore(-1000);
        assert (player.getScore() == 250);
        // Subtract more points than available
        player.addScore(-1000);
        assert (player.getScore() == 0);
    }
}