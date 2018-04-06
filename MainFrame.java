
// Authors: Ian Gonzales & Jesse LaFlesch	Date: 6 April 2018	File: MainFrame.java
// Purpose: The Main Frame for the Maze.		

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import javax.swing.JFrame;

public class MainFrame {
	
	public static File[] mazeFiles = {new File("./src/mazes/maze3.txt"), new File("./src/mazes/maze4.txt")};
	public static Random randMaze = new Random();
	public static int GAME_ROWS = 12;
	public static int GAME_COLS = 26;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Selecting the maze
		File maze = mazeFiles[randMaze.nextInt(2)];
		
		// Making the frame
		JFrame myFrame = new JFrame("Maze");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainPanel myPanel = new MainPanel(maze);
		myFrame.getContentPane().add(myPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}