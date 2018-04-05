import javax.swing.JFrame;

public class MainFrame {

	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("Maze");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//MainPanel myPanel = new MainPanel();
		//myFrame.getContentPane().add(myPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}