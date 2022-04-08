// CLASS: State5
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines the fifth stage of the game
//
//-----------------------------------------
import java.util.ArrayList;

public class State5 extends GameState {
    private Player winner;//winner of the game

    public State5(GameLogic gameLogic) {
        super(gameLogic);
    }

    public ArrayList<String> playState() {
        ArrayList<String> messages = new ArrayList<String>();
        Player cpuPlayer = getGL().getCpuPlayer();
        Player humanPlayer = getGL().getHumanPlayer();

        getGL().getCPUHand().showAllCards();//show all cards

        String humanHand = getGL().getHumanHand().evaluateHand();//evaluate human hand
        String cpuHand = getGL().getCPUHand().evaluateHand();

        messages.add(cpuPlayer.getName() + " has: " + cpuHand);
        messages.add(humanPlayer.getName() + " has: " + humanHand);

        int compareHands = getGL().getHumanHand().compareTo(getGL().getCPUHand());//compare hands

        if (compareHands > 0) {
            winner = getGL().getHumanPlayer();//human player wins
            getGL().getHumanPlayer().setWins(getGL().getHumanPlayer().getWins() + 1);//increment human player wins
            messages.add(winner.getName() + " wins!");//print winner
        } else if (compareHands < 0) {//cpu player wins
            winner = getGL().getCpuPlayer();
            //increment cpu wins
            getGL().getCpuPlayer().setWins(getGL().getCpuPlayer().getWins() + 1);
            messages.add(winner.getName() + " wins!");//print winner
        } else {
            winner = null;
            messages.add("It's a tie!");
        }

        messages.add(humanPlayer.getName() + " has won " + humanPlayer.getWins() + " games. " + cpuPlayer.getName()
                + " has won " + cpuPlayer.getWins() + " games.");

        return messages;
    }

    public GameState goToNextState() {
        return new State6(getGL());
    }//go to next state
}
