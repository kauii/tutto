package Tutto.Logic;

public class DiceSet {

    // create dices
    Dice d1 = new Dice();
    Dice d2 = new Dice();
    Dice d3 = new Dice();
    Dice d4 = new Dice();
    Dice d5 = new Dice();
    Dice d6 = new Dice();

    // all dices in list
    Dice[] dices = {d1, d2, d3, d4, d5, d6};

    // roll dices
    public int[] roll() {
        int[] values = {0, 0, 0, 0, 0, 0};

        // iterate through every dice
        for (int i = 0; i < dices.length; i++) {
            // if dice locked -> value remains 0
            if (!dices[i].getLocked()) {
                // if dice not locked -> roll dice and set new value in array
                values[i] = dices[i].roll();
            }
        }
        return values;
    }

}
