package Tutto.Terminal;

import Tutto.Player;

import java.util.ArrayList;

public class Printer {

    public void printTurn(int[] dicesKept, int[] dicesRolled, int points) {
        StringBuilder msg;
        int counter = 0;

        System.out.println();
        System.out.println("==================");
        // Print current points
        System.out.println("Current points: " + points);

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
        msg.append("Index: ");
        for (int i = 1; i <= counter; i++) {
            msg.append(i);
            msg.append(" ");
        }
        System.out.println(msg);

        System.out.println();

    }

    public void printScoreboard(ArrayList<Player> players) {
        System.out.println("\n\n");
        System.out.println("====== Scoreboard ======");
        for (Player player : players) {
            System.out.printf("%-20s", player.getName());
            System.out.println(player.getScore());
        }
        System.out.println("========================\n\n");
    }

}
