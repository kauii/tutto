package Tutto.Logic;

import org.junit.jupiter.api.Test;

class CardLogicTest {
    CardLogic cLogic = new CardLogic();

    @Test
    void checkCard() {

        cLogic.checkCard(new Card(Rank.STOP));
        assert (cLogic.getScore() == 0);
        assert (!cLogic.getTutto());

        cLogic.checkCard(new Card(Rank.FIREWORKS));
        assert (!cLogic.getTutto()); // Needs to be always false

    }

    @Test
    void setScore() {
        cLogic.setScore(500);
        assert (cLogic.getScore() == 500);
    }
}