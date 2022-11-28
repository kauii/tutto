package Tutto.Logic;

import java.util.ArrayList;
import java.util.Scanner;

public class Turn {

    private int points = 0;
    private boolean tutto = false;
    private boolean nullRound = false;
    DiceSet diceSet = new DiceSet();
    Printer printer = new Printer();
    DiceLogic logic = new DiceLogic();
    Scanner scanner = new Scanner(System.in);

    // Constructor
    public void nextTurn(String card) {

        boolean ending = false;
        int[] toKeep;
        int[] dicesKept = {};

        while (!ending) {
            int[] dicesRolled = diceSet.rollSet(6 - dicesKept.length);
            printer.printTurn(dicesKept, dicesRolled, points);

            // check if null round via DiceLogic
            if (logic.validateNullRound(dicesRolled)) {
                // if null round -> end
                ending = true;
                nullRound = true;
                System.out.println("NULLROUND");
            } else {
                // player chooses what dices to keep and validates the choice
                toKeep = decideKeep(card, dicesRolled);

                // add points
                points += logic.pointsKeep(toKeep);

                // add newly kept dices to dicesKept
                dicesKept = concatenate(dicesKept, toKeep);

                // check tutto
                tutto = logic.isTutto(dicesKept);

                // check tutto
                if (tutto) {
                    printer.printTurn(dicesKept, dicesRolled, points);
                    ending = true;
                } else {
                    // Depending on cards, player can choose to end turn
                    if (!card.equals("FIREWORKS") && !card.equals("PLUSMINUS") && !card.equals("CLOVERLEAF")) {
                        // player decides what to do: R -> reroll; E -> ending
                        ending = rerollInput();
                    }
                }
            }
        }

        // close Scanner
        scanner.close();
    }

    private int[] decideKeep(String card, int[] dicesRolled) {
        int[] checkKeep;
        boolean isValid;

        if (!card.equals("FIREWORKS")) {

            do {
                // Decide what dice to keep
                checkKeep = keepInput(dicesRolled);
                // Validate via DiceLogic
                isValid = logic.validateKeep(checkKeep);
                if (!isValid) {
                    System.out.println("Invalid choice. Choose again!");
                }
            } while (!isValid);
        } else {
            checkKeep = logic.keepAll(dicesRolled);
        }

        return checkKeep;
    }


    public int[] concatenate(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] con = new int[aLen + bLen];

        System.arraycopy(a, 0, con, 0, aLen);
        System.arraycopy(b, 0, con, aLen, bLen);
        return con;
    }

    protected int[] keepInput(int[] dicesRolled) {
        String inp;
        ArrayList<Integer> dicesKeep = new ArrayList<>();
        boolean tryAgain;

        do {
            // iterate through rolled dices and ask if to keep
            for (int i = 1; i <= dicesRolled.length; i++) {
                System.out.printf("Keep dice No. %d?\n", i);
                System.out.println("Y - Yes | N - No");
                inp = scanner.nextLine().toLowerCase();
                if (inp.charAt(0) == 'y') {
                    dicesKeep.add(dicesRolled[i - 1]);
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

        return dicesKeep.stream().mapToInt(a -> a).toArray();
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

    public boolean getNullRound() {
        return nullRound;
    }

}
