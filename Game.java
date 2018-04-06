
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private MainPanel panel;
	private int square[][] = new int[MainFrame.GAME_ROWS][MainFrame.GAME_COLS];
	private Scanner fileScanner, lineScanner;
	private Random randSquare = new Random();
	private String line;
	private Player player;
	private Item[] items = new Item[15];
	private ArrayList<Block> blocks = new ArrayList<Block>();
	
	public Game(MainPanel panel, File maze) throws FileNotFoundException {
		this.panel = panel;
		this.player = new Player("Link", "./src/images/player.png", 0, 0);
		fileScanner = new Scanner(maze);
		
		//Parsing through the maze file and creating Blocks for it
		int row = 0;
		do{
			line = fileScanner.nextLine();
			lineScanner = new Scanner(line);
			lineScanner.useDelimiter(",");
			int currentSquare;
			
			for (int col=0; col<MainFrame.GAME_COLS;col++){
				currentSquare = Integer.parseInt(lineScanner.next());
				square[row][col] = currentSquare;
				
				if (currentSquare == 1){
					blocks.add(new Block("Block", "./src/images/block.png", col * 50, row * 50, row, col));
				}
			}
			
			row++;
		} while(fileScanner.hasNextLine());
		
		//Creating the items and putting them in the blank spaces
		for (int i = 0; i < items.length; i++){
			boolean available = false;
			int r = 0, c = 0;

			while (available == false){
				r = randSquare.nextInt(MainFrame.GAME_ROWS); 
				c = randSquare.nextInt(MainFrame.GAME_COLS);
				if (square[r][c] == 0) {
					available = true;
					square[r][c] = 3;
					}
			}	
			
			items[i] = new Item("Rupee", "./src/images/item.png", 50 * c, 50 * r, r, c);
		}
	}
	
	
	public Player getPlayer() {
		return player;
	}
	
	public Item[] getItems() {
		return items;
	}
	
	public ArrayList<Block> getBlocks(){
		return blocks;
	}
	
	public int[][] getSquares() {
		return square;
	}
	
}
