package Tutto.Logic;

public class DiceLogic {

    public boolean validateKeep(int[] toCheck) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n6 = 0;

        for (int dice : toCheck) {
            switch (dice) {
                case 2 -> n2++;
                case 3 -> n3++;
                case 4 -> n4++;
                case 6 -> n6++;
                default -> {
                }
            }
        }

        // check if selection is possible
        if (n2 != 0 && n2 != 3 && n2 != 6) {
            return false;
        }
        if (n3 != 0 && n3 != 3 && n3 != 6) {
            return false;
        }
        if (n4 != 0 && n4 != 3 && n4 != 6) {
            return false;
        }
        if (n6 != 0 && n6 != 3 && n6 != 6) {
            return false;
        }

        return true;
    }

    public int pointsKeep(int[] toCheck) {
        int points = 0;

        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;

        for (int dice : toCheck) {
            switch (dice) {
                case 1 -> n1++;
                case 2 -> n2++;
                case 3 -> n3++;
                case 4 -> n4++;
                case 5 -> n5++;
                case 6 -> n6++;
                default -> {
                }
            }
        }

        // check triplets
        if (n2 % 3 == 0) {
            points += (n2 / 3 * 200);
        }
        if (n3 % 3 == 0) {
            points += (n3 / 3 * 300);
        }
        if (n4 % 3 == 0) {
            points += (n4 / 3 * 400);
        }
        if (n6 % 3 == 0) {
            points += (n6 / 3 * 600);
        }

        // check ones and fives
        if (n1 > 0) {
            points += n1 / 3 * 1000;
            points += n1 % 3 * 100;
        }
        if (n5 > 0) {
            points += n5 / 3 * 500;
            points += n5 % 3 * 50;
        }

        return points;
    }

    public boolean validateNullRound(int[] dicesRolled) {
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n6 = 0;

        for (int dice : dicesRolled) {
            switch (dice) {
                case 1:
                case 5:
                    return false;
                case 2:
                    n2++;
                    break;
                case 3:
                    n3++;
                    break;
                case 4:
                    n4++;
                    break;
                case 6:
                    n6++;
                    break;
                default:
            }
        }

        return n2 < 3 && n3 < 3 && n4 < 3 && n6 < 3;
    }

    public boolean isTutto(int[] keptDices) {
        return keptDices.length >= 6;
    }

}
