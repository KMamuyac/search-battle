package editor;

public class Controller {

	private static final int SPACE = 0;
	private static final int WALL = 1;
	private static final int TREASURE = 2;
	private static final int BOT = 3;
	private static final int ENEMY = 4;
	private static final int ANDY = 5;
	private static final int BRAD = 6;
	private static final int CHIP = 7;
	private static final int DAVE = 8;

	private Model model;
	
	public Controller(Model model) {
		this.model = model;
	}
	
	public void save() {
		model.saveMap();
	}
	
	public void newMap(int width, int height) {
		model.newMap(width, height);
	}
	
	public void openMap(String fileName) {
		model.openMap(fileName);
	}
	
	public void selectSpace() {
		model.setTool(SPACE);
	}
	
	public void selectWall() {
		model.setTool(WALL);
	}
	
	public void selectTreasure() {
		model.setTool(TREASURE);
	}
	
	public void selectEnemy() {
		model.setTool(ENEMY);
	}
	
	public void selectBotAndy() {
		model.setTool(ANDY);
	}
	
	public void selectBotBrad() {
		model.setTool(BRAD);
	}
	
	public void selectBotChip() {
		model.setTool(CHIP);
	}
	
	public void selectBotDave() {
		model.setTool(DAVE);
	}
	
}
