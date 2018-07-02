package game;

import java.awt.Color;

public class Enemy extends Character {

	public Enemy(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
		this.setColor(Color.RED);
		direction = UP;
	}
	
	protected void think() {
		int x = this.getX();
		int y = this.getY();
		
		if(direction == UP && !checkUp(x, y))
			direction = LEFT;
		else if(direction == LEFT && !checkLeft(x, y))
			direction = DOWN;
		else if(direction == DOWN && !checkDown(x, y))
			direction = RIGHT;
		else if(direction == RIGHT && !checkRight(x, y))
			direction = UP;
	}
	
	private Boolean checkUp(int x, int y) {
		if(blocks[x][y - 1] instanceof Wall)
			return false;
		return true;
	}
	
	private Boolean checkDown(int x, int y) {
		if(blocks[x][y + 1] instanceof Wall)
			return false;
		return true;
	}
	
	private Boolean checkLeft(int x, int y) {
		if(blocks[x - 1][y] instanceof Wall)
			return false;
		return true;
	}
	
	private Boolean checkRight(int x, int y) {
		if(blocks[x + 1][y] instanceof Wall)
			return false;
		return true;
	}

}
