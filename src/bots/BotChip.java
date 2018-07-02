package bots;

import game.Block;
import game.Character;

public class BotChip extends Character {

	public BotChip(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
	}
	
	@Override
	public void think() {
		direction = (int)(Math.random() * 4);
	}

}
