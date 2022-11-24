package Tutto.Logic;

public class Card {
    private Rank mRank;

    public Card(Rank rank) {
        this.mRank = rank;
    }
    
    public Rank getRank() {
        return mRank;
    }
    
    @Override
    public boolean equals(Object o) {
        return (o != null && o instanceof Card && ((Card) o).mRank == mRank);
    }

}


