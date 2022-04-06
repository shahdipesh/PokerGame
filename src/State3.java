import java.util.ArrayList;

public class State3 extends GameState {
    public State3(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<String>();

        messages.add(getGameLogic().getCpuPlayer().getName() + " has discarded cards.");
        messages.add("Each player will be dealt the same number of cards they discarded.");

        return messages;
    }

    public GameState getNextState() {
        return null;
    }
}
