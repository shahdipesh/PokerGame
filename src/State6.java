import java.util.ArrayList;

public class State6 extends GameState {
    public State6(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> playState() {
        ArrayList<String> messages = new ArrayList<String>();

        messages.add("Click on Proceed to play a new game!");
        messages.add(null);
        messages.add(null);
        messages.add(null);

        getGL().setDeck(new Deck());
        getGL().getDeck().shuffle();
        getGL().getDeck().returnToDeck(getGL().getHumanHand().returnCards());
        getGL().getDeck().shuffle();
        getGL().getCPUHand().draw(getGL().getDeck(), false);
        getGL().getHumanHand().draw(getGL().getDeck(), false);
        return messages;
    }

    public GameState goToNextState() {
        return new State1(getGL());
    }

}
