// CLASS: GameLogic
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines the GameLogic to be implemented at different stages of game
//
//-----------------------------------------

import java.util.ArrayList;
import java.util.LinkedList;

public class GameLogic implements GameLogicable {

    private GameState currentState;
    private int numGames;
    private Player cpuPlayer;
    private Player humanPlayer;
    private Deck deck;
    private LinkedList<Cardable> discardedCards;

    //constructor
    public GameLogic() {
        discardedCards = new LinkedList<Cardable>();
        numGames = 0;
        currentState = new State1(this);
        deck = new Deck();
        cpuPlayer = new DumbCpuPlayer();
        humanPlayer = new HumanPlayer("Player 1");
        deck.shuffle();
        getCPUHand().draw(deck, false);
        getHumanHand().draw(deck, false);
    }

    //The GUI will call this method to proceed to the next stage/state of the game. The String[] parameter is an empty array, which the method can fill up with messages that will be displayed in the GUI to describe the current state of the game. The size of this array is determined by the number of lines that can be displayed in the GUI, and this is stored in PokerTableDisplay.NUM_MESSAGE_ROWS. It is set to 4 for this assignment (4 lines max). Leaves empty rows (where nothing should be displayed) to null.
    //The method returns a boolean that indicates if the proceed button in the GUI should be enabled (return true) or not (return false). This was done to get more flexibility in the GUI, but is not really useful currently. You can just return true all the time.
    @Override
    public boolean nextState(String[] messages) {
        ArrayList<String> msgToDisplay = currentState.playState();

        for (int i = 0; i < messages.length; i++) {
            messages[i] = msgToDisplay.get(i);
        }

        currentState = currentState.goToNextState();

        return true;
    }

    @Override
    public Handable getCPUHand() {
        return cpuPlayer.getplayerHand();
    }

    @Override
    public Handable getHumanHand() {
        return humanPlayer.getplayerHand();
    }

    //increament the number of games played
    public void increamentGameNumber() {
        numGames++;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public int getGameNumber() {
        return numGames;
    }

    public void setGameNumber(int gameNumber) {
        this.numGames = gameNumber;
    }

    public Player getCpuPlayer() {
        return cpuPlayer;
    }

    public void setCpuPlayer(Player cpuPlayer) {
        this.cpuPlayer = cpuPlayer;
    }

    public Player getHumanPlayer() {
        return humanPlayer;
    }

    public void setHumanPlayer(Player humanPlayer) {
        this.humanPlayer = humanPlayer;
    }

    public int getNumGames() {
        return numGames;
    }

    public void setNumGames(int numGames) {
        this.numGames = numGames;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public LinkedList<Cardable> getDiscardedCards() {
        return discardedCards;
    }

    public void setDiscardedCards(LinkedList<Cardable> discardedCards) {
        this.discardedCards = discardedCards;
    }
}
