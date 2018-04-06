import java.awt.Image;

import javax.swing.ImageIcon;

public class Block extends GamePiece {

	public Block(String name, String imagePath, int xLoc, int yLoc, int row, int col) {
		super(name, imagePath, xLoc, yLoc, row, col);
		this.image = new ImageIcon(image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	}
}
