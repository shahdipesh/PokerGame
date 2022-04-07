import java.util.ArrayList;
import java.util.Collections;

public class HandLogic {

    //check for flush
    public int isFlush(ArrayList<Cardable> hand) {
        Collections.sort(hand, new SortBySuit());
        if (((Card) hand.get(0)).getSuit() == ((Card) hand.get(hand.size() - 1)).getSuit()) {
            return ((Card) hand.get(hand.size() - 1)).getValue();
        } else {
            return -1;
        }
    }

    //check for isStraightFlush
    public int isStraightFlush(ArrayList<Cardable> hand) {
        Collections.sort(hand, new SortBySuit());
        if (this.isFlush(hand) != -1 && isStraight(hand) != -1) {
            return ((Card) hand.get(hand.size() - 1)).getValue();
        } else {
            return -1;
        }
    }

    //check for isStraight
    public int isStraight(ArrayList<Cardable> hand) {
        int i, testRank;
        Collections.sort(hand, new SortByValue());
        boolean result;
       //check for ace in straight
        if (((Card) hand.get(4)).getValue() == 14) {
          
           // Check straight in case of Ace
 
            boolean firstPass = ((Card) hand.get(0)).getValue() == 2 && ((Card) hand.get(1)).getValue() == 3 &&
                    ((Card) hand.get(2)).getValue() == 4 && ((Card) hand.get(3)).getValue() == 5;
            boolean secondPass = ((Card) hand.get(0)).getValue() == 10 && ((Card) hand.get(1)).getValue() == 11 &&
                    ((Card) hand.get(2)).getValue() == 12 && ((Card) hand.get(3)).getValue() == 13;

            result = firstPass || secondPass;
            if (result) {
                return ((Card) hand.get(hand.size() - 1)).getValue();
            } else {
                return -1;
            }
        } else {
            
            testRank = ((Card) hand.get(0)).getValue() + 1;

            for (i = 1; i < 5; i++) {
                if (((Card) hand.get(i)).getValue() != testRank)
                    return -1; 

                testRank++; 
            }

            return ((Card) hand.get(hand.size() - 1)).getValue(); 
        }
    }

    //check for isFourOfAKind
    public int isFourOfAKind(ArrayList<Cardable> h) {

        Collections.sort(h, new SortByValue());
        boolean result;
         //4 cards with same value +highervalue unmatched card
             
       
        boolean a1 = ((Card) h.get(0)).getValue() == ((Card) h.get(1)).getValue() &&
                ((Card) h.get(1)).getValue() == ((Card) h.get(2)).getValue() &&
                ((Card) h.get(2)).getValue() == ((Card) h.get(3)).getValue();

  //check lower rank card
        boolean a2 = ((Card) h.get(1)).getValue() == ((Card) h.get(2)).getValue() &&
                ((Card) h.get(2)).getValue() == ((Card) h.get(3)).getValue() &&
                ((Card) h.get(3)).getValue() == ((Card) h.get(4)).getValue();

        result = a1 || a2;
        if (result) {
            return ((Card) h.get(h.size() - 1)).getValue();
        } else {
            return -1;
        }
    }

    //check for isFullHouse
    public int isFullHouse(ArrayList<Cardable> h) {

        Collections.sort(h, new SortByValue());
        boolean result;
        //3 cards with same value + 2 cards with same value
        boolean threeOfAKind = ((Card) h.get(0)).getValue() == ((Card) h.get(1)).getValue() &&
                ((Card) h.get(1)).getValue() == ((Card) h.get(2)).getValue() &&
                ((Card) h.get(3)).getValue() == ((Card) h.get(4)).getValue();

     //2 cards with same value + 3 cards with same value
        boolean twoOfAkind = ((Card) h.get(0)).getValue() == ((Card) h.get(1)).getValue() &&
                ((Card) h.get(2)).getValue() == ((Card) h.get(3)).getValue() &&
                ((Card) h.get(3)).getValue() == ((Card) h.get(4)).getValue();

        result = (threeOfAKind || twoOfAkind);
        if (result) {
            return ((Card) h.get(h.size() - 1)).getValue();
        } else {
            return -1;
        }
    }

    //check for isThreeOfAKind
    public int isThreeOfAKind(ArrayList<Cardable> h) {

        Collections.sort(h, new SortByValue());
        boolean result;
       //3 cards with same value + 2 cards with same value
        boolean firstCase = ((Card) h.get(0)).getValue() == ((Card) h.get(1)).getValue() &&
                ((Card) h.get(1)).getValue() == ((Card) h.get(2)).getValue() &&
                ((Card) h.get(3)).getValue() != ((Card) h.get(0)).getValue() &&
                ((Card) h.get(4)).getValue() != ((Card) h.get(0)).getValue() &&
                ((Card) h.get(3)).getValue() != ((Card) h.get(4)).getValue();

   //2 cards with same value + 3 cards with same value
        boolean secondCase = ((Card) h.get(1)).getValue() == ((Card) h.get(2)).getValue() &&
                ((Card) h.get(2)).getValue() == ((Card) h.get(3)).getValue() &&
                ((Card) h.get(0)).getValue() != ((Card) h.get(1)).getValue() &&
                ((Card) h.get(4)).getValue() != ((Card) h.get(1)).getValue() &&
                ((Card) h.get(0)).getValue() != ((Card) h.get(4)).getValue();

    //2 cards with same value + 3 cards with same value
        boolean thirdCase = ((Card) h.get(2)).getValue() == ((Card) h.get(3)).getValue() &&
                ((Card) h.get(3)).getValue() == ((Card) h.get(4)).getValue() &&
                ((Card) h.get(0)).getValue() != ((Card) h.get(2)).getValue() &&
                ((Card) h.get(1)).getValue() != ((Card) h.get(2)).getValue() &&
                ((Card) h.get(0)).getValue() != ((Card) h.get(1)).getValue();

        result = (firstCase || secondCase || thirdCase);

        if (result) {
            return ((Card) h.get(h.size() - 1)).getValue();
        } else {
            return -1;
        }

    }

    //check for isTwoPair
    public int isTwoPair(ArrayList<Cardable> h) {
        boolean a1, a2, a3;
        Collections.sort(h, new SortByValue());

        boolean result;
        if (isFourOfAKind(h) != -1 || isFullHouse(h) != -1 || isThreeOfAKind(h) != -1) {
            return -1;
        }

      //2 cards with same value + 3 cards with same value first case
        boolean case1 = ((Card) h.get(0)).getValue() == ((Card) h.get(1)).getValue() &&
                ((Card) h.get(2)).getValue() == ((Card) h.get(3)).getValue();

        //2 cards with same value + 3 cards with same value second case
        boolean case2 = ((Card) h.get(0)).getValue() == ((Card) h.get(1)).getValue() &&
                ((Card) h.get(3)).getValue() == ((Card) h.get(4)).getValue();

      //2 cards with same value + 3 cards with same value third case
        boolean case3 = ((Card) h.get(1)).getValue() == ((Card) h.get(2)).getValue() &&
                ((Card) h.get(3)).getValue() == ((Card) h.get(4)).getValue();

        result = (case1 || case2 || case3);

        if (result) {
            return ((Card) h.get(h.size() - 1)).getValue();
        } else {
            return -1;
        }

    }

    //check if hand is a one pair
    public int isaPair( ArrayList<Cardable> h )
    {

        boolean result;
        if ( isFourOfAKind(h)!=-1 || isFullHouse(h)!=-1 || isThreeOfAKind(h)!=-1 || isTwoPair(h)!=-1 ) {
            return -1;        //if hand is a four of a kind, full house, three of a kind or two pair, return -1
        }

        Collections.sort(h, new SortByValue());


         //2 card with same value and 3 with different value 1st case
        boolean case1 = ((Card) h.get(0)).getValue() == ((Card) h.get(1)).getValue() ;

   //2 card with same value and 3 with different value 2nd case
        boolean case2 = ((Card) h.get(1)).getValue() == ((Card) h.get(2)).getValue() ;

    // 2 card with same value and 3 with different value 3rd case
        boolean case3 = ((Card) h.get(2)).getValue() == ((Card) h.get(3)).getValue() ;

//2 card with same value and 3 with different value 4th case
        boolean case4 = ((Card) h.get(3)).getValue() == ((Card) h.get(4)).getValue();

        result = case1 || case2 || case3 || case4;
        if (result) {
            return ((Card) h.get(h.size() - 1)).getValue();
        } else {
            return -1;
        }
    }

}
