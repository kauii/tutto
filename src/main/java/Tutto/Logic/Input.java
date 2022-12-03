package Tutto.Logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String[] getNames() {
        String line;
        String[] names;
        boolean valid;

        System.out.println("Enter the player names (separated by a comma \",\"):");
        do {
            line = scanner.nextLine();

            // Separate all values by comma
            names = line.split(",");

            // Limit name length to 15
            for (int i = 0; i < names.length; i++) {
                // TODO: Trim string
                try {
                    names[i]=names[i].replaceAll("^\\s+", "");
                    names[i] = names[i].substring(0, 15);
                } catch (StringIndexOutOfBoundsException ignored) {
                }
            }

            // Sort names alphabetically
            Arrays.sort(names);

            // Check between 2-4 Players
            if (names.length < 2 || names.length > 4) {
                valid = false;
                System.out.println("You need between 2 and 4 players!\nEnter names again:");
            } else {
                valid = true;
            }

            // Check duplicate names
            if (valid) {
                HashSet<Object> set = new HashSet<>();
                for (String name : names) {
                    if (!set.add(name)) {
                        System.out.println(name + " is a duplicate name.\nEnter names again:");
                        valid = false;
                        break;
                    }
                }
            }
        } while (!valid);

        return names;
    }

    public int[] getDicesKeep(int[] dicesRolled) {
        String line;
        String[] dices;
        int size;
        int[] res = new int[0];
        boolean valid = true;

        System.out.println("Enter index of dices to keep (separated by a comma \",\"):");
        do {
            line = scanner.nextLine();

            // Separate all values by comma
            dices = line.split(",");
            size = dices.length;

            try {
                // Loop through each item in dices and save it as an integer
                res = new int[size];
                for (int i = 0; i < size; i++) {
                    res[i] = dicesRolled[Integer.parseInt(dices[i]) - 1];
                    valid = true;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Enter valid indices!\nTry again:");
                valid = false;
            }
        } while (!valid);
        return res;
    }

    public int getTarget() {
        int target = 6500;
        boolean valid;

        System.out.println("Enter the target score (Recommended: 6500):");
        do {
            // Input mismatch error handling
            try {
                target = scanner.nextInt();
                valid = true;
            } catch (InputMismatchException exception) {
                System.out.println("Enter a valid integer!");
                valid = false;
            }
            scanner.nextLine();     // Finish line scan
        } while (!valid);
        return target;
    }

    public boolean getPlayChoice(String name) {
        boolean printScore;
        boolean valid;
        char inp = 'n';

        System.out.println();
        System.out.println("############################################");
        System.out.println("It's the turn of " + name);
        System.out.println("Do you want to display the scoreboard?");
        System.out.println("D - Display | R - Roll");

        do {
            // Catch errors
            try {
                inp = scanner.nextLine().toLowerCase().charAt(0);
                valid = true;
            } catch (StringIndexOutOfBoundsException exception) {
                System.out.println("Invalid argument. Try again.");
                valid = false;
            }
        } while (!valid);

        // If inp=='y' -> true, else false
        printScore = inp == 'd';

        return printScore;
    }

    public void enterContinue() {
        System.out.println("Enter any key to continue...");
        scanner.nextLine();
    }

    public boolean getContinue() {
        boolean con;
        boolean valid;
        char inp = 'n';

        System.out.println("Do you want to stop or continue?");
        System.out.println("S - Stop | C - Continue");

        do {
            // Catch errors
            try {
                inp = scanner.nextLine().toLowerCase().charAt(0);
                if (inp == 'c' || inp == 's') {
                    valid = true;
                } else {
                    System.out.println("Invalid argument. Try again.");
                    valid = false;
                }
            } catch (StringIndexOutOfBoundsException exception) {
                System.out.println("Invalid argument. Try again.");
                valid = false;
            }
        } while (!valid);

        return inp == 'c';
    }



    public void close() {
        // Close scanner at end of program
        scanner.close();
    }
}
