import java.util.ArrayList;

public class State6 extends GameState {
    public State6(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<String>();

        messages.add("Click on Proceed to play a new game!");
        messages.add(null);
        messages.add(null);
        messages.add(null);
        return messages;
    }

    public void performAction() {
        getGameLogic().getDeck().returnToDeck(getGameLogic().getDiscardedCards());
        getGameLogic().getDeck().returnToDeck(getGameLogic().getCPUHand().returnCards());
        getGameLogic().getDeck().returnToDeck(getGameLogic().getHumanHand().returnCards());
        getGameLogic().getDeck().shuffle();
        getGameLogic().getCPUHand().draw(getGameLogic().getDeck(), false);
        getGameLogic().getHumanHand().draw(getGameLogic().getDeck(), false);
    }

    public GameState getNextState() {
        return new State1(getGameLogic());
    }

}
