/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		/* You fill this in */
		
		//double y = Math.sqrt(x);
		
		println("Enter values to compute Pythagorean theorem");
		
		double a = readDouble("a: ");
		double b = readDouble("b: ");
		
		
		double c = Math.sqrt(a * a + b * b);
		
		println("c = " + c);
		
	}
}
