
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	private Player player;
	private Enemy enemy;
	private Item[] items = new Item[10];
	private Game myGame;
	private Movement movement;
	private Scanner fileScanner, lineScanner;
	private Random randLoc = new Random();
	final private int GAME_HEIGHT = 500, GAME_WIDTH = 1000;
	
	public MainPanel(File levelFile, Game myGame){
		//this.player = new Player();
		//this.enemy = new Enemy();
		//this.myGame = myGame;
		
		///for (int i=0; i<10; i++) {this.items[i] = new Item(itemName, itemImagePath, randLoc.nextint());}
		
		this.movement = new Movement(player, enemy, items, this, this.myGame);
		addKeyListener(movement);
		
		setPreferredSize(new Dimension(GAME_WIDTH,GAME_HEIGHT));
		setLayout(new BorderLayout());
		setFocusable(true);
		
		movement.startTimer();
		repaint();
	}
	
	public void paintComponent(Graphics page){
		super.paintComponent(page);
		page.drawImage(player.getImage(), player.getXLoc(), player.getYLoc(), null);
		page.drawImage(enemy.getImage(), enemy.getXLoc(), enemy.getYLoc(), null);
		
		for(int i = 0; i < items.length; i++){
			if (items[i] == null) {continue;}
			else {page.drawImage(items[i].getImage(), items[i].getXLoc(), items[i].getYLoc(), null);}
		}
	}
}