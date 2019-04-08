/*
  * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.lang.Object;


import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hangman extends ConsoleProgram {

	/***********************************************************
	 *              CONSTANTS                                  *
	 ***********************************************************/
	
	/* The number of guesses in one game of Hangman */
	private static final int N_GUESSES = 7;
	/* The width and the height to make the karel image */
	private static final int KAREL_SIZE = 150;
	/* The y-location to display karel */
	private static final int KAREL_Y = 230;
	/* The width and the height to make the parachute image */
	private static final int PARACHUTE_WIDTH = 300;
	private static final int PARACHUTE_HEIGHT = 130;
	/* The y-location to display the parachute */
	private static final int PARACHUTE_Y = 50;
	/* The y-location to display the partially guessed string */
	private static final int PARTIALLY_GUESSED_Y = 430;
	/* The y-location to display the incorrectly guessed letters */
	private static final int INCORRECT_GUESSES_Y = 460;
	/* The fonts of both labels */
	
	private static final String PARTIALLY_GUESSED_FONT = "Courier-36";
	private static final String INCORRECT_GUESSES_FONT = "Courier-26";
	
	/* Top Center of Karel */


	/***********************************************************
	 *              Instance Variables                         *
	 ***********************************************************/
	
	/* An object that can produce pseudo random numbers */
	private RandomGenerator rg = new RandomGenerator();
	String incompleteWord = "";

	private GCanvas canvas = new GCanvas();
	String word = getRandomWord();
	//String word = "helloe";
	String result ="";
	String userword;
	


	
	
	
	/***********************************************************
	 *                    Methods                              *
	 ***********************************************************/
	public final void drawBackground() {
		GImage bg = new GImage("background.jpg");
		bg.setSize(canvas.getWidth(), canvas.getHeight());
		canvas.add(bg,0,0);
		bg.sendToBack();

		
	}
	
	public void init() {
		add(canvas);
		drawBackground();
		drawParachutes();
		drawKarel();
		drawLines();
		
	}
	
	public void run() {
		HangmanConsoleInitial();
		guessWord();
		
	}
	

	private void HangmanConsoleInitial() {
		
		println("Welcome to Hangman");
		print("Your word now looks like this:");
		int len = word.length();
		for (int i = 0; i < word.length(); i++) {
			
		result += "-";

		}
		print(result);
		
	}
	public void guessWord() {
	
		int number = N_GUESSES;
		while(number > 0) {
		println("You have "+ number + " guesses left.");
		String userword = readLine("your guess: ");
		
		// first character of the String userword is char
		char ch = userword.charAt(0);
		int pos = word.indexOf(ch);	
		
		if(Character.isLowerCase(ch) == true) {
		ch = Character.toUpperCase(ch);
			
		}
			

		
		//verifying one character//
		if(userword.length() != 1 || Character.isDigit(ch) ) {
			println("your guess is illegal, type a single letter");
		}

		else if(pos == -1) {
				println("There are no " + ch + "\'s in the world.");
				println("Your word now looks like this: " + result);
				number--;
				
				
				incompleteWord += ch; 

	
				//Create Wrongly guessed word string.
		
				if (canvas.getElementAt(canvas.getWidth()/2,INCORRECT_GUESSES_Y-1) != null){
					canvas.remove(canvas.getElementAt(canvas.getWidth()/2,INCORRECT_GUESSES_Y-1));					
					drawBackground();

					
				
				}	
				
				GLabel dig = new GLabel(incompleteWord);
				
				dig.setFont(INCORRECT_GUESSES_FONT);
				
				
				canvas.add(dig,(canvas.getWidth()-dig.getWidth())/2, INCORRECT_GUESSES_Y);
	
				//Subtract String from Parachute
				
				substractString(number);
				
				
		}
				
			
		else if (pos != -1) {
				println("That guess is correct.");
				
				while(pos != -1) {
					result = result.substring(0, pos) + ch + result.substring(pos+1);
					pos = word.indexOf(ch, pos+1);
					drawPartiallyCorrect();

				}
		
				println("Your word now looks like this: " + result);
				if(result.equals(word)) {
					println("You win.");
					println("The word was: "+word);
					break;
				}					
			}	
		if (number == 0) {
			println("You're completely hung");
			println("The word was: " + word);
			break;
			
		}
	}
}


	private void drawParachutes() {
		GImage pc = new GImage("parachute.png");
		pc.setSize(PARACHUTE_WIDTH, PARACHUTE_HEIGHT);
		canvas.add(pc,(canvas.getWidth()-PARACHUTE_WIDTH)/2 ,PARACHUTE_Y);	
	}
	
	private void drawKarel() {
		GImage kr = new GImage("karel.png");
		kr.setSize(KAREL_SIZE, KAREL_SIZE);
		canvas.add(kr,(canvas.getWidth()-KAREL_SIZE)/2 ,KAREL_Y);	
	}
	
	public void drawLines() {
		GLine ln2 = new GLine(canvas.getWidth()/2,KAREL_Y, (canvas.getWidth()-PARACHUTE_WIDTH)/2, PARACHUTE_HEIGHT+PARACHUTE_Y);
		canvas.add(ln2);
		GLine ln4 = new GLine(canvas.getWidth()/2,KAREL_Y, (canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH/6, PARACHUTE_HEIGHT+PARACHUTE_Y);
		canvas.add(ln4);
		GLine ln6 = new GLine(canvas.getWidth()/2,KAREL_Y, (canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH/6 *2, PARACHUTE_HEIGHT+PARACHUTE_Y);
		canvas.add(ln6);
		GLine ln7 = new GLine(canvas.getWidth()/2,KAREL_Y, (canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH/6 *3, PARACHUTE_HEIGHT+PARACHUTE_Y);
		canvas.add(ln7);
		GLine ln5 = new GLine(canvas.getWidth()/2,KAREL_Y, (canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH/6 *4, PARACHUTE_HEIGHT+PARACHUTE_Y);
		canvas.add(ln5);
		GLine ln3 = new GLine(canvas.getWidth()/2,KAREL_Y, (canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH/6 *5, PARACHUTE_HEIGHT+PARACHUTE_Y);
		canvas.add(ln3);
		GLine ln1 = new GLine(canvas.getWidth()/2,KAREL_Y, (canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH, PARACHUTE_HEIGHT+PARACHUTE_Y);
		canvas.add(ln1);

	}
	
	private void drawPartiallyCorrect() {
		
		if (canvas.getElementAt(canvas.getWidth()/2,PARTIALLY_GUESSED_Y) != null){
			canvas.remove(canvas.getElementAt(canvas.getWidth()/2,PARTIALLY_GUESSED_Y));					
			drawBackground();

			
		
		}	
	
		GLabel dpc = new GLabel(result);
		dpc.setFont(PARTIALLY_GUESSED_FONT);
		canvas.add(dpc, (canvas.getWidth()-dpc.getWidth())/2, PARTIALLY_GUESSED_Y);
		
	}
	
	private void substractString(int num) {
		
		
		if(num == 6) {
		GObject fig1 = canvas.getElementAt((canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH, PARACHUTE_HEIGHT+PARACHUTE_Y);
		
		canvas.remove(fig1);
		drawBackground();
		drawParachutes();	
		
	}
		if(num == 5) {
			GObject fig2 = canvas.getElementAt((canvas.getWidth()-PARACHUTE_WIDTH)/2, PARACHUTE_HEIGHT+PARACHUTE_Y);
			
			canvas.remove(fig2);
			drawBackground();
			drawParachutes();	
			
		}
		if(num == 4) {
			GObject fig3 = canvas.getElementAt((canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH /6 * 5, PARACHUTE_HEIGHT+PARACHUTE_Y);
			
			canvas.remove(fig3);
			drawBackground();
			drawParachutes();	
			
		}
		if(num == 3) {
			GObject fig4 = canvas.getElementAt((canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH / 6, PARACHUTE_HEIGHT+PARACHUTE_Y);
			
			canvas.remove(fig4);
			drawBackground();
			drawParachutes();	
			
		}
		if(num == 2) {
			GObject fig5 = canvas.getElementAt((canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH /6 * 4, PARACHUTE_HEIGHT+PARACHUTE_Y);
			
			canvas.remove(fig5);
			drawBackground();
			drawParachutes();	
			
		}
		if(num == 1) {
			GObject fig6 = canvas.getElementAt((canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH /6 * 2, PARACHUTE_HEIGHT+PARACHUTE_Y);
			
			canvas.remove(fig6);
			drawBackground();
			drawParachutes();	
			
		}
		if(num == 0) {
			GObject fig7 = canvas.getElementAt((canvas.getWidth()-PARACHUTE_WIDTH)/2 + PARACHUTE_WIDTH /6 * 3, PARACHUTE_HEIGHT+PARACHUTE_Y);
			
			canvas.remove(fig7);
			drawBackground();
			drawParachutes();	
			removeKarel();
			fallingKarel();
			
			
		}
		
	}


	
	private void removeKarel() {
		
	
		GObject gg = canvas.getElementAt((canvas.getWidth()-KAREL_SIZE)/2 ,KAREL_Y);
		if(gg != null) {
			canvas.remove(gg);
			drawBackground();
		}
}
	

	private void fallingKarel() {
	
			GImage kf = new GImage("karelFlipped.png");
			kf.setSize(KAREL_SIZE, KAREL_SIZE);
			
			canvas.add(kf,(canvas.getWidth()-KAREL_SIZE)/2 ,KAREL_Y);	
	}
		
	
		
	


	
	/**
	 * Method: Get Random Word
	 * -------------------------
	 * This method returns a word to use in the hangman game. It randomly 
	 * selects from among 10 choices.
	 */
	private String getRandomWord() {
		int index = rg.nextInt(10);
		if(index == 0) return "BUOY";
		if(index == 1) return "COMPUTER";
		if(index == 2) return "CONNOISSEUR";
		if(index == 3) return "DEHYDRATE";
		if(index == 4) return "FUZZY";
		if(index == 5) return "HUBBUB";
		if(index == 6) return "KEYHOLE";
		if(index == 7) return "QUAGMIRE";
		if(index == 8) return "SLITHER";
		if(index == 9) return "ZIRCON";
		throw new ErrorException("getWord: Illegal index");
	}

}
