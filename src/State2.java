import java.util.ArrayList;

public class State2 extends GameState {
    public State2(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<String>();

        messages.add(getGameLogic().getHumanPlayer().getName() + " has discarded cards.");
        messages.add(getGameLogic().getCpuPlayer().getName() + " is thinking...");

        return messages;
    }

    public GameState getNextState() {
        return null;
    }
}
