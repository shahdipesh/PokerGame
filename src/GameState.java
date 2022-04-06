
// CLASS: GameState
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines the current state the game is in.
//
//-----------------------------------------
import java.util.ArrayList;

public abstract class GameState {
    private GameLogic gameLogic;

    //constructor
    //each state of a game has separate things to do
    public GameState(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public abstract ArrayList<String> getMessages();
    public abstract GameState getNextState();
    public abstract void performAction();

}
