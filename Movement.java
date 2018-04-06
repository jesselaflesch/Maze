
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;

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
	
	public void startTimer() {timer.start();}
	
	private class TimerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0){panel.repaint();}
	
	}
	
	public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (game.getSquares()[game.getPlayer().getRow()][game.getPlayer().getCol() - 1] == 1) {break;}
					else {player.left();break;}
				case KeyEvent.VK_DOWN:
					if (game.getSquares()[game.getPlayer().getRow() + 1][game.getPlayer().getCol()] == 1) {break;}
					else {player.down();break;}
				case KeyEvent.VK_RIGHT:
					if (game.getSquares()[game.getPlayer().getRow()][game.getPlayer().getCol() + 1] == 1) {break;}
					else {player.right();break;}
				case KeyEvent.VK_UP:
					if (game.getSquares()[game.getPlayer().getRow() - 1][game.getPlayer().getCol()] == 1) {break;}
					else {player.up();break;}
			}
			panel.repaint();
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}