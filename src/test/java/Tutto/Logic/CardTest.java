package Tutto.Logic;

import Tutto.Deck.Card;
import Tutto.Deck.Rank;
import org.junit.jupiter.api.Test;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
	private static final Random PRNG = new Random();

	public static Rank randomRank()  {
        Rank[] rank = Rank.values();
        return rank[PRNG.nextInt(rank.length)];
    }
	
	public static Boolean checkRank(Card c)  {
        for (Rank r : Rank.values()) {
        	if (r == c.getRank()) {
        		return true;
        	}
        }
        return false;
    }
	
    Card card = new Card(randomRank());

    @Test
    void checkRankClass() {

    	assertEquals(card.getRank().getClass(), Rank.class);

    }
    @Test
    void checkRank() {
    	
    	assertTrue(checkRank(card));

    }

}