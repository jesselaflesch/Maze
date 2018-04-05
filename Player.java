
public class Player extends GamePiece {

	private MainPanel panel;
	private int score = 0;
	
	public Player(String name, String imagePath, int xLoc, int yLoc, int row, int col, MainPanel panel) {
		super(name, imagePath, xLoc, yLoc, row, col);
		this.panel = panel;
	}
		
	public int getScore() {return score;}
	
	public void pickUpItem() {score++;}
	
}
