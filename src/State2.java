import java.util.ArrayList;

public class State2 extends GameState {
    public State2(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<String>();

        messages.add(getGameLogic().getHumanPlayer().getName() + " has discarded cards.");
        messages.add(getGameLogic().getCpuPlayer().getName() + " is thinking...");
        messages.add(null);
        messages.add(null);
        return messages;
    }
    public void performAction() {
        getGameLogic().getDiscardedCards().addAll(getGameLogic().getHumanHand().discard());
    }

    public GameState getNextState() {
        return new State3(getGameLogic());
    }
}
