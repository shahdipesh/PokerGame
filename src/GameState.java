
// CLASS: GameState
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines the current state the game is in.
//
//-----------------------------------------
import java.util.ArrayList;

public abstract class GameState {
    private GameLogic gL;

    //constructor
    //each state of a game has separate things to do
    public GameState(GameLogic gL) {
        this.gL = gL;
    }

    public GameLogic getGL() {
        return gL;
    }

    public abstract ArrayList<String> playState();

    public abstract GameState goToNextState();

}
