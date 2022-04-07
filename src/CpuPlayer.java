// CLASS: CpuPlayer
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines a CpuPlayer
//
//-----------------------------------------

public class CpuPlayer extends Player {

    public CpuPlayer() {
        super("Cpu");
    }

    //AI implementation for dumb cpu
    @Override
    public void discardCards() {
        if(getPlayerHand().evaluateHand().equals("Nothing")){
            ((Card)(getPlayerHand().getCard(0))).setSelected(true);
        }
        else if(getPlayerHand().evaluateHand().equals("Pair")){
            ((Card)(getPlayerHand().getCard(0))).setSelected(true);
        }
    }
}
