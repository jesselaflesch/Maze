
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	private Game game;
	private Movement movement;
	final private int GAME_HEIGHT = 500, GAME_WIDTH = 1000;
	
	public MainPanel(File maze) throws FileNotFoundException{
		this.game = new Game(this, maze);
		this.movement = new Movement(game.getPlayer(), game.getItems(), this, game);
		addKeyListener(movement);
		
		setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
		setFocusable(true);
		
		movement.startTimer();
		repaint();
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		page.drawImage(game.getPlayer().getImage(), game.getPlayer().getXLoc(), game.getPlayer().getYLoc(), null);
		
		for(int i = 0; i < game.getItems().length; i++){
			if (game.getItems()[i] == null) {continue;}
			else {page.drawImage(game.getItems()[i].getImage(), game.getItems()[i].getXLoc(), game.getItems()[i].getYLoc(), null);}
		}
		
		for(int i = 0; i < game.getBlocks().size(); i++) {
			page.drawImage(game.getBlocks().get(i).getImage(), game.getBlocks().get(i).getXLoc(), game.getBlocks().get(i).getYLoc(), null);
		}
	}
}