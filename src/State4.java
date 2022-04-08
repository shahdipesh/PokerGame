// CLASS: State4
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines the fourth stage of the game
//
//-----------------------------------------
import java.util.ArrayList;

public class State4 extends GameState {
    public State4(GameLogic gameLogic) {
        super(gameLogic);
    }// State4

    public ArrayList<String> playState() {
        ArrayList<String> messages = new ArrayList<String>();

        getGL().getCPUHand().draw(getGL().getDeck(), false);//draws the cpu hand
        getGL().getHumanHand().draw(getGL().getDeck(), true);//draws the human hand
        messages.add("Each player has been dealt new cards.");//adds the message to the arraylist
        messages.add("Click on Proceed to see the winner!");//adds the message to the arraylist
        messages.add(null);
        messages.add(null);

        return messages;
    }

    public GameState goToNextState() {
        return new State5(getGL());
    }
}
