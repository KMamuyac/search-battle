package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

	private static final int SPACE = 0;
	private static final int WALL = 1;
	private static final int TREASURE = 2;
	private static final int BOT = 3;
	private static final int ENEMY = 4;
	private static final int ANDY = 5;
	private static final int BRAD = 6;
	private static final int CHIP = 7;
	private static final int DAVE = 8;
	
	/**
	 * This function scans a file and returns the map that was inside it.
	 * @param fileName is the name of the file that will be scanned.
	 * @return a Map object that contains the map from the scanned file.
	 */
	public static Map getMap(String fileName) {
		File file = new File(fileName);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			int height = Integer.parseInt(scanner.nextLine());
			int width = Integer.parseInt(scanner.nextLine());
			Map map = new Map(height, width);
			for(int y = 0; y < height; y++) {
				String line = scanner.nextLine();
				for(int x = 0; x < line.length(); x++) {
					int i = Integer.parseInt(line.charAt(x) + "");
					switch(i) {
						case SPACE:
							break;
						case WALL:
							map.addWall(x, y);
							break;
						case TREASURE:
							map.addTreasure(x, y);
							break;
						case BOT:
							map.addCharacter(x, y);
							break;
						case ENEMY:
							map.addEnemy(x, y);
							break;
						case ANDY:
							map.addBotAndy(x, y);
							break;
						case BRAD:
							map.addBotBrad(x, y);
							break;
						case CHIP:
							map.addBotChip(x, y);
							break;
						case DAVE:
							map.addBotDave(x, y);
							break;
					}
				}	
			}
			scanner.close();
			return map;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
