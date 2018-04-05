
import java.awt.Image;
import javax.swing.ImageIcon;

public class GamePiece {
	
	protected String name;
	protected ImageIcon image;
	protected int xLoc, yLoc, row, col;
	final protected int GAME_HEIGHT = 500, GAME_WIDTH = 1000;
	
	public GamePiece(String name, String imagePath, int xLoc, int yLoc, int row, int col){
		this.name = name;
		this.image = new ImageIcon(imagePath);
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.row = row;
		this.col = col;
	}
	
	public int getXLoc() {return xLoc;}

	public void setXLoc(int xLoc) {this.xLoc = xLoc;}

	public int getYLoc() {return yLoc;}

	public void setYLoc(int yLoc) {this.yLoc = yLoc;}

	public String getName() {return name;}
	
	public void setName(String name) {this.name = name;}

	public Image getImage() {return image.getImage();}
	
	public int getImageWidth() {return image.getIconWidth();}
	
	public int getImageHeight() {return image.getIconHeight();}
	
	public void up() {yLoc -= 100; if (yLoc < 0) {yLoc = 0;}}
	
	public void down() {yLoc += 100; if (yLoc > GAME_HEIGHT - image.getIconHeight()) {yLoc = GAME_HEIGHT - image.getIconHeight();}}
	
	public void left() {xLoc -= 100; if (xLoc < 0) {xLoc = 0;}}
	
	public void right() {xLoc += 100; if (xLoc > GAME_WIDTH - image.getIconWidth()) {xLoc = GAME_WIDTH - image.getIconWidth();}}
	
}