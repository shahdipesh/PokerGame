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
import java.util.Comparator;

public class PokerGame
{
	public static void main(String[] args)
	{
		//Build a game logic, feed it into the PokerTableDisplay
		GameLogicable gl = new GameLogic();  //Insert a call to the constructor of your class that implements GameLogicable
		PokerTableDisplay ptd = new PokerTableDisplay(gl);



	}
}
