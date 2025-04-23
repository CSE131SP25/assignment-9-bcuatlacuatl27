package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	private Snake snake;
	private Food food;
	private int foodCounter;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		//FIXME - construct new Snake and Food objects
		food = new Food();
		snake = new Snake();
		foodCounter = 0;
	}
	//TODO: Update this condition to check if snake is in bounds
	public void play() {
		while (snake.isInbounds()) {//Loop runs while snake is in bounds 
			int dir = getKeypress(); //gets user direction from keys
			
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
		//update snake direction and moves the snake 
		snake.changeDirection(dir);
		snake.move();
		
		//checks if snake ate food, the counter increments each time the snake
		//eats food (foodCounter++)
		//and updates during the game
		if(snake.eatFood(food)) {
			food = new Food(); //**Respawn food by creating new food object at random location
			foodCounter++; //updates score
			}
			//calls update method
		updateDrawing();
		}
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		//FIXME
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.text(.1, .98, "Score:" + foodCounter);
		StdDraw.pause(50);
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
