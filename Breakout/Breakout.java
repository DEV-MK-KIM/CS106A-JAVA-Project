/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.*;

public class Breakout extends GraphicsProgram {

	// Dimensions of the canvas, in pixels
	// These should be used when setting up the initial size of the game,
	// but in later calculations you should use getWidth() and getHeight()
	// rather than these constants for accurate size information.
	public static final double CANVAS_WIDTH = 420;
	public static final double CANVAS_HEIGHT = 600;

	// Number of bricks in each row
	public static final int NBRICK_COLUMNS = 10;

	// Number of rows of bricks
	public static final int NBRICK_ROWS = 10;

	// Separation between neighboring bricks, in pixels
	public static final double BRICK_SEP = 4;

	// Width of each brick, in pixels
	public static final double BRICK_WIDTH = Math.floor(
			(CANVAS_WIDTH - (NBRICK_COLUMNS + 1.0) * BRICK_SEP) / NBRICK_COLUMNS);

	// Height of each brick, in pixels
	public static final double BRICK_HEIGHT = 8;

	// Offset of the top brick row from the top, in pixels
	public static final double BRICK_Y_OFFSET = 70;

	// Dimensions of the paddle
	public static final double PADDLE_WIDTH = 60;
	public static final double PADDLE_HEIGHT = 10;

	// Offset of the paddle up from the bottom 
	public static final double PADDLE_Y_OFFSET = 30;

	// Radius of the ball in pixels
	public static final double BALL_RADIUS = 10;

	// The ball's vertical velocity.
	public static final double VELOCITY_Y = 3.0;

	// The ball's minimum and maximum horizontal velocity; the bounds of the
	// initial random velocity that you should choose (randomly +/-).
	public static final double VELOCITY_X_MIN = 1.0;
	public static final double VELOCITY_X_MAX = 3.0;

	// Animation delay or pause time between ball moves (ms)
	public static final double DELAY = 1000.0 / 60.0;

	// Number of turns 
	public static final int NTURNS = 3;
	
	
	// Private Instance Variables
	
	private GRect brick;
	private GRect paddle;
	private GOval ball;
	private double vx, vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	

	public void run() {
		// Set the window's title bar text
		setTitle("CS 106A Breakout");

		// Set the canvas size.  In your code, remember to ALWAYS use getWidth()
		// and getHeight() to get the screen dimensions, not these constants!
		setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);

		/* You fill this in, along with any subsidiary methods */
		
		 
		SetUpTheBricks();
		CreateThePaddle();
		addMouseListeners();
		CreateABall();		
		MoveBall();
		//CheckForCollision();
		
		
		
	}
	
	private void SetUpTheBricks() {
		
		
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j< 10; j++) {
				
				double x = (getWidth()- (BRICK_WIDTH * 10 + BRICK_SEP * 9)) / 2 + (BRICK_WIDTH + BRICK_SEP) * j;          
				double y = BRICK_Y_OFFSET + (BRICK_HEIGHT + BRICK_SEP) * i;

				
				brick = new GRect (x, y, BRICK_WIDTH, BRICK_HEIGHT);
				
				if (i <= 1) {
				brick.setColor(Color.RED);
				brick.setFilled(true);
				//add(brick);
				
				} else if ( i <= 3) {
					
				brick.setColor(Color.ORANGE);
				brick.setFilled(true);
				//add(brick);
					
				} else if ( i <= 5) {
					
				brick.setColor(Color.YELLOW);
				brick.setFilled(true);
				//add(brick);
					
				} else if ( i <= 7) {
					
				brick.setColor(Color.GREEN);
				brick.setFilled(true);
				//add(brick);
					
				} else if ( i <= 9) {
					
				brick.setColor(Color.CYAN);
				brick.setFilled(true);
				//add(brick);
					
				} 
				add(brick);
				
			}
			
		} 

	}
	
	
	private void CreateThePaddle() {
		
		double x = (getWidth() - PADDLE_WIDTH) / 2 ;
		double y = getHeight() - (PADDLE_HEIGHT + PADDLE_Y_OFFSET);
		paddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);	
	
			
		}
	
	/*
	public void mouseMoved(MouseEvent e){
		GPoint last = new GPoint(paddle.getLocation());
		if((e.getX() + PADDLE_WIDTH/2) < getWidth() && (e.getX() > PADDLE_WIDTH/2)){ // Change this part to fit within window
			paddle.move((e.getX() - paddle.getWidth()/2) - last.getX(), 0);
		}
		
		*/
	
	public void mouseMoved(MouseEvent e){
		if(e.getX() >= 0 && e.getX() < getWidth() - PADDLE_WIDTH){
			paddle.setLocation(e.getX(), getHeight() - (PADDLE_HEIGHT + PADDLE_Y_OFFSET));
		} 
	}
	
	
	private void CreateABall() {
		
		double x = (getWidth() - BALL_RADIUS) / 2;
		double y = (getHeight() - BALL_RADIUS) / 2;
		
		ball = new GOval(x, y, BALL_RADIUS*2, BALL_RADIUS*2);
		ball.setFilled(true);
		add(ball);
		
		
		
	}
	
	private void MoveBall() {
		
		
		vx = rgen.nextDouble(0.01, 0.02);
		if (rgen.nextBoolean(0.5)) vx = -vx;
		vy = 0.012;
		
		while(true) {
		ball.move(vx, vy);
			if(ball.getX() < 0 || ball.getX() + BALL_RADIUS * 2 > getWidth())
				vx = -vx;
			if(ball.getY() < 0) //|| ball.getY() + BALL_RADIUS * 2 > getHeight())
				vy = -vy;

		CheckForCollision();	
			
		
		}
		

		
	}
	private void CheckForCollision() {
		 
		CollisionWithBrick();
		CollisionWithPaddle();
	}
	
	public void CollisionWithBrick() {
		
			
		
		GObject collObj = getElementAt(ball.getX(), ball.getY());
		
		/*
		double h = collObj.getHeight();
		double w = collObj.getWidth();
		
		
		if (h == BRICK_HEIGHT && w == BRICK_WIDTH) {
			remove(collObj);
			vy=-vy;
		}
		*/
		
		
			if (collObj != null && collObj!=paddle) {
				remove(collObj);
				vy = -vy;
			}
			
			
	    
		
		}
		 

	private void CollisionWithPaddle() {
		 
		GObject collObj1 = getElementAt(ball.getX(), ball.getY() + BALL_RADIUS*2);
		GObject collObj2 = getElementAt(ball.getX() +BALL_RADIUS*2, ball.getY());
		GObject collObj3 = getElementAt(ball.getX() +BALL_RADIUS*2, ball.getY()+ BALL_RADIUS*2);
		GObject collObj4 = getElementAt(ball.getX(), ball.getY());

			if(collObj1 == paddle || collObj4 == paddle || collObj3 == paddle || collObj2 == paddle) 
				vy = -vy;

	}


}
 


		

        

