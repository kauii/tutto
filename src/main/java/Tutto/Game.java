package Tutto;

import Tutto.Logic.*;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    private final ArrayList<Player> players = new ArrayList<>();
    private final Deck deck;
    Input in = new Input();
    private final int playerAmount;
    private final int targetScore;

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
        boolean lastRound = false;
        boolean gameEnd = false;
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
                in.enterContinue();
            }

            // Play -> draw card -> play round
            // Try to draw card from deck
            card = drawCard();

            // Play 1st round
            cLogic = new CardLogic();
            cLogic.checkCard(card);

            // Save points
            points = cLogic.getScore();

            //If tutto, decide stop or continue
            while (cLogic.getTutto() && !card.equals(new Card(Rank.CLOVERLEAF)) && !card.equals(new Card(Rank.PLUSMINUS)) && !card.equals(new Card(Rank.FIREWORKS))) {

                // Ask player if he wants to continue
                if (in.getContinue()) {
                    card = drawCard();
                    cLogic.setScore(points); // old points
                    cLogic.checkCard(card);
                    if (cLogic.getScore() == 0) {
                        points = 0;
                    } else {
                        points = cLogic.getScore();
                    }
                } else { // If Player s
                    break;
                }
            }

            // Check if PlusMinus and if player won
            if (card.equals(new Card(Rank.PLUSMINUS)) && points != 0) {
                // Find player with the highest score
                leader = findLeader();
                // If player with the highest score != active player -> subtract 1000 points
                if (!Objects.equals(findLeader(), players.get(activePlayer)) && findLeader() != null) {
                    assert leader != null;
                    leader.addScore(-1000);
                }
            }

            // Depending on card: directly won, add points, subtract points
            players.get(activePlayer).addScore(points);

            // Check if activePlayer has enough points and there is no winner yet
            if (players.get(activePlayer).getScore() >= targetScore && !lastRound) {
                lastRound = true;

                if (activePlayer < playerAmount) {       // If round is not over yet
                    System.out.println();
                    System.out.println("############################################\n");
                    System.out.println(players.get(activePlayer).getName() + " reached " + targetScore + " points!\nLast round!!");
                }
            }

            // int active player gets reset when >= playerAmount (NEW ROUND BEGINS)
            activePlayer++;
            if (activePlayer >= playerAmount && !lastRound) {
                activePlayer = 0;
            }

            // int active player doesn't get reset (FINISH LAST ROUND)
            if (activePlayer >= playerAmount && lastRound) {
                gameEnd = true;
            }

        } while (!gameEnd);

        // PRINT WINNER MESSAGE
        leader = findLeader();
        System.out.println();
        System.out.println("############################################");
        assert leader != null;
        System.out.println(leader.getName() + " won!!!");
        printer.printScoreboard(players);

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

    private Card drawCard() {
        Card card;
        try {
            card = deck.pullRandom();
        } catch (IllegalStateException exception) {
            System.out.println("Pile is empty. Deck is reshuffled!");
            deck.reset();
            card = deck.pullRandom();
        }
        return card;
    }
}
