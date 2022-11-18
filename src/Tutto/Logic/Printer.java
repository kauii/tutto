package Tutto.Logic;

public class Printer {

    public void printTurn(int[] dicesKept, int[] dicesRolled) {
        StringBuilder msg;
        int counter = 0;

        System.out.println("=== Kept Dices ===");
        // print the values of each dice that is being kept atm
        for (int dice : dicesKept) {
            System.out.print(dice + " ");
        }
        System.out.println();

        System.out.println("=== Rolled Dices ===");
        // print the values of each dice that has been rolled
        msg = new StringBuilder("Value: ");
        for (int dice : dicesRolled) {
            msg.append(dice);
            msg.append(" ");
            counter++;
        }
        System.out.println(msg);

        // clear string
        msg.setLength(0);

        // print dice nr
        msg.append("Dice:  ");
        for (int i = 0; i <= counter; i++) {
            msg.append(i);
            msg.append(" ");
        }
        System.out.println(msg);

        System.out.println();

    }

}
