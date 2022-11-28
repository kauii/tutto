package Tutto.Logic;

import java.util.Objects;

public class CardLogic {
    int score;
    boolean tutto;

    public void checkCard(String card) {
        System.out.println(card);

        if (Objects.equals(card.charAt(0), 'B')) {
            int bonus = Integer.parseInt(card.substring(5));  // BONUS500 --> substring '500' turn to int 500
            score = bonusCard(bonus);
        }
        if (Objects.equals(card, "X2")) {
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
        if (Objects.equals(card, "STRAIGHT")) {
            score = straightCard();
        }
    }

    //BONUS - RULE
    private int bonusCard(int bonus) {
        Turn turn = new Turn();
        turn.nextTurn("BONUS");
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
        turn.nextTurn("DOUBLE");
        tutto = turn.getTutto();
        score = turn.getTurnPoints();

        if(tutto) {
            return score * 2;
        }
        return score;
    }

    //FIREWORKS - RULE
    private int fireworksCard() {
        Turn turn = new Turn();
        turn.nextTurn("FIREWORKS");
        tutto = turn.getTutto();
        score = turn.getTurnPoints();
        if (tutto) {
            turn.nextTurn("FIREWORKS");
            score += turn.getTurnPoints();
        }
        return score;
    }

    //PLUS/MINUS - RULE
    private int plusminusCard() { //TODO: may not stop until tutto
        Turn turn = new Turn();
        turn.nextTurn("PLUSMINUS");
        tutto = turn.getTutto();
        if (tutto) {
            return 1000;
        }
        return 0;
    }

    //CLOVERLEAF - RULE
    private int cloverCard() {
        Turn turn1 = new Turn();    //TODO: may not stop until tutto
        turn1.nextTurn("CLOVERLEAF");
        tutto = turn1.getTutto();
        if(tutto) {
            Turn turn2 = new Turn();
            turn2.nextTurn("CLOVERLEAF");
            tutto = turn2.getTutto();
            if(tutto) {
                return 999999999;
            }
        }
        return 0;
    }

    //STRAIGHT - RULE
    private int straightCard() {
        StraightTurn turn = new StraightTurn("STRAIGHT");
        score = turn.getTurnPoints();
        return score;
    }

    public int getScore() {
        return score;
    }

}
