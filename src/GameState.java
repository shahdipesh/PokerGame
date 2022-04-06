import java.util.ArrayList;

public abstract class GameState {
    private GameLogic gameLogic;

    public GameState(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public GameLogic getGameLogic() {
        return gameLogic;
    }

    public abstract ArrayList<String> getMessages();

    public abstract GameState getNextState();

}
