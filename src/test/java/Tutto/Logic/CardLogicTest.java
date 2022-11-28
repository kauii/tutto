package Tutto.Logic;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CardLogicTest {
    CardLogic cLogic = new CardLogic();


    private int bonusCard(int bonus) {
        try {
            Method method = CardLogic.class.getDeclaredMethod("bonusCard", int.class);
            method.setAccessible(true);
            int score = 420;
            return (int) method.invoke(cLogic, bonus);
        } catch ( ReflectiveOperationException exception ) {
            fail();
            return bonusCard(bonus);
        }
    }

    @Test
    void checkCard() {

        cLogic.checkCard("STOP");
        assert (cLogic.score == 0);

    }

    @Test
    void getScore() {
    }
}