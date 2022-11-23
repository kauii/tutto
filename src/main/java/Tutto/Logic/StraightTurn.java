package Tutto.Logic;

import java.util.Scanner;

public class StraightTurn extends Turn {

    private int points = 0;
    private int[] dicesKept;
    StraightLogic logic = new StraightLogic();
    Scanner scanner = new Scanner(System.in);
    public StraightTurn() {

        boolean ending = false;
        int[] checkKeep;
        boolean isValid;

        while(!ending) {
            int[] dicesRolled = diceSet.rollSet(6-dicesKept.length);
            printer.printTurn(dicesKept, dicesRolled, points);

            // check if null round via StraightLogic
            if(!logic.validateNullRound(dicesRolled, dicesKept)) {
                // if null round -> end
                ending = true;
            } else {
                // player chooses what dices to keep and validates the choice
                do {

                    // Decide what dice to keep
                    checkKeep =  keepInput(dicesRolled);  // TODO: either protected instead private or create keepInput again?
                    // validation via DiceLogic
                    isValid = logic.validateKeep(checkKeep);
                } while (!isValid);

                // add newly kept dices to dicesKept
                dicesKept = concatenate(dicesKept, checkKeep);  // TODO: either protected instead private or create keepInput again?

                // check tutto/straight
                boolean straight = logic.isTutto(dicesKept);

                // check tutto/straight
                if (straight) {
                    points = 2000;
                    ending = true;
                }
            }
        }

        // close Scanner
        scanner.close();
    }
}
