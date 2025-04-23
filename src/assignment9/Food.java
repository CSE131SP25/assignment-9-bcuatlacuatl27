package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	//**attempt to change color of snake
	private Color color;
	
	/**
	 * Creates a new Food at a random location
	 */
	//2***
	public Food() {
		//FIXME
		this.x = Math.random();
		this.y = Math.random();
		this.color = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		//FIXME
		StdDraw.setPenColor(color); //**replaced StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
