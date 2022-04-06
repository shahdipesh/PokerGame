abstract class Player {
    private String name;
    private int wins;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        wins = 0;
        hand = new Hand();
    }
    public abstract void makeMove();

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public Hand getHand() {
        return hand;
    }

    public void win() {
        wins++;
    }
}
