package graphicsdemo;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		frame.setVisible(true);
		
		JPanel panel=new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLUE);
				g.fillRect(0, 0, 100, 100);
			}
			
		};
		frame.add(panel);
		frame.validate();
		frame.repaint();

	}

}
