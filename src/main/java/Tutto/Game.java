package Tutto;

import Tutto.Logic.*;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    private final Deck deck;
    Input in = new Input();
    private final int playerAmount;
    private int targetScore;

    public Game() {
        String[] playerNames;

        // Create new deck
        deck = new Deck();

        // Get player names and create players
        playerNames = in.getNames();             // Already sorted alphabetically
        playerAmount = playerNames.length;

        for (int i = 0; i < playerAmount; i++) {
            players.add(new Player(playerNames[i]));
        }

        // Get target score
        targetScore = in.getTarget();

        // game loop starting with
        gameLoop();


        in.close();
    }

    private void gameLoop() {
        boolean gameWon = false;
        int activePlayer = 0;
        boolean scoreboard;
        int points;
        CardLogic cLogic;
        Card card;
        Player leader;
        Printer printer = new Printer();

        // do while loop
        do {
            // Choose to print scoreboard or play
            scoreboard = in.getPlayChoice(players.get(activePlayer).getName());
            if (scoreboard) {
                printer.printScoreboard(players);
            }

            // Play -> draw card -> play round
            // Try to draw card from deck
            try {
                card = deck.pullRandom();
            } catch (IllegalStateException exception) {
                deck.reset();
                card = deck.pullRandom();
            }

            // Play round
            cLogic = new CardLogic();
            cLogic.checkCard(card);

            // Depending on card: directly won, add points, subtract points
            points = cLogic.getScore();
            players.get(activePlayer).addScore(points);

            // Check if PlusMinus and if player won
            if (card.equals(new Card(Rank.PLUSMINUS)) && points != 0) {
                // Find player with the highest score
                leader = findLeader();
                // If player with the highest score != active player -> subtract 1000 points
                if (!findLeader().equals(players.get(activePlayer)) && findLeader() != null) {
                    leader.addScore(-1000);
                }
            }

            // Check if activePlayer has enough points
            if (players.get(activePlayer).getScore() >= targetScore) {
                gameWon = true;
                // Print win message
                System.out.println();
                System.out.println("############################################");
                System.out.println(players.get(activePlayer).getName() + " won!!!");
                printer.printScoreboard(players);
            }


            // int active player gets reset when >= playerAmount
            activePlayer++;
            if (activePlayer >= playerAmount) {
                activePlayer = 0;
            }
        } while (!gameWon);
    }

    private Player findLeader() {
        int mostPoints = 0;
        int activeLeader = 0;

        for (int i = 0; i < playerAmount; i++) {
            if (players.get(i).getScore() > mostPoints) {
                mostPoints = players.get(i).getScore();
                activeLeader = i;
            }
        }

        // If most Points==0; return null
        if (mostPoints == 0) {
            return null;
        }
        return players.get(activeLeader);
    }
}
