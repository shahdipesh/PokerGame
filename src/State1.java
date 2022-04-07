import java.util.ArrayList;

public class State1 extends GameState {
    public State1(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> playState() {
        ArrayList<String> messages = new ArrayList<String>();

        getGL().increamentGameNumber();

        messages.add("Beginning of Game " + getGL().getGameNumber());
        messages.add(getGL().getHumanPlayer().getName() + ", choose which cards to discard");
        messages.add("and click on the Proceed button.");
        messages.add(null);

        getGL().getHumanHand().showAllCards();
        ((Hand)getGL().getCPUHand()).hideAllCards();
        return messages;
    }

    public GameState goToNextState() {
        return new State2(getGL());
    }
}
