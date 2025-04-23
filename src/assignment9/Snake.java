package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		segments = new LinkedList<BodySegment>();
		BodySegment BodyS = new BodySegment(.5,.5, SEGMENT_SIZE);
		segments.add(BodyS);
		deltaX = 0;
		deltaY = 0;
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	
	/*5**The snake moves by shifting the position of each segment to the position of the segment 
	ahead of it, starting from the tail. Uses the move() method where each segment except the head takes the coordinates
	of the segment in front of it.The head updates its position based on deltaX and deltaY, which are determined by the
	 direction of movement (changeDirection method).
	*/
	
	public void move() {
		//FIXME
		// Each segment takes the place of the one before it (tail follows head)
		for (int i = segments.size() - 1; i> 0; i-- ) {
			BodySegment bodySeg = segments.get(i);
			BodySegment bodyUpdate = segments.get(i-1);
			bodySeg.setX(bodyUpdate.getX());
			bodySeg.setY(bodyUpdate.getY());
		}
		// Move the head in the current direction
		BodySegment head = segments.get(0);
		head.setX(head.getX() + deltaX);
		head.setY(head.getY() + deltaY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for(int i = 0; segments.size() > i; i++)
			segments.get(i).draw();
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		// Add a new segment at the tail's position
		/*The snake grows by adding a new BodySegment to its segments list when it eats food.
		* In the eatFood method:checks if the dis between the snake's head and the food is less 
		* than the sum of their sizes. If true, it adds a new segment at the tail's position 
		* and increases the segments size
		 */
		double foodX = f.getX();
		double foodY = f.getY();
		BodySegment head = segments.get(0);
		double headX = head.getX();
		double headY = head.getY();
		
		double distance = Math.sqrt(Math.pow((foodY) - headY,2) + Math.pow((foodX) - headX,2));
		// 1**
		if(distance < SEGMENT_SIZE + Food.FOOD_SIZE) {
			BodySegment currentTail = segments.get(segments.size() -1);
			BodySegment newTail = new BodySegment(currentTail.getX(), currentTail.getY(), SEGMENT_SIZE);
			move();
			segments.add(newTail);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	/* The game ends when the snake runs out of bounds,  using the isInbounds method 
	The method verifies if the head of the snake is within the bounds of the window (0 < x, y < 1).
	If the head goes out of bounds, the loop in play ends, stopping the game.
	*/
	public boolean isInbounds() {
		//FIXME
		BodySegment head = segments.get(0);
		double headX= head.getX();
		double headY = head.getY();
		
		if(headX < 1 && headY < 1 && headY > 0 && headX > 0) {
			return true;
		}
		return false;
	}
}
