
// Authors: Ian Gonzales & Jesse LaFlesch	Date: 6 April 2018	File: Item.java
// Purpose: Represents an instance of a Item. 	

import java.awt.Image;
import javax.swing.ImageIcon;

public class Item extends GamePiece{
	
	public Item(String name, String imagePath, int xLoc, int yLoc, int row, int col) {
		super(name, imagePath, xLoc, yLoc, row, col);
		this.image = new ImageIcon(image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	}
}
