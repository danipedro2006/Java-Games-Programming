package graphicsdemo;

import javax.swing.JFrame;

public class App2 {

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		frame.setVisible(true);
		myPanel panel=new myPanel();
		frame.add(panel);
		
		frame.validate();
		frame.repaint();
	}

}
