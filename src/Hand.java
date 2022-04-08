// CLASS: Hand
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines a Hand
//
//-----------------------------------------

import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;

public class Hand implements Handable,TestableHand {

    ArrayList<Cardable> hand;

    //constructor
    public Hand() {
        hand = new ArrayList<Cardable>();
        for (int i = 0; i < 5; i++) {
            hand.add(null);
        }
    }



    public void hideAllCards() {
        for (Cardable c : hand) {
            c.setFaceUp(false);
        }
    }

    @Override
    public Cardable getCard(int i) {
        if (hand.size() > i) {
            return hand.get(i);
        } else {
            return null;
        }
    }

    @Override
    public void draw(Deckable d, boolean faceUp) {
        for (int i = 0; i < Handable.HAND_SIZE; i++) {
            if (hand.size() > i && hand.get(i) == null) {
                Cardable cardToAdd = d.drawACard(faceUp);
                hand.set(i, cardToAdd);
            }

        }
    }

    @Override
    public void showAllCards() {
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).setFaceUp(true);
        }
    }

    @Override
    public LinkedList<Cardable> discard() {
        LinkedList<Cardable> toDiscard = new LinkedList<Cardable>();
        for (int i = 0; i < hand.size(); i++) {
            if (((Card) (hand.get(i))).getSelected()) {
                hand.set(i, null);
                toDiscard.add((hand.get(i)));
            }
        }
        return toDiscard;
    }

    @Override
    public LinkedList<Cardable> returnCards() {
        LinkedList<Cardable> cardList = new LinkedList<Cardable>();
        for (int i = 0; i < hand.size(); i++) {
            cardList.add(hand.get(i));
            hand.set(i, null);
        }
        return cardList;
    }

    @Override
    public String evaluateHand() {
        HandLogic handLogic = new HandLogic();
        int highCard;
        if ((highCard = handLogic.isStraightFlush(this.hand)) != -1) {
            return "StraightFlush " + highCard;
        } else if ((highCard = handLogic.isFourOfAKind(this.hand)) != -1) {
            return "FourOfAKind " + highCard;
        } else if ((highCard = handLogic.isFullHouse(this.hand)) != -1) {
            return "FullHouse " + highCard;
        } else if ((highCard = handLogic.isFlush(this.hand)) != -1) {
            return "Flush " + highCard;
        } else if ((highCard = handLogic.isStraight(this.hand)) != -1) {
            return "Straight " + highCard;
        } else if ((highCard = handLogic.isThreeOfAKind(this.hand)) != -1) {
            return "ThreeOfAKind " + highCard;
        } else if ((highCard = handLogic.isTwoPair(this.hand)) != -1) {
            return "TwoPair " + highCard;
        }
        else if ((highCard = handLogic.isaPair(this.hand)) != -1) {
            return "Pair " + highCard;
        }
        else {
            Collections.sort(this.hand, new SortByValue());
            return "Nothing " + ((Card) hand.get(hand.size() - 1)).getValue();
        }
    }

    @Override
    public int compareTo(Handable o) {
        ArrayList<String> table = new ArrayList<String>();
        table.add("StraightFlush");
        table.add("FourOfAKind");
        table.add("FullHouse");
        table.add("Flush");
        table.add("Straight");
        table.add("ThreeOfAKind");
        table.add("TwoPair");
        table.add("Pair");
        table.add("Nothing");

        String str1 = this.evaluateHand();
        String str2 = o.evaluateHand();

        int index1 = table.indexOf(str1.split(" ")[0]);
        int index2 = table.indexOf(str2.split(" ")[0]);
        if (index1 < index2) {
            return 1;
        } else if (index1 > index2) {
            return -1;
        } else {
           //compare the index of the value. Lowest value means highest rank
            if (Integer.parseInt(str1.split(" ")[1]) > Integer.parseInt(str2.split(" ")[1])) {
                return 1;
            } else if (Integer.parseInt(str1.split(" ")[1]) < Integer.parseInt(str2.split(" ")[1])) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    public ArrayList<Cardable> getHand() {
        return hand;
    }

    //add card to hand
    public void addCardToHand(Cardable c) {
        boolean found = false;
        for (int i = 0; i < Handable.HAND_SIZE && !found; i++) {
            if (hand.get(i) == null) {
                hand.set(i, c);
                found = true;
            }
        }
    }

    @Override
    public void addCards(Cardable[] cards) {
        for (int i = 0; i < cards.length; i++) {
           hand.set(i, cards[i]);
        }
    }
}
