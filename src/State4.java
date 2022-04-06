import java.util.ArrayList;

public class State4 extends GameState {
    public State4(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> getMessages() {
        ArrayList<String> messages = new ArrayList<String>();

        messages.add("Each player has been dealt new cards.");
        messages.add("Click on Proceed to see the winner!");
        messages.add(null);
        messages.add(null);

        return messages;
    }

    public void performAction() {
        getGameLogic().getCPUHand().draw(getGameLogic().getDeck(), false);
        getGameLogic().getHumanHand().draw(getGameLogic().getDeck(), true);
    }

    public GameState getNextState(){
        return new State5(getGameLogic());
    }
}
