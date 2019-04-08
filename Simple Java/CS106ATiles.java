/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	private static final int TILE_WIDTH = 120;
	private static final int TILE_HEIGHT = 60;
	
	
	

	public void run() {
		/* You fill this in. */
		
		//Upper-left Rect: A
		//Lower-left Rect: B
		//Upper-right Rect: C
		//Lower-right Rect: D
		
		//Coordinates of Rect A
		int aX = (getWidth() - (2 * TILE_WIDTH + TILE_SPACE)) / 2;
		int aY = (getHeight() - (2 * TILE_HEIGHT + TILE_SPACE)) / 2;
		
		//Coordinates of Rect B
		int bX = aX;
		int bY = aY + TILE_HEIGHT + TILE_SPACE;
		
		//Coordinates of Rect C
		int cX = aX + TILE_WIDTH + TILE_SPACE;
		int cY = aY;
		
		//Coordinates of Rect D
		int dX = cX;
		int dY = bY;
		
		GRect rectA = new GRect (aX, aY, TILE_WIDTH, TILE_HEIGHT);
		GRect rectB = new GRect (bX, bY, TILE_WIDTH, TILE_HEIGHT);
		GRect rectC = new GRect (cX, cY, TILE_WIDTH, TILE_HEIGHT);
		GRect rectD = new GRect (dX, dY, TILE_WIDTH, TILE_HEIGHT);
		
		add(rectA);
		add(rectB);	
		add(rectC);
		add(rectD);
		
		//Creating Label CS106A
		
		
		
		GLabel label = new GLabel ("CS106A");
		
		
		//coordinates of label A, B, C, D
		double aXX = aX + (TILE_WIDTH - label.getWidth()) / 2;
		double aYY = aY + (TILE_HEIGHT / 2) + (label.getAscent() / 2);
		
		double bXX = aXX;
		double bYY = aYY + TILE_HEIGHT + TILE_SPACE;
		
		double cXX = aXX + TILE_SPACE + TILE_WIDTH;
		double cYY = aYY;
		
		double dXX = cXX;
		double dYY = bYY;
		
		
		GLabel labelA = new GLabel ("CS106A", aXX, aYY);
		GLabel labelB = new GLabel ("CS106A", bXX, bYY);
		GLabel labelC = new GLabel ("CS106A", cXX, cYY);
		GLabel labelD = new GLabel ("CS106A", dXX, dYY);
		
		add(labelA);
		add(labelB);
		add(labelC);
		add(labelD);
		


		
		
	}
}

