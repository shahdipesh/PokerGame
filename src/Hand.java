import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Hand implements Handable{

    ArrayList<Cardable> hand;

    public Hand() {
        hand = new ArrayList<Cardable>(Handable.HAND_SIZE);
    }

    @Override
    public Cardable getCard(int i) {
        if(hand.size()>i) {
            return hand.get(i);
        }
        else{
            return null;
        }
    }

    /////////is this correct/////
    @Override
    public void draw(Deckable d, boolean faceUp) {
        for(int i=0;i<Handable.HAND_SIZE;i++){
            if(this.hand.get(i)==null) {
                Cardable cardToAdd = d.drawACard(faceUp);
                this.hand.add(cardToAdd);
            }
        }
    }

    @Override
    public void showAllCards() {
        for(int i=0;i<hand.size();i++){
            hand.get(i).setFaceUp(true);
        }
    }

    //should it go over arraylist of hands and remove the cards that has selected ==true
    @Override
    public LinkedList<Cardable> discard() {
        LinkedList<Cardable> toDiscard = new LinkedList<Cardable>();
        for (int i=0;i<hand.size();i++){
            if(((Card)(hand.get(i))).getSelected()) {
                toDiscard.add((hand.remove(i)));
            }
        }
        return toDiscard;
    }

    //should delete from hand?
    //should change the faceUp to down?
    @Override
    public LinkedList<Cardable> returnCards() {
        LinkedList<Cardable> cardList = new LinkedList<Cardable>();
        for (int i=0;i<hand.size();i++){
                cardList.add((hand.remove(i)));

        }
        return cardList;
    }

    @Override
    public String evaluateHand() {
        HandLogic handLogic = new HandLogic();
        if(handLogic.isStraightFlush(this.hand)){
            return "Straight Flush,";
        }
        else if (handLogic.isFourOfAKind(this.hand)){
            return "Four of a kind";
        }
        else if (handLogic.isFullHouse(this.hand)){
            return "Full house";
        }
        else if (handLogic.isFlush(this.hand)){
            return "Flush";
        }
        else if (handLogic.isStraight(this.hand)){
            return "Straight";
        }
        else if (handLogic.isThreeOfAKind(this.hand)){
            return "ThreeOfAKind";
        }
        else if (handLogic.isAPair(this.hand)){
            return "A pair";
        }
        else{
            return "Nothing";
        }
    }


    @Override
    public int compareTo(Handable o) {

        return -1;
    }

    public ArrayList<Cardable> getHand() {
        return hand;
    }

    public void addCardToHand(Card c){
        this.hand.add(c);
    }

}
