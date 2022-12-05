package Tutto.Logic;

import Tutto.Deck.Card;
import Tutto.Deck.Deck;
import Tutto.Deck.Rank;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    Deck deck = new Deck();


    @Test
    void checkNotEmpty() {
        assertFalse(deck.isEmpty());

    }

    @Test
    void checkEmpty() {
    	int i = 0;
    	while ((!deck.isEmpty()) && i <=56) {
    		deck.pullRandom();
    		i++;
    	}
        assertTrue(deck.isEmpty());

    }

    @Test
    void checkSize() {
    	int i = 0;
    	while ((!deck.isEmpty()) && i <=60) {
    		deck.pullRandom();
    		i++;
    	}
        assertTrue(i==56);

    }    
    
    @Test
    void checkCardTypes() {
    	int i = 0;
    	int i1  = 0;
    	int i2  = 0;
    	int i3  = 0;
    	int i4  = 0;
    	int i5  = 0;
    	int i6  = 0;
    	int i7  = 0;
    	int i8  = 0;
    	int i9  = 0;
    	int i10 = 0;
    	while ((deck.isEmpty()==false) && i <=56) {
    		Card temp = deck.pullRandom();
    		switch (temp.getRank().ordinal()) {
			case 1 :  i1 ++; break;
			case 2 :  i2 ++; break;
			case 3 :  i3 ++; break;
			case 4 :  i4 ++; break;
			case 5 :  i5 ++; break;
			case 6 :  i6 ++; break;
			case 7 :  i7 ++; break;
			case 8 :  i8 ++; break;
			case 9 :  i9 ++; break;
			case 10:  i10++; break;
    		}
    		i++;
    	};
        assertTrue(i1 == 5 && i2 == 5 && i3 == 5 && i4 == 5 && i5 == 5 && i6 == 10 && i7 == 5 && i8 == 5 && i9 == 1 && i10 == 5 );


    }

    @Test
    void checkPullRandom() {
    	Card testCard = new Card(Rank.STOP);
        Card card = deck.pullRandom();
        assertEquals(card.getClass(), testCard.getClass());

    }
}