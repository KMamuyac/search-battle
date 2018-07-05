package game;

import java.awt.Color;

public class Block {
	
	protected int x;
	protected int y;
	protected Color color;
	
	/**
	 * This function sets the location of the block.
	 * @param x is the x-coordinate of the block.
	 * @param y is the y-coordinate of the block.
	 */
	protected void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * This function sets the color that the block will be shown as.
	 * @param color
	 */
	protected void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * This function returns the x-coordinate of the block.
	 * @return
	 */
	public int getX() {
		return x;
	}

	/*
	 * This function returns the y-coordinate of the block.
	 */
	public int getY() {
		return y;
	}
	
	// This function returns the color of the block.
	protected Color getColor() {
		return color;
	}
	
}
