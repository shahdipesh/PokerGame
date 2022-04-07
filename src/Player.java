abstract class Player {
    private String name;
    private int wins;
    private Hand playerHand;

    public Player(String name) {
        this.name = name;
        wins = 0;
        playerHand = new Hand();
    }

    public abstract void discardCards();

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public Hand getplayerHand() {
        return playerHand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    public void win() {
        wins++;
    }
}
