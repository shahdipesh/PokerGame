import java.util.ArrayList;

public class State5 extends GameState {
    private Player winner;

    public State5(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> playState() {
        ArrayList<String> messages = new ArrayList<String>();
        Player cpuPlayer = getGL().getCpuPlayer();
        Player humanPlayer = getGL().getHumanPlayer();

        getGL().getCPUHand().showAllCards();

        String humanHand = getGL().getHumanHand().evaluateHand();
        String cpuHand = getGL().getCPUHand().evaluateHand();

        messages.add(cpuPlayer.getName() + " has: " + cpuHand);
        messages.add(humanPlayer.getName() + " has: " + humanHand);

        int compareHands = getGL().getHumanHand().compareTo(getGL().getCPUHand());

        if (compareHands > 0) {
            winner = getGL().getHumanPlayer();
            getGL().getHumanPlayer().setWins(getGL().getHumanPlayer().getWins() + 1);
            messages.add(winner.getName() + " wins!");
        } else if (compareHands < 0) {
            winner = getGL().getCpuPlayer();
            //increment cpu wins
            getGL().getCpuPlayer().setWins(getGL().getCpuPlayer().getWins() + 1);
            messages.add(winner.getName() + " wins!");
        } else {
            winner = null;
            messages.add("It's a tie!");
        }

        messages.add(humanPlayer.getName() + " has won " + humanPlayer.getWins() + " games. " + cpuPlayer.getName()
                + " has won " + cpuPlayer.getWins() + " games.");

        return messages;
    }

    public GameState goToNextState() {
        return new State6(getGL());
    }
}
