
import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends GamePiece {

	private int score = 0;
	
	public Player(String name, String imagePath, int xLoc, int yLoc) {
		super(name, imagePath, xLoc, yLoc, 0, 0);
		this.image = new ImageIcon(image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	}
		
	public int getScore() {return score;}
	
	public void pickUpItem() {score++;}
	
}
