package bots;

import java.awt.Color;

import game.Block;
import game.Character;

public class BotAndy extends Character {

	public BotAndy(Block[][] blocks, int x, int y) {
		super(blocks, x, y);
	}
	
	@Override
	public void think() {
		direction = (int)(Math.random() * 4);
//		direction = STAY;
	}

}
