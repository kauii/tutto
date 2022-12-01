package Tutto;

import java.util.ArrayList;

public class Player {
    public int Score = 0;
    private String Name;

    public Player(){
        Name = Input.GetPlayerName();
    }
    public void play(Deck deck, Game game){
        int points = 0;
        boolean turnEnded = false;

        while (!turnEnded){
            // ui.showPlayers
            Card card = deck.pullRandom();
            // ui.showCard()

            ArrayList<Die> dice = Dice.roll();

            points += card.Handle(game, this, dice)

        }
        score += points
    }
}
