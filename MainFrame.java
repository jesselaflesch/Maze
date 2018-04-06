
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import javax.swing.JFrame;

public class MainFrame {
	
	public static File[] mazeFiles = {new File("./src/mazes/maze3.txt"), new File("./src/mazes/maze4.txt")};
	public static Random randMaze = new Random();
	public static int GAME_ROWS = 12, GAME_COLS = 26;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Randomly choosing one of two mazes		
		File maze = mazeFiles[randMaze.nextInt(2)];
		
		
		//Making the Frame
		JFrame myFrame = new JFrame("Maze");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel myPanel = new MainPanel(maze);
		myFrame.getContentPane().add(myPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}