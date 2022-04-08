import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JUnitTests  {


    @Test
    public void test1()
    {

        Cardable[] cards1 = {new Card(2, Cardable.Suit.CLUB), new Card(2, Cardable.Suit.HEART), new Card(3, Cardable.Suit.CLUB), new Card(4, Cardable.Suit.CLUB), new Card(2, Cardable.Suit.DIAMOND)};
		TestableHand th1 = new Hand();
		th1.addCards(cards1);

		Cardable[] cards2 = {new Card(3, Cardable.Suit.HEART), new Card(4, Cardable.Suit.HEART), new Card(5, Cardable.Suit.HEART), new Card(6, Cardable.Suit.HEART), new Card(7, Cardable.Suit.DIAMOND)};
		TestableHand th2 = new Hand();
		th2.addCards(cards2);

		assertTrue(th1.compareTo(th2) < 0, "Straight beats Three of a kind.");


    }

    @Test
    public void test2()
    {
        Hand h1 = new Hand();
        Hand h2 = new Hand();


        Card c1 = new Card(5,Cardable.Suit.HEART);
        Card c2 = new Card(4,Cardable.Suit.HEART);
        Card c3 = new Card(3,Cardable.Suit.HEART);
        Card c4 = new Card(2,Cardable.Suit.HEART);
        Card c5 = new Card(14,Cardable.Suit.HEART);
//
        h1.addCardToHand(c1);
        h1.addCardToHand(c2);
        h1.addCardToHand(c3);
        h1.addCardToHand(c4);
        h1.addCardToHand(c5);

        Card cx1 = new Card(11,Cardable.Suit.SPADE);
        Card cx2 = new Card(11,Cardable.Suit.HEART);
        Card cx3 = new Card(11,Cardable.Suit.HEART);
        Card cx4 = new Card(11,Cardable.Suit.HEART);
        Card cx5 = new Card(9,Cardable.Suit.SPADE);

        h2.addCardToHand(cx1);
        h2.addCardToHand(cx2);
        h2.addCardToHand(cx3);
        h2.addCardToHand(cx4);
        h2.addCardToHand(cx5);

        System.out.println(h1.evaluateHand());
        assertTrue(h1.evaluateHand().split(" ")[0].equals("StraightFlush"), "Straight flush");
        assertTrue(h2.evaluateHand().split(" ")[0].equals("FourOfAKind"), "Four Of A Kind");
        assertTrue(h1.compareTo(h2) > 0, "StraightFlush beats Four Of A Kind");

    }

    @Test
    public void test3() {
        Hand h1 = new Hand();
        Hand h2 = new Hand();


        Card c1 = new Card(9,Cardable.Suit.HEART);
        Card c2 = new Card(9,Cardable.Suit.HEART);
        Card c3 = new Card(9,Cardable.Suit.HEART);
        Card c4 = new Card(4,Cardable.Suit.HEART);
        Card c5 = new Card(4,Cardable.Suit.HEART);
//
        h1.addCardToHand(c1);
        h1.addCardToHand(c2);
        h1.addCardToHand(c3);
        h1.addCardToHand(c4);
        h1.addCardToHand(c5);

        Card cx1 = new Card(8,Cardable.Suit.SPADE);
        Card cx2 = new Card(8,Cardable.Suit.HEART);
        Card cx3 = new Card(8,Cardable.Suit.HEART);
        Card cx4 = new Card(4,Cardable.Suit.HEART);
        Card cx5 = new Card(4,Cardable.Suit.SPADE);

        h2.addCardToHand(cx1);
        h2.addCardToHand(cx2);
        h2.addCardToHand(cx3);
        h2.addCardToHand(cx4);
        h2.addCardToHand(cx5);

        assertTrue(h1.compareTo(h2) > 0, "Flush with high 9 beats Flush with high 8");

    }
    @Test
    public void test4() {
        Hand h1 = new Hand();
        Hand h2 = new Hand();


        Card c1 = new Card(6,Cardable.Suit.HEART);
        Card c2 = new Card(6,Cardable.Suit.SPADE);
        Card c3 = new Card(3,Cardable.Suit.HEART);
        Card c4 = new Card(2,Cardable.Suit.SPADE);
        Card c5 = new Card(1,Cardable.Suit.HEART);
//
        h1.addCardToHand(c1);
        h1.addCardToHand(c2);
        h1.addCardToHand(c3);
        h1.addCardToHand(c4);
        h1.addCardToHand(c5);

        Card cx1 = new Card(5,Cardable.Suit.SPADE);
        Card cx2 = new Card(8,Cardable.Suit.HEART);
        Card cx3 = new Card(14,Cardable.Suit.HEART);
        Card cx4 = new Card(10,Cardable.Suit.HEART);
        Card cx5 = new Card(1,Cardable.Suit.SPADE);

        h2.addCardToHand(cx1);
        h2.addCardToHand(cx2);
        h2.addCardToHand(cx3);
        h2.addCardToHand(cx4);
        h2.addCardToHand(cx5);

        assertTrue(h1.compareTo(h2) > 0, "A pair beats card with nothing");

    }

    @Test
    public void test5() {
        Hand h1 = new Hand();
        Hand h2 = new Hand();


        Card c1 = new Card(6,Cardable.Suit.HEART);
        Card c2 = new Card(2,Cardable.Suit.SPADE);
        Card c3 = new Card(5,Cardable.Suit.HEART);
        Card c4 = new Card(8,Cardable.Suit.SPADE);
        Card c5 = new Card(10,Cardable.Suit.HEART);
//
        h1.addCardToHand(c1);
        h1.addCardToHand(c2);
        h1.addCardToHand(c3);
        h1.addCardToHand(c4);
        h1.addCardToHand(c5);

        Card cx1 = new Card(6,Cardable.Suit.SPADE);
        Card cx2 = new Card(2,Cardable.Suit.HEART);
        Card cx3 = new Card(5,Cardable.Suit.HEART);
        Card cx4 = new Card(8,Cardable.Suit.HEART);
        Card cx5 = new Card(14,Cardable.Suit.SPADE);

        h2.addCardToHand(cx1);
        h2.addCardToHand(cx2);
        h2.addCardToHand(cx3);
        h2.addCardToHand(cx4);
        h2.addCardToHand(cx5);

        assertTrue(h1.compareTo(h2) < 0, "A nothing card with high 14 beats a nothing card with high 10");
    }


}
