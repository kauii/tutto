package Tutto.Logic;

import static Tutto.Logic.Rank.*;

public class CardLogic {
    int score;
    boolean tutto;

    public void checkCard(Card card) {
        System.out.println("==================");
        System.out.println("Card: " + card.getRank());

        if (card.equals(new Card(BONUS600))) {
            score = bonusCard(600);
        }
        if (card.equals(new Card(BONUS500))) {
            score = bonusCard(500);
        }
        if (card.equals(new Card(BONUS400))) {
            score = bonusCard(400);
        }
        if (card.equals(new Card(BONUS300))) {
            score = bonusCard(300);
        }
        if (card.equals(new Card(BONUS200))) {
            score = bonusCard(200);
        }

        if (card.equals(new Card(X2))) {
            score = doubleCard();
        }
        if (card.equals(new Card(STOP))) {
            System.out.println("Tough luck!");
            tutto = false;
            score = 0;
        }
        if (card.equals(new Card(FIREWORKS))) {
            score = fireworksCard();
        }
        if (card.equals(new Card(PLUSMINUS))) {
            score = plusminusCard();
        }
        if (card.equals(new Card(CLOVERLEAF))) {
            score = cloverCard();
        }
        if (card.equals(new Card(STRAIGHT))) {
            score = straightCard();
        }

        System.out.println("You scored: " + score);
    }

    //BONUS - RULE
    private int bonusCard(int bonus) {
        Turn turn = new Turn();
        turn.nextTurn("BONUS");
        tutto = turn.getTutto();
        score += turn.getTurnPoints();

        if (tutto) {
            return score + bonus;
        }
        return score;
    }

    //DOUBLE - RULE
    private int doubleCard() {
        Turn turn = new Turn();
        turn.nextTurn("DOUBLE");
        tutto = turn.getTutto();

        if (tutto) {
            score += turn.getTurnPoints() * 2;
            return score;
        }
        score += turn.getTurnPoints();
        return score;
    }

    //FIREWORKS - RULE
    private int fireworksCard() {
        Turn turn = new Turn();
        do {
            turn.nextTurn("FIREWORKS");
            tutto = turn.getTutto();
        } while (tutto);
        System.out.println(turn.getTurnPoints());
        return turn.getTurnPoints();
    }

    //PLUS/MINUS - RULE
    private int plusminusCard() {
        Turn turn = new Turn();
        turn.nextTurn("PLUSMINUS");
        tutto = turn.getTutto();
        if (tutto) {
            return score += 1000;
        }
        return 0;
    }

    //CLOVERLEAF - RULE
    private int cloverCard() {
        Turn turn1 = new Turn();
        turn1.nextTurn("CLOVERLEAF");
        tutto = turn1.getTutto();
        if (tutto) {
            Turn turn2 = new Turn();
            turn2.nextTurn("CLOVERLEAF");
            tutto = turn2.getTutto();
            if (tutto) {
                return 999999999; //TODO: could lead to error, too high int value
            }
        }
        return 0;
    }

    //STRAIGHT - RULE
    private int straightCard() {
        StraightTurn turn = new StraightTurn();
        turn.nextTurn("STRAIGHT");
        score += turn.getTurnPoints();
        return score;
    }

    public int getScore() {
        return score;
    }

    public boolean getTutto() {
        return tutto;
    }

    public void setScore(int pScore) {
        score = pScore;
    }


}
