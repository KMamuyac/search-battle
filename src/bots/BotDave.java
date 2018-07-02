package bots;

import game.Block;
import game.Character;

public class BotDave extends Character {

	public BotDave(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
	}
	
	@Override
	public void think() {
		direction = (int)(Math.random() * 4);
	}

}
