import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

	public static void main(String[] args) {

		JFrame frame=new JFrame();
		frame.setSize(1920,1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pinball panel=new Pinball();
		frame.add(panel);
		frame.setVisible(true);
	}
}
