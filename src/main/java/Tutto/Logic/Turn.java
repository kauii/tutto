package Tutto.Logic;

import java.util.Scanner;

public class Turn {

    private int points = 0;
    private int[] dicesKept;
    private boolean tutto = false;
    DiceSet diceSet = new DiceSet();
    Printer printer = new Printer();
    DiceLogic logic = new DiceLogic();
    Scanner scanner = new Scanner(System.in);

    public Turn() {

        boolean ending = false;
        int[] checkKeep;
        boolean isValid;

        while (!ending) {
            int[] dicesRolled = diceSet.rollSet(6- dicesKept.length);
            printer.printTurn(dicesKept, dicesRolled, points);

            // check if null round via DiceLogic
            if (!logic.validateNullRound(dicesRolled)) {
                // if null round -> end
                ending = true;
            } else {
                // player chooses what dices to keep and validates the choice
                do {

                    // Decide what dice to keep
                    checkKeep = keepInput(dicesRolled);
                    // validation via DiceLogic
                    isValid = logic.validateKeep(checkKeep);

                } while (!isValid);

                // add points
                points += logic.pointsKeep(checkKeep);

                // add newly kept dices to dicesKept
                dicesKept = concatenate(dicesKept, checkKeep);

                // check tutto
                tutto = logic.isTutto(dicesKept);

                // check tutto
                if (tutto) {
                    ending = true;
                } else {
                    // player decides what to do: R -> reroll; E -> ending
                    ending = rerollInput();
                }
            }
        }

        // close Scanner
        scanner.close();
    }

    private int[] concatenate(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] con = new int[aLen + bLen];

        System.arraycopy(a, 0, con, 0, aLen);
        System.arraycopy(b, 0, con, aLen, bLen);
        return con;
    }

    private int[] keepInput(int[] dicesRolled) {
        String inp;
        int[] dicesKeep = new int[dicesRolled.length];
        boolean tryAgain;

        do {
            // iterate through rolled dices and ask if to keep
            for (int i = 0; i <= dicesRolled.length; i++) {
                System.out.printf("Keep dice No. %d?\n", i);
                System.out.println("Y - Yes | N - No");
                inp = scanner.nextLine().toLowerCase();
                if (inp.charAt(0) == 'y') {
                    dicesKeep[i] = dicesRolled[i];
                } else {
                    dicesKeep[i] = 0;
                }
            }

            // ask to confirm the selection
            System.out.println("Confirm selection:");
            System.out.println("Y - Yes | N - No");
            for (int value : dicesKeep) {
                System.out.printf("%d ", value);
            }
            System.out.println();
            inp = scanner.nextLine().toLowerCase();
            tryAgain = inp.charAt(0) == 'y';

        } while (!tryAgain);

        // TODO: Lock dices

        return dicesKeep;
    }

    private boolean rerollInput() {
        String inp;
        System.out.println("What do you want to do?");
        System.out.println("R - Reroll | E - End");

        // Switch: e -> return true; r -> return false; default -> try again
        while (true) {
            inp = scanner.nextLine().toLowerCase();
            switch (inp.charAt(0)) {
                case 'e':
                    return true;
                case 'r':
                    return false;
                default:
                    System.out.println("Invalid input. Try again.");
            }
        }
    }

    public int getTurnPoints() {
        return points;
    }

    public boolean getTutto() {
        return tutto;
    }

}
