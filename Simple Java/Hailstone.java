/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		/* You fill this in */
		
		
		int number = readInt("Enter a number: ");
		int i;
		
		for (i = 0; i >= 0; i++) {
			
			int result;

			
			if (number == 1) {
				break;
			}
			
			else if (number % 2 == 0) {
				result = number / 2;
				println(number + " is even, so I take half: " + result);
				number = result;
				
				
				
				
			} else if (number % 2 == 1) {
				result = number * 3 + 1;
				println(number + " is odd, so I make 3n+1: " + result);
				number = result;
			}
			

			
		} // while loop 1 finished
		println("The process took " + i + " to reach 1");
		
		
		
		
		
		
	}
}

