import java.util.ArrayList;
import java.util.LinkedList;

public class Deck implements Deckable{
    ArrayList<Cardable> deck;

    public Deck() {
        deck = new ArrayList<Cardable>();
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

    @Override
    public void shuffle() {
        int min = 0;
        int max = 1;
        for(int i=0;i<deck.size();i++){
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            if(random_int==1){
                deck.add(deck.remove(i));
            }
        }
    }

    @Override
    public void returnToDeck(LinkedList<Cardable> discarded) {
        deck.addAll(discarded);
    }

    @Override
    public Cardable drawACard(boolean faceUp) {
        Card cardToPull = (Card) deck.remove(deck.size()-1);
        cardToPull.setFaceUp(faceUp);
        return cardToPull;
    }
}
