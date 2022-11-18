package Tutto.Logic;

public class Turn {

    private int points = 0;
    private int[] dicesKept;
    private int[] dicesRolled;
    DiceSet diceSet = new DiceSet();
    Printer printer = new Printer();
    DiceLogic logic = new DiceLogic();

    public Turn() {

        boolean ending = false;

        while (!ending) {
            dicesRolled = diceSet.rollSet();
            printer.printTurn(dicesKept, dicesRolled);

            // check if null round via DiceLogic
            if (!logic.validateNullRound(dicesRolled)) {
                // if null round -> end
                ending = true;
            } else {

                // Decide what dice to keep
                // do-while
                // validation via DiceLogic
                // if valid add points

            }

            // player decides what to do: R -> reroll; E -> ending


        }

    }

    // dice rolling while loop
    // decide whether to keep dices
    // loop ends when Tutto/NULL or player decides to end round

    public int getTurnPoints() {
        return points;
    }

}
