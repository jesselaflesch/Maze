
// Authors: Ian Gonzales & Jesse LaFlesch	Date: 6 April 2018	File: Movement.java
// Purpose: Represents an instance of a Movement object that handles player movement,
// 			item collision, and controls the game timer.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Movement implements KeyListener{
	
	private Player player;
	private Item[] items;
	private Game game;
	private MainPanel panel;
	private Timer timer = new Timer(400, new TimerListener());
	
	public Movement(Player player, Item[] items, MainPanel panel, Game game){
		this.player = player;
		this.items = items;
		this.game = game;
		this.panel = panel;
	}
	
	public void startTimer() {
		timer.start();
	}
	
	private class TimerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0){
			panel.repaint();
		}
	}
	
	public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.left();
					if(game.getSquares()[player.getRow()][player.getCol()] == 1) {
						player.right();
						
					} else if (game.getSquares()[player.getRow()][player.getCol()] == 3) {
						player.pickUpItem();
						for (int i = 0; i < items.length; i++) {
							if (items[i] != null) {
								if (items[i].getCol() == player.getCol() && items[i].getRow() == player.getRow()) {
									items[i] = null;
									game.getSquares()[player.getRow()][player.getCol()] = 0;
								}
							}
						}
					}
				break;
				
				case KeyEvent.VK_DOWN:
					player.down();
					if(game.getSquares()[player.getRow()][player.getCol()] == 1) {
						player.up();
					
					} else if (game.getSquares()[player.getRow()][player.getCol()] == 3) {
						player.pickUpItem();
						for (int i = 0; i < items.length; i++) {
							if (items[i] != null) {
								if (items[i].getCol() == player.getCol() && items[i].getRow() == player.getRow()) {
									items[i] = null;
									game.getSquares()[player.getRow()][player.getCol()] = 0;
								}
							}
						}
					}
				break;
				
				case KeyEvent.VK_RIGHT:
					player.right();
					if(game.getSquares()[player.getRow()][player.getCol()] == 1) {
						player.left();
					
					} else if (game.getSquares()[player.getRow()][player.getCol()] == 3) {
						player.pickUpItem();
						for (int i = 0; i < items.length; i++) {
							if (items[i] != null) {
								if (items[i].getCol() == player.getCol() && items[i].getRow() == player.getRow()) {
									items[i] = null;
									game.getSquares()[player.getRow()][player.getCol()] = 0;
								}
							}
						}
					} else if (player.getRow() == 10 && player.getCol() == 25) {
						JOptionPane.showMessageDialog(null, "YOU WON!!");
					}
				break;
				
				case KeyEvent.VK_UP:
					player.up();
						if(game.getSquares()[player.getRow()][player.getCol()] == 1) {
							player.down();
							
						} else if (game.getSquares()[player.getRow()][player.getCol()] == 3) {
							player.pickUpItem();
							for (int i = 0; i < items.length; i++) {
								if (items[i] != null) {
									if (items[i].getCol() == player.getCol() && items[i].getRow() == player.getRow()) {
										items[i] = null;
										game.getSquares()[player.getRow()][player.getCol()] = 0;
									}
								}
							}
						}
					break;
			}
			panel.repaint();
	}
	
	public void keyTyped(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {	
	}
}