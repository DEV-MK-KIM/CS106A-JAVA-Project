/*
 * File: DrawCenteredRect.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the DrawCenteredRect problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawCenteredRect extends GraphicsProgram {
	
	/** Size of the centered rect */
	private static final int WIDTH = 350;
	private static final int HEIGHT = 270;

	public void run() {
		/* You fill this in. */
		
	
		double rX = (getWidth() - WIDTH) / 2;
		double rY = (getHeight() - HEIGHT) /2;
				
		GRect rect = new GRect (rX, rY, WIDTH, HEIGHT);
		
		rect.setColor(Color.BLUE);
		rect.setFilled(true);
		
		add(rect);
		
		
		
		
		
	}
}

