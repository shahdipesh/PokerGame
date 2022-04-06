//-----------------------------------------
// NAME		: Dipesh Shah
// STUDENT NUMBER	: 7882947
// COURSE		: COMP 2150
// INSTRUCTOR	: Ali Neshati
// ASSIGNMENT	: assignment 3
// QUESTION	: question 1
// 
// REMARKS: This is the class containing the main method that will run the game.
//
//
//-----------------------------------------

import java.util.Collections;

public class PokerGame
{
	public static void main(String[] args)
	{
		//Build a game logic, feed it into the PokerTableDisplay
		GameLogicable gl = new GameLogic();  //Insert a call to the constructor of your class that implements GameLogicable
		PokerTableDisplay ptd = new PokerTableDisplay(gl);


//	Card c1 = new Card(11,Cardable.Suit.HEART);
//		Card c2 = new Card(2,Cardable.Suit.SPADE);
//		Card c3 = new Card(9,Cardable.Suit.HEART);
//		Card c4 = new Card(8,Cardable.Suit.HEART);
//		Card c5 = new Card(7,Cardable.Suit.HEART);
////
//		Hand h1 = new Hand();
//		h1.addCardToHand(c1);
//		h1.addCardToHand(c2);
//		h1.addCardToHand(c3);
//		h1.addCardToHand(c4);
//		h1.addCardToHand(c5);
//		Card cx1 = new Card(14,Cardable.Suit.SPADE);
//
//		h1.getHand().set(0,cx1);
//		System.out.println(h1.getHand().get(0));

//
//		Card cx1 = new Card(14,Cardable.Suit.SPADE);
//		Card cx2 = new Card(4,Cardable.Suit.HEART);
//		Card cx3 = new Card(3,Cardable.Suit.HEART);
//		Card cx4 = new Card(2,Cardable.Suit.HEART);
//		Card cx5 = new Card(1,Cardable.Suit.HEART);
//
//		Hand h2 = new Hand();
//		h2.addCardToHand(cx1);
//		h2.addCardToHand(cx2);
//		h2.addCardToHand(cx3);
//		h2.addCardToHand(cx4);
//		h2.addCardToHand(cx5);
//
//		System.out.println(h1.compareTo(h2));
	}
}
