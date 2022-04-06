import java.util.ArrayList;

public class State1 extends GameState {
    public State1(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<String>();

        messages.add("Beginning of Game " + getGameLogic().getGameNumber());
        messages.add(getGameLogic().getHumanPlayer().getName() + ", choose which cards to discard");
        messages.add("and click on the Proceed button.");
        messages.add(null);
        return messages;
    }

    public void performAction() {
        getGameLogic().increamentGameNumber();
        getGameLogic().getHumanHand().showAllCards();
    }

    public GameState getNextState() {
        return new State2(getGameLogic());
    }
}
