package Tutto;

import Tutto.Logic.Card;
import Tutto.Logic.CardLogic;
import Tutto.Logic.Deck;

public class Game {
    public Game() {

        Deck deck = new Deck();
        Card card = deck.pullRandom();
        String card1 = String.valueOf(card.getRank());

        //p1 turn
        CardLogic c1 = new CardLogic();
        c1.checkCard(card1);
    }
}