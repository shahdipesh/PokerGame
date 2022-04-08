

// CLASS: State3
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines the third stage of the game
//
//-----------------------------------------
import java.util.ArrayList;

public class State3 extends GameState {
    public State3(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> playState() {
        ArrayList<String> messages = new ArrayList<String>();

        getGL().getCpuPlayer().discardCards();

        messages.add(getGL().getCpuPlayer().getName() + " has discarded cards.");
        messages.add("Each player will be dealt the same number of cards they discarded.");
        messages.add(null);
        messages.add(null);

        return messages;
    }

    public GameState goToNextState() {
        return new State4(getGL());
    }
}
