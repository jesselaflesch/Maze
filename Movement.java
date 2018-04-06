

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
					if(game.getSquares()[game.getPlayer().getRow()][game.getPlayer().getCol()] == 1) {
						player.right();
					}
				break;
				case KeyEvent.VK_DOWN:
					player.down();
					if(game.getSquares()[game.getPlayer().getRow()][game.getPlayer().getCol()] == 1) {
						player.up();
					}
				break;
				case KeyEvent.VK_RIGHT:
					player.right();
					if(game.getSquares()[game.getPlayer().getRow()][game.getPlayer().getCol()] == 1) {
						player.left();
					}
				break;
				case KeyEvent.VK_UP:
					player.up();
						if(game.getSquares()[game.getPlayer().getRow()][game.getPlayer().getCol()] == 1) {
							player.down();
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