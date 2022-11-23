package Tutto.Logic;

import java.util.Objects;

public class CardLogic {
    int score;
    boolean tutto;

    public void checkCard(String card) {

        //BONUS
        if (Objects.equals(card, "BONUS")) {
            int bonus = card.getBonus();
            score = bonusCard(bonus);
        }
        if (Objects.equals(card, "DOUBLE")) {
            score = doubleCard();
        }
        if (Objects.equals(card, "STOP")) {
            score = 0;
        }
        if (Objects.equals(card, "FIREWORKS")) {
            score = fireworksCard();
        }
        if (Objects.equals(card, "PLUSMINUS")) {
            score = plusminusCard();
        }
        if (Objects.equals(card, "CLOVERLEAF")) {
            score = cloverCard();
        }
    }

    //BONUS - RULE
    private int bonusCard(int bonus) {
        Turn turn = new Turn();
        tutto = turn.getTutto();
        score = turn.getTurnPoints();

        if(tutto) {
            return score + bonus;
        }
        return score;
    }

    //DOUBLE - RULE
    private int doubleCard() {
        Turn turn = new Turn();
        tutto = turn.getTutto();
        score = turn.getTurnPoints();

        if(tutto) {
            return score * 2;
        }
        return score;
    }

    //FIREWORKS - RULE
    private int fireworksCard() {
        Turn turn = new Turn(); // TODO: turn must change: player MUST keep all valid single dice and triplets, continue till null
        return 0;
    }

    //PLUS/MINUS - RULE
    private int plusminusCard() { //TODO: may not stop until tutto
        Turn turn = new Turn();
        tutto = turn.getTutto();
        if (tutto) {
            return 1000;
        }
        return 0;
    }

    //CLOVERLEAF - RULE
    private int cloverCard() {
        Turn turn1 = new Turn();    //TODO: may not stop until tutto
        tutto = turn1.getTutto();
        if(tutto) {
            Turn turn2 = new Turn();
            tutto = turn2.getTutto();
            if(tutto) {
                return 999999999;
            }
        }
        return 0;
    }

    public int getScore() {
        return score;
    }

}
