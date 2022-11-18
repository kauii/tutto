package Tutto.Logic;

public class DiceLogic {

    public boolean validateKeep(int[] toCheck) {
        return true;
    }

    public int pointsKeep(int[] toCheck){
        return 0;
    }

    public boolean validateNullRound(int[] dicesRolled) {
        return true;
    }

    public boolean isTutto(int[] keptDices){
        return keptDices.length >= 6;
    }

}
