package Tutto;

public class Player {
    private final String name;
    private int score = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        if (points > 0 || score >= (points * -1)) {
            score += points;
        } else {
            score = 0;
        }
    }
}
