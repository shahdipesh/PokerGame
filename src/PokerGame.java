//-----------------------------------------
// NAME		: your name 
// STUDENT NUMBER	: your student number
// COURSE		: COMP 2150
// INSTRUCTOR	: your instructor
// ASSIGNMENT	: assignment #
// QUESTION	: question #      
// 
// REMARKS: This is the class containing the main method that will run the game. 
// You should add the appropriate constructor call in the main, to build a GameLogicable.
// You should not add any more code here than that constructor call.
//
//
//-----------------------------------------

import java.util.Collections;

public class PokerGame
{
	public static void main(String[] args)
	{
		//Build a game logic, feed it into the PokerTableDisplay
//		GameLogicable gl = new GameLogic();  //Insert a call to the constructor of your class that implements GameLogicable
//		PokerTableDisplay ptd = new PokerTableDisplay(gl);

	Card c1 = new Card(12,Cardable.Suit.HEART);
		Card c2 = new Card(11,Cardable.Suit.HEART);
		Card c3 = new Card(10,Cardable.Suit.HEART);
		Card c4 = new Card(9,Cardable.Suit.HEART);
		Card c5 = new Card(8,Cardable.Suit.HEART);

		Hand h1 = new Hand();
		h1.addCardToHand(c1);
		h1.addCardToHand(c2);
		h1.addCardToHand(c3);
		h1.addCardToHand(c4);
		h1.addCardToHand(c5);

		System.out.println((h1.getHand().get(0)));
	}
}
