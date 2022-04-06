import java.util.ArrayList;

public class GameLogic implements GameLogicable{

    private GameState currentState;
    private int gameNumber;
    private Player cpuPlayer;
    private Player humanPlayer;

    public GameLogic() {
        gameNumber = 1;
        currentState = null;
        cpuPlayer = new DumbCpuPlayer();
        humanPlayer = new HumanPlayer("Player 1");
    }

    @Override
    public boolean nextState(String[] messages) {
        if (currentState == null) {
            currentState = new State1(this);
        } else {
            currentState = currentState.getNextState();
        }

        ArrayList<String> msgToDisplay = currentState.getMessages();

        for (int i = 0; i < messages.length; i++) {
            if (i < msgToDisplay.size()) {
                messages[i] = msgToDisplay.get(i);
            } else {
                messages[i] = null;
            }
        }

        return true;
    }

    @Override
    public Handable getCPUHand() {
        return cpuPlayer.getHand();
    }

    @Override
    public Handable getHumanHand() {
        return humanPlayer.getHand();
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public Player getCpuPlayer() {
        return cpuPlayer;
    }

    public void setCpuPlayer(Player cpuPlayer) {
        this.cpuPlayer = cpuPlayer;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public void setHumanPlayer(Player humanPlayer) {
        this.humanPlayer = humanPlayer;
    }


}
