public class Card implements Cardable{

    private int value;
    private boolean isSelected;
    private boolean faceUp;
    Suit mySuit;


    public Card(int value, Suit mySuit ) {
        this.value = value;
        this.mySuit=mySuit;
        isSelected = false;
        faceUp=false;
    }

    @Override
    public boolean getSelected() {
        return isSelected;
    }

    @Override
    public boolean getFaceUp() {
        return faceUp;
    }

    @Override
    public Suit getSuit() {
        return this.mySuit;
    }

    public void switchSelectedState(){
        this.isSelected = !(this.isSelected);
    }

    public void resetSelected(){
        this.isSelected=false;

    }

    public void setFaceUp(boolean faceUp){
        this.faceUp= faceUp;
    }


    @Override
    public String toString() {

        String cardVal="";
        char unicode=' ';

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

    public void setMySuit(Suit mySuit) {
        this.mySuit = mySuit;
    }
}
