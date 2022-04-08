// CLASS: CpuPlayer
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines a CpuPlayer
//
//-----------------------------------------

import java.util.ArrayList;

public class GoodCpuPlayer extends Player {

    public GoodCpuPlayer() {
        super("Cpu");
    }

    //AI implementation for Good cpu
    @Override
    public void discardCards() {
        String result = getPlayerHand().evaluateHand().split(" ")[0];
        ArrayList<String> goodHands = new ArrayList<String>();
        goodHands.add("StraightFlush");
        goodHands.add("FourOfAKind");
        goodHands.add("FullHouse");
        goodHands.add("Flush");


        //if the card contains nothing then select all the cards
        if (result.equals("Nothing")) {
           //loop through all the cards and select them
            for (int i = 0; i < getPlayerHand().getHand().size(); i++) {
                ((Card)(getPlayerHand().getHand().get(i))).setSelected(true);
            }
        }
        if(result.equals("Nothing")){
            ((Card)(getPlayerHand().getCard(0))).setSelected(true);
        }
        else if(result.equals("Pair")){ //discard the lowest card so that there is higher chance of winning
            ((Card)(getPlayerHand().getCard(0))).setSelected(true);
        }
        else{
            //do nothing we have a descent card
        }


    }
}
