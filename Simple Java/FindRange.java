/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;

	public void run() {
		/* You fill this in */
		
		println("This program finds the largest and smallest numbers");
		while (true) {
			int numberFirst = readInt("? ");
			int smallest = numberFirst;
			int largest = numberFirst;	
			
			
			// if typed SENTINEL, ask them to type valid number
			if (numberFirst == SENTINEL) {			
				println("please type the valid number!");
				
				
			// if typed other than SENTINEL, ask them to type second number.	
			} else {				
				while(true) {				
				int numberSecond = readInt("? ");
				
			// if second number happens to be SENTINEL, print MAX/ min values, and break.
					if (numberSecond == SENTINEL) {
						println ("smallest: " + smallest);
						println ("largest: " + largest);
					break;				
					
					} else {
						if (numberSecond > largest) {
						largest = numberSecond;
						} else if (numberSecond < smallest) {					
						smallest = numberSecond;
						}					
					}
				} break; // while loop2 ended
			}
		}// while loop1 ended
	}
}
