// CLASS: Card
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class defines a card
//
//-----------------------------------------


public class Card implements Cardable{


    private int value;
    private boolean isSelected;
    private boolean faceUp;
    Suit mySuit;

    //constructor
    public Card(int value, Suit mySuit ) {
        this.value = value;
        this.mySuit=mySuit;
        isSelected = false;
        faceUp=false;
    }

    //------------------------------------------------------
    // getSelected
    //
    // PURPOSE:  tells whether a card is selected or not
    //------------------------------------------------------
    @Override
    public boolean getSelected() {
        return isSelected;
    }

    //gets the faceup status of a card
    @Override
    public boolean getFaceUp() {
        return faceUp;
    }

    //gets the suit  of a card
    @Override
    public Suit getSuit() {
        return this.mySuit;
    }

    //------------------------------------------------------
    // switchSelectedState
    //
    // PURPOSE:   switches the selectedstate of a card
    //------------------------------------------------------
    public void switchSelectedState(){
        this.isSelected = !(this.isSelected);
    }

    //resets the card's state to false
    public void resetSelected(){
        this.isSelected=false;

    }

    //sets the face up property to the parameter that is passed in
    public void setFaceUp(boolean faceUp){
        this.faceUp= faceUp;
    }


    @Override
    public String toString() {

        String cardVal="";
        char unicode=' ';

        //Card A can have 2 values depending on situation
        if (value == 14 || value == 1){
            cardVal += "A";
        }
        else if (value == 12) {
            cardVal += "Q";
        } else if (value == 13) {
            cardVal += "K";
        } else if (value == 11) {
            cardVal += "J";
        } else {
            cardVal += value;
        }

        switch(this.mySuit) {
            case HEART:
                unicode = '\u2665';
                break;
            case DIAMOND:
                unicode = '\u2666';
                break;
            case SPADE:
                unicode = '\u2660';
                break;
            case CLUB:
                unicode = '\u2663';
                break;
        }

        return cardVal+unicode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public Suit getMySuit() {
        return mySuit;
    }

    //compareTo method
    public int compareTo(Card card) {
        if (this.getValue() > card.getValue()) {
            return 1;
        } else if (this.getValue() < card.getValue()) {
            return -1;
        } else {
            return 0;
        }
    }


    public void setMySuit(Suit mySuit) {
        this.mySuit = mySuit;
    }
}
