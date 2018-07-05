package game;

public class Controller {
	
	private Model model;
	
	public Controller(Model model) {
		this.model = model;
	}
	
	public void openMap(String fileName) {
		model.openMap(fileName);
	}
	
	public void togglePause() {
		model.togglePause();
	}
	
	public void exit() {
		model.exit();
	}

}
