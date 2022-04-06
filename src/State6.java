import java.util.ArrayList;

public class State6 extends GameState {
    public State6(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<String>();

        messages.add("Click on Proceed to play a new game!");
        return messages;
    }

    public GameState getNextState() {
        return null;
    }

}
