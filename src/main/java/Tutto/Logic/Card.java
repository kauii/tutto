package Tutto.Logic;

import java.util.Objects;

public class Card {
    private final Rank mRank;

    public Card(Rank rank) {
        this.mRank = rank;
    }
    
    public Rank getRank() {
        return mRank;
    }
    
    @Override
    public boolean equals(Object o) {
        return (o instanceof Card && ((Card) o).mRank == mRank);
    }

    @Override
    public int hashCode(){
        return Objects.hash(mRank);
    }

}


