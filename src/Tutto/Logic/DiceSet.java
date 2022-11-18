package Tutto.Logic;

import java.util.ArrayList;

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
    public int[] rollSet() {
        int[] values;
        ArrayList<Integer> val = new ArrayList<>();

        // iterate through every dice
        for (Dice dice : dices) {
            // if dice not locked -> roll dice and set new value in array
            if (!dice.getLocked()) {
                val.add(dice.roll());
            }
        }
        values = val.stream().mapToInt(i -> i).toArray();
        // returns an array with the values of the rolled dices
        return values;
    }

}
