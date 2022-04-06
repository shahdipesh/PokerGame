
import java.util.Comparator;

public class SortBySuit implements Comparator<Cardable> {
    @Override
    public int compare(Cardable o1, Cardable o2) {

        Cardable.Suit suit1 =((Card)(Cardable)o1).getSuit();
        Cardable.Suit suit2 =((Card)(Cardable)o2).getSuit();

        return suit1.ordinal()-suit2.ordinal();
    }
}
