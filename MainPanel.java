
// Authors: Ian Gonzales & Jesse LaFlesch	Date: 6 April 2018	File: MainPanel.java
// Purpose: Represents a panel where the Game is to be played.  		

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	private Game game;
	private Movement movement;
	final private int GAME_HEIGHT = 50 * MainFrame.GAME_ROWS;
	final private int GAME_WIDTH = 50 * MainFrame.GAME_COLS;
	
	public MainPanel(File maze) throws FileNotFoundException{
		
		game = new Game(maze);
		movement = new Movement(game.getPlayer(), game.getItems(), this, game);
		addKeyListener(movement);
		setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
		setFocusable(true);
		movement.startTimer();
		repaint();
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		
		// Drawing the Player
		page.drawImage(game.getPlayer().getImage(), game.getPlayer().getXLoc(), game.getPlayer().getYLoc(), null);
		
		// Drawing the Items
		for(int i = 0; i < game.getItems().length; i++){
			if (game.getItems()[i] != null) {
				page.drawImage(game.getItems()[i].getImage(), game.getItems()[i].getXLoc(), game.getItems()[i].getYLoc(), null);
			}
		}
		
		// Drawing the Blocks
		for(int i = 0; i < game.getBlocks().size(); i++) {
			page.drawImage(game.getBlocks().get(i).getImage(), game.getBlocks().get(i).getXLoc(), game.getBlocks().get(i).getYLoc(), null);
		}
	}
}