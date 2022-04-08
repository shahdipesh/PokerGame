import java.util.ArrayList;

public class State6 extends GameState {
    public State6(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> playState() {
        ArrayList<String> messages = new ArrayList<String>();//list of messages to be displayed

        messages.add("Click on Proceed to play a new game!");//display message
        messages.add(null);
        messages.add(null);
        messages.add(null);


        getGL().getDeck().shuffle();//shuffle the deck
        getGL().getDeck().returnToDeck(getGL().getHumanHand().returnCards());//return human hand to deck
        getGL().getDeck().returnToDeck(getGL().getCPUHand().returnCards()); //return CPU hand to deck
        getGL().getDeck().shuffle();//shuffle the deck
        getGL().getCPUHand().draw(getGL().getDeck(), false);//draw a card for the CPU
        getGL().getHumanHand().draw(getGL().getDeck(), false);//draw a card for the human
        return messages;//return the messages
    }

    public GameState goToNextState() {
        return new State1(getGL());
    }

}
