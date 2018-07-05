package editor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import bots.BotAndy;
import bots.BotBrad;
import bots.BotChip;
import bots.BotDave;
import game.Enemy;
import game.Map;
import game.Treasure;
import game.Wall;

public class Printer {

	private static final int SPACE = 0;
	private static final int WALL = 1;
	private static final int TREASURE = 2;
	private static final int BOT = 3;
	private static final int ENEMY = 4;
	private static final int ANDY = 5;
	private static final int BRAD = 6;
	private static final int CHIP = 7;
	private static final int DAVE = 8;

	public Printer(Map map, String fileName) {
		try {
			PrintWriter p = new PrintWriter(fileName, "UTF-8");

			p.println(map.getHeight());
			p.println(map.getWidth());
			
			for(int y = 0; y < map.getHeight(); y++) {
				for(int x = 0; x < map.getWidth(); x++) {
					if(map.getBlocks()[x][y] instanceof Wall) {
						p.print(WALL);
					}
					else if(map.getBlocks()[x][y] instanceof Treasure) {
						p.print(TREASURE);
					}
					else if(map.getBlocks()[x][y] instanceof Enemy) {
						p.print(ENEMY);
					}
					else if(map.getBlocks()[x][y] instanceof BotAndy) {
						p.print(ANDY);
					}
					else if(map.getBlocks()[x][y] instanceof BotBrad) {
						p.print(BRAD);
					}
					else if(map.getBlocks()[x][y] instanceof BotChip) {
						p.print(CHIP);
					}
					else if(map.getBlocks()[x][y] instanceof BotDave) {
						p.print(DAVE);
					}
					else {
						p.print(SPACE);
					}
				}
				p.println();
			}
			
			p.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
}
