import java.util.ArrayList;

public class State5 extends GameState {
    private Player winner;
    private String bestHumanHand;
    private String bestCpuHand;

    public State5(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<String>();
        Player cpuPlayer = getGameLogic().getCpuPlayer();
        Player humanPlayer = getGameLogic().getHumanPlayer();

        messages.add(cpuPlayer.getName() + " has: " + bestCpuHand);
        messages.add(humanPlayer.getName() + " has: " + bestHumanHand);
        messages.add(winner.getName() + " wins!");
        messages.add(humanPlayer.getName() + " has won " + humanPlayer.getWins() + " games. " + cpuPlayer.getName()
                + " has won " + cpuPlayer.getWins() + " games.");

        return messages;
    }

    public void performAction() {
        getGameLogic().getCPUHand().showAllCards();

        int compareHands = getGameLogic().getHumanHand().compareTo(getGameLogic().getCPUHand());

        if (compareHands > 0) {
            winner = getGameLogic().getHumanPlayer();
        } else if (compareHands < 0) {
            winner = getGameLogic().getCpuPlayer();
        } else {
            winner = null;
        }
    }

    public GameState getNextState() {
        return new State6(getGameLogic());
    }
}
