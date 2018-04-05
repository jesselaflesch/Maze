
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
	private Enemy enemy;
	private Item[] items;
	private Game myGame;
	private MainPanel panel;
	private Timer timer = new Timer(400, new TimerListener());
	private Font font = new Font("New Times Roman", Font.BOLD, 20);
	
	public Movement(Player player, Enemy enemy, Item[] items, MainPanel panel, Game myGame){
		this.player = player;
		this.enemy = enemy;
		this.items = items;
		this.myGame = myGame;
		this.panel = panel;
	}
	
	public void startTimer() {timer.start();}
	
	private class TimerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0){
			
//			for (int i = 0; i < items.length; i++) {
//				deal with null point items[]
//				int[] playerWithItem = {player.getXLoc(), player.getXLoc() + player.getImageWidth(),
//											player.getYLoc(), player.getYLoc() + player.getImageHeight(),
//											items[i].getXLoc(), items[i].getXLoc() + items[i].getImageWidth(),
//											items[i].getYLoc(), items[i].getYLoc() + items[i].getImageHeight(),};
//				if (haveCollided(playerWithItem)) {
//					;//Then we get to pick up the item~~~
//				}
//			}
			panel.repaint();
		}
	}
	
	public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					player.left();break;
				case KeyEvent.VK_S:
					player.down(); break;
				case KeyEvent.VK_D:
					player.right(); break;
				case KeyEvent.VK_W:
					player.up();	 break;
			}
			panel.repaint();
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}