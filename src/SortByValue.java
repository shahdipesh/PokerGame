// CLASS: SortByValue
//
// Author: Dipesh Shah, 7882947
//
// REMARKS: This class sorts the hand by the value of the cards.
//
//-----------------------------------------
import java.util.Comparator;

public class SortByValue implements Comparator<Cardable> {

    @Override
    public int compare(Cardable o1, Cardable o2) {
        return ((Card)(Cardable)o1).getValue()-((Card)(Cardable)o2).getValue();
    }
}
