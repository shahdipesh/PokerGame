// CLASS: Deck
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines a Deck of cards
//
//-----------------------------------------

import java.util.ArrayList;
import java.util.LinkedList;

public class Deck implements Deckable{
    ArrayList<Cardable> deck;

    //constructor
    public Deck() {
        deck = new ArrayList<Cardable>();
        //each loop creates a suit of cards
        for (int i=2;i<=14;i++){
            Card card = new Card(i,Cardable.Suit.HEART);
            deck.add(card);
        }
        for (int i=2;i<=14;i++){
            Card card = new Card(i,Cardable.Suit.DIAMOND);
            deck.add(card);
        }
        for (int i=2;i<=14;i++){
            Card card = new Card(i,Cardable.Suit.SPADE);
            deck.add(card);
        }
        for (int i=2;i<=14;i++){
            Card card = new Card(i,Cardable.Suit.CLUB);
            deck.add(card);
        }
    }

    //------------------------------------------------------
    // shuffle
    //
    // PURPOSE:    Shuffle the deck of card
    //------------------------------------------------------
    @Override
    public void shuffle() {
        int min = 0;
        int max = 1;
        for(int i=0;i<deck.size();i++){
            //if the number is 1 we move the card to the back of the deck else make no changes to the position
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            if(random_int==1){
                deck.add(deck.remove(i));
            }
        }
    }

    //------------------------------------------------------
    // returnToDeck
    //
    // PURPOSE:    return the discarded cards to deck
    //------------------------------------------------------
    @Override
    public void returnToDeck(LinkedList<Cardable> discarded) {
        deck.addAll(discarded);
    }


    //------------------------------------------------------
    // drawACard
    // Returns: The card that is selected from deck
    // PURPOSE:   Draws a card from the deck and sets its facup property to the parameter passed
    //------------------------------------------------------
    @Override
    public Cardable drawACard(boolean faceUp) {
        Card cardToPull = (Card) deck.remove(deck.size()-1);
        cardToPull.setFaceUp(faceUp);
        return cardToPull;
    }
}
