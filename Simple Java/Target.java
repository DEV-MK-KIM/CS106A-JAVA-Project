/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	
	private static final double CIRCLE_OUT_RAD = 72;
	private static final double CIRCLE_MID_RAD = 72 * 65 / 100;
	private static final double CIRCLE_CEN_RAD = 72 * 30 / 100;
	
	
	
	
	public void run() {
		/* You fill this in. */
		
		
		double circleOutX = (getWidth() - CIRCLE_OUT_RAD * 2)/ 2;
		double circleOutY = (getHeight() - CIRCLE_OUT_RAD * 2)/ 2;
		
		double circleMidX = (getWidth() - CIRCLE_MID_RAD * 2)/ 2;
		double circleMidY = (getHeight() - CIRCLE_MID_RAD * 2)/ 2;
		
		double circleCenX = (getWidth() - CIRCLE_CEN_RAD * 2)/ 2;
		double circleCenY = (getHeight() - CIRCLE_CEN_RAD * 2)/ 2;
		
		
		
	

		
		GOval circleOut = new GOval (circleOutX, circleOutY, CIRCLE_OUT_RAD * 2, CIRCLE_OUT_RAD * 2);
		
		circleOut.setColor(Color.RED);
		circleOut.setFilled(true);
		
		GOval circleMid = new GOval (circleMidX, circleMidY, CIRCLE_MID_RAD * 2, CIRCLE_MID_RAD * 2);
		
		circleMid.setColor(Color.WHITE);
		circleMid.setFilled(true);
		
		GOval circleCen = new GOval (circleCenX, circleCenY, CIRCLE_CEN_RAD * 2, CIRCLE_CEN_RAD * 2);
		
		circleCen.setColor(Color.RED);
		circleCen.setFilled(true);
		
		

	
		
		add(circleOut);
		add(circleMid);
		add(circleCen);

		
		
		
		
	}
}
