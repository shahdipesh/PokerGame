import java.util.ArrayList;
import java.util.Collections;

public  class HandLogic {


    public int isFlush(ArrayList<Cardable> hand){
        Collections.sort(hand,new SortBySuit());
        if(((Card)hand.get(0)).getSuit()==((Card)hand.get(hand.size()-1)).getSuit()){
            return ((Card)hand.get(hand.size()-1)).getValue();
        }
        else{
            return -1;
        }
    }

        public int isStraightFlush(ArrayList<Cardable> hand){
        Collections.sort(hand,new SortBySuit());
        if(this.isFlush(hand)!=-1 && isStraight(hand)!=-1){
            return ((Card)hand.get(hand.size()-1)).getValue();
        }
        else{
            return -1;
        }
    }

    public  int isStraight( ArrayList<Cardable> h )
    {
        int i, testRank;
        Collections.sort(h,new SortByValue());
        boolean result;
      /* ===========================
         Check if hand has an Ace
         =========================== */
        if ( ((Card)h.get(4)).getValue() == 14 )
        {
         /* =================================
            Check straight using an Ace
            ================================= */
            boolean firstPass = ((Card)h.get(0)).getValue() == 2 && ((Card)h.get(1)).getValue() == 3 &&
                    ((Card)h.get(2)).getValue() == 4 && ((Card)h.get(3)).getValue() == 5 ;
            boolean secondPass = ((Card)h.get(0)).getValue() == 10 && ((Card)h.get(1)).getValue() == 11 &&
                    ((Card)h.get(2)).getValue() == 12 && ((Card)h.get(3)).getValue() == 13 ;

            result = firstPass || secondPass ;
            if(result){
                return ((Card)h.get(h.size()-1)).getValue();
            }
            else{
                return -1;
            }
        }
        else
        {
         /* ===========================================
            General case: check for increasing values
            =========================================== */
            testRank = ((Card)h.get(0)).getValue() + 1;

            for ( i = 1; i < 5; i++ )
            {
                if ( ((Card)h.get(i)).getValue() != testRank )
                    return -1;        // Straight failed...

                testRank++;   // Next card in hand
            }

              return ((Card)h.get(h.size()-1)).getValue();        // Straight found !
        }
    }

    public int isFourOfAKind(ArrayList<Cardable> h )
    {

        Collections.sort(h,new SortByValue());
        boolean result;
      /* ------------------------------------------------------
         Check for: 4 cards of the same rank
	            + higher ranked unmatched card
	 ------------------------------------------------------- */
        boolean a1 = ((Card)h.get(0)).getValue() == ((Card)h.get(1)).getValue() &&
                ((Card)h.get(1)).getValue() == ((Card)h.get(2)).getValue() &&
                ((Card)h.get(2)).getValue() == ((Card)h.get(3)).getValue() ;


      /* ------------------------------------------------------
         Check for: lower ranked unmatched card
	            + 4 cards of the same rank
	 ------------------------------------------------------- */
        boolean a2 = ((Card)h.get(1)).getValue() == ((Card)h.get(2)).getValue() &&
                ((Card)h.get(2)).getValue() == ((Card)h.get(3)).getValue() &&
                ((Card)h.get(3)).getValue() == ((Card)h.get(4)).getValue() ;

        result = a1 || a2 ;
        if(result){
            return ((Card)h.get(h.size()-1)).getValue();
        }
        else{
            return -1;
        }
    }

    public  int isFullHouse(ArrayList<Cardable> h )
    {

        Collections.sort(h,new SortByValue());
        boolean result;
      /* ------------------------------------------------------
         Check for: x x x y y
	 ------------------------------------------------------- */
        boolean threeOfAKind = ((Card)h.get(0)).getValue()== ((Card)h.get(1)).getValue() &&
                ((Card)h.get(1)).getValue()== ((Card)h.get(2)).getValue() &&
                ((Card)h.get(3)).getValue() == ((Card)h.get(4)).getValue();

      /* ------------------------------------------------------
         Check for: x x y y y
	 ------------------------------------------------------- */
        boolean twoOfAkind = ((Card)h.get(0)).getValue() ==((Card)h.get(1)).getValue() &&
                ((Card)h.get(2)).getValue() == ((Card)h.get(3)).getValue() &&
                ((Card)h.get(3)).getValue() == ((Card)h.get(4)).getValue();

        result =( threeOfAKind || twoOfAkind );
        if(result){
            return ((Card)h.get(h.size()-1)).getValue();
        }
        else{
            return -1;
        }
    }

    public  int isThreeOfAKind( ArrayList<Cardable> h )
    {

        Collections.sort(h,new SortByValue());
         boolean result;
      /* ------------------------------------------------------
         Check for: x x x a b
	 ------------------------------------------------------- */
        boolean firstCase =((Card)h.get(0)).getValue() == ((Card)h.get(1)).getValue() &&
                ((Card)h.get(1)).getValue() ==((Card)h.get(2)).getValue() &&
                ((Card)h.get(3)).getValue()!= ((Card)h.get(0)).getValue()&&
                ((Card)h.get(4)).getValue() != ((Card)h.get(0)).getValue() &&
                ((Card)h.get(3)).getValue() != ((Card)h.get(4)).getValue() ;

      /* ------------------------------------------------------
         Check for: a x x x b
	 ------------------------------------------------------- */
        boolean secondCase = ((Card)h.get(1)).getValue() == ((Card)h.get(2)).getValue()&&
                ((Card)h.get(2)).getValue() == ((Card)h.get(3)).getValue() &&
                ((Card)h.get(0)).getValue()!= ((Card)h.get(1)).getValue() &&
                ((Card)h.get(4)).getValue() != ((Card)h.get(1)).getValue()&&
                ((Card)h.get(0)).getValue()!= ((Card)h.get(4)).getValue() ;

      /* ------------------------------------------------------
         Check for: a b x x x
	 ------------------------------------------------------- */
        boolean thirdCase = ((Card)h.get(2)).getValue() ==((Card)h.get(3)).getValue() &&
                ((Card)h.get(3)).getValue()== ((Card)h.get(4)).getValue() &&
                ((Card)h.get(0)).getValue() != ((Card)h.get(2)).getValue() &&
                ((Card)h.get(1)).getValue() != ((Card)h.get(2)).getValue()&&
                ((Card)h.get(0)).getValue()!= ((Card)h.get(1)).getValue();

        result =( firstCase || secondCase || thirdCase );

        if(result){
            return ((Card)h.get(h.size()-1)).getValue();
        }
        else{
            return -1;
        }

    }

    public  int isAPair( ArrayList<Cardable> h )
    {
        boolean a1, a2, a3;
        Collections.sort(h,new SortByValue());

        boolean result;
        if ( isFourOfAKind(h)!=-1 || isFullHouse(h)!=-1 || isThreeOfAKind(h)!=-1 ) {
            return -1;
        }

      /* --------------------------------
         Checking: a a  b b x
	 -------------------------------- */
        a1 =  ((Card)h.get(0)).getValue() ==  ((Card)h.get(1)).getValue() &&
                ((Card)h.get(2)).getValue() ==  ((Card)h.get(3)).getValue();

      /* ------------------------------
         Checking: a a x  b b
	 ------------------------------ */
        a2 =  ((Card)h.get(0)).getValue()==  ((Card)h.get(1)).getValue() &&
                ((Card)h.get(3)).getValue() == ((Card)h.get(4)).getValue() ;

      /* ------------------------------
         Checking: x a a  b b
	 ------------------------------ */
        a3 =  ((Card)h.get(1)).getValue() ==  ((Card)h.get(2)).getValue() &&
                ((Card)h.get(3)).getValue()== ((Card)h.get(4)).getValue();

        result= a1||a2||a3;

        if(result){
            return ((Card)h.get(h.size()-1)).getValue();
        }
        else{
            return -1;
        }

    }


}
