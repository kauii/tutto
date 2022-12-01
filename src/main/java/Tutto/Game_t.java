package Tutto;

import Tutto.Logic.Card;
import Tutto.Logic.CardLogic;
import Tutto.Logic.Deck;

public class Game {
    public Game() {

        Deck deck = new Deck();
        Card card = deck.pullRandom();

        //p1 turn
        CardLogic c1 = new CardLogic();
        c1.checkCard(card);
    }

    private ArrayList<Player> players = new ArrayList<>();
    private CardDeck deck,
    protected int PlayerCount;
    public static int GoalPoints;

    boolean GameIsEnded;
    protected Player CurrentPlayer;

    public Game(int GoalPoints) {
        PlayerCount = Input.GetPlayerNum();
        GoalPoints = GoalPoints;
        Deck deck = new Deck();

        for (int I = 0; i < PlayerCount; i++){
            players.add(new Player());
        }
    }

    Public void GameLoop(){
        while (!GameIsEnded){
            nextPlayer();

            if(CurrentPlayer.isWinning()){
                GameIsEnded = true;
                UI.ShowVictoryScreen(CurrentPlayer);
                return;
        }
        CurrentPlayer.play(new CardDeck(), this);

    }
}
    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }
    private void nextPlayer(){
        if(CurrentPlayer == null)
            CurrentPlayer = players.get(0);

        int curIndex = players.indexOF(CurrentPlayer);
        if(curIndex) >= players.size() - 1
            curIndex = 0;
        else
            curIndex++;
        CurrentPlayer = players.get(curIndex)
    }
}