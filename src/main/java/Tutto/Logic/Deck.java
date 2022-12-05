package Tutto.Logic;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private final ArrayList<Card> mCards;
    private ArrayList<Card> mPulledCards;


    public Deck() {
        mPulledCards = new ArrayList<>();
        mCards = new ArrayList<>();
        reset();
    }

    public void reset() {
        mPulledCards.clear();
        mCards.clear();
        /* Creating all possible cards... */
        for (Rank r : Rank.values()) {
            if (r == Rank.CLOVERLEAF) {
                Card c = new Card(r);
                mCards.add(c);
            } else if (r == Rank.STOP) {
                for (int i = 0; i <= 9; i++) {
                    Card c = new Card(r);
                    mCards.add(c);
                }
            } else {
                for (int i = 0; i <= 4; i++) {
                    Card c = new Card(r);
                    mCards.add(c);
                }
            }
        }
    }


    /**
     * get a random card, removing it from the pack
     */
    public Card pullRandom() {
        if (mCards.isEmpty())
            throw new IllegalStateException();
        Random randint = new Random();
        Card res;
        if (mCards.size() == 1) {
            res = mCards.remove(0);
        } else {
            res = mCards.remove(randint.nextInt(mCards.size() - 1));
        }
        if (res != null)
            mPulledCards.add(res);
        return res;
    }

    /**
     * Get a random cards, leaves it inside the pack
     */
    public Card getRandom() {
        Card res;
        if (mCards.isEmpty()) {
            throw new IllegalStateException();
        }
        Random randint = new Random();
        if (mCards.size() == 1) {
            res = mCards.remove(0);
        } else {
            res = mCards.remove(randint.nextInt(mCards.size() - 1));
        }
        return res;
    }


    public boolean isEmpty() {
        return mCards.isEmpty();
    }
}
