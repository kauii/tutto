package Tutto.Logic;

public class StraightLogic extends DiceLogic {

    @Override
    public boolean validateKeep(int[] toCheck) {
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

        return n1 <= 1 && n2 <= 1 && n3 <= 1 && n4 <= 1 && n5 <= 1 && n6 <= 1;
    }

    @Override
    public int pointsKeep(int[] toCheck) {
        return 0;
    }

    public boolean validateNullRound(int[] dicesRolled, int[] dicesKept) {
        int count = 0;
        for (int dice1 : dicesKept) {
            for (int dice2 : dicesRolled) {
                if (dice1 == dice2) {
                    count++;
                }
            }
        }
        return count == dicesRolled.length;
    }
}
