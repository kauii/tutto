package Tutto.Logic;

import java.util.Arrays;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String[] getNames() {
        String line;
        String[] names;

        System.out.println("Enter the player names (separated by a comma \",\"):");
        line = scanner.nextLine(); // TODO: Error catching + check player amount

        // Separate all values by comma
        names = line.split(",");

        // Sort names alphabetically
        Arrays.sort(names);

        return names;
    }

    public int[] getDicesKeep(int[] dicesRolled) {
        String line;
        String[] dices;
        int size;
        int[] res;

        System.out.println("Enter index of dices to keep (separated by a comma \",\"):");
        line = scanner.nextLine();  // TODO: Error catching

        // Separate all values by comma
        dices = line.split(",");
        size = dices.length;

        // Loop through each item in dices and save it as an integer
        res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = dicesRolled[Integer.parseInt(dices[i]) - 1];
        }
        return res;
    }

    public int getTarget() {
        int target = 6500;

        System.out.println("Enter the target score (Recommended: 6500):");
        target = scanner.nextInt();  // TODO: Default + error
        scanner.nextLine();

        return target;
    }

    public boolean getPlayChoice(String name) {
        boolean printScore;

        System.out.println();
        System.out.println("############################################");
        System.out.println("It's the turn of " + name);
        System.out.println("Do you want to print the scoreboard?");
        System.out.println("Y - Yes | N - No");         // TODO: Catch empty entry error
        String inp = scanner.nextLine().toLowerCase();
        printScore = inp.charAt(0) == 'y';

        return printScore;
    }

    public void close() {
        scanner.close();
    }
}
