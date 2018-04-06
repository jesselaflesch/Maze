
// Authors: Ian Gonzales & Jesse LaFlesch	Date: 6 April 2018	File: GamePiece.java
// Purpose: Represents an instance of a GamePiece. This class is the parent class of
//			the Player, Item, Block, and Enemy Classes.

import java.awt.Image;
import javax.swing.ImageIcon;

public class GamePiece {
	
	protected String name;
	protected ImageIcon image;
	protected int xLoc, yLoc, row, col;
	final protected int GAME_HEIGHT = 50 * MainFrame.GAME_ROWS, GAME_WIDTH = 50 * MainFrame.GAME_COLS;
	
	public GamePiece(String name, String imagePath, int xLoc, int yLoc, int row, int col){
		this.name = name;
		this.image = new ImageIcon(imagePath);
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.row = row;
		this.col = col;
	}
	
	public int getXLoc() {
		return xLoc;
	}

	public void setXLoc(int xLoc) {
		this.xLoc = xLoc;
	}

	public int getYLoc() {
		return yLoc;
	}

	public void setYLoc(int yLoc) {
		this.yLoc = yLoc;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Image getImage() {
		return image.getImage();
	}
	
	public int getImageWidth() {
		return image.getIconWidth();
	}
	
	public int getImageHeight() {
		return image.getIconHeight();
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void up() {
		yLoc -= 50; 
		row -= 1; 
		if (row < 0) { 
			yLoc = 0; 
			row = 0;
		}
	}
	
	public void down() {
		yLoc += 50; 
		row += 1; 
		if (row > MainFrame.GAME_ROWS - 1) {
			yLoc = GAME_HEIGHT - 50; 
			row = MainFrame.GAME_ROWS - 1;
		}
	}
	
	public void left() {
		xLoc -= 50; 
		col -= 1; 
		if (col < 0) { 
			col = 0; 
			xLoc = 0;
		}
	}
	
	public void right() {
		xLoc += 50; 
		col += 1; 
		if (col > MainFrame.GAME_COLS - 1) { 
			col = MainFrame.GAME_COLS - 1; 
			xLoc = GAME_WIDTH - 50;
		}
	}
}