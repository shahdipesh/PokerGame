
// CLASS: State2
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines the second stage of the game
//
//-----------------------------------------
import java.util.ArrayList;
import java.util.LinkedList;

public class State2 extends GameState {
    public State2(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> playState() {
        ArrayList<String> messages = new ArrayList<String>();
        LinkedList<Cardable> discarded = getGL().getHumanHand().discard();
        getGL().getDiscardedCards().addAll(discarded);

        messages.add(getGL().getHumanPlayer().getName() + " has discarded cards.");
        messages.add(getGL().getCpuPlayer().getName() + " is thinking...");
        messages.add(null);
        messages.add(null);
        return messages;
    }

    public GameState goToNextState() {
        return new State3(getGL());
    }
}
