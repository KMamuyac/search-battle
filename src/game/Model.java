package game;

import javax.swing.JFrame;

public class Model {
	
	private Map map;
	private Display display;
	private Game game;
	
	public Model() {
		this.setJFrame();
	}
	
	public void setJFrame() {
		game = new Game(new Controller(this));
		map = Reader.getMap("map.txt");
		map.startGame();
		display = new Display(map);
		game.setContentPane(display);
		display.setVisible(true);
		game.setVisible(true);
		game.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void openMap(String fileName) {
		map = Reader.getMap(fileName);
		display.setMap(map);
		game.setContentPane(display);
		map.startGame();
	}
	
	public void togglePause() {
		map.togglePause();
	}
	
}
