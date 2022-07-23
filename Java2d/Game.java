package swing;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame {
	
	Game(){
		MyPanel panel=new MyPanel();
		this.add(panel);
		this.setSize(300,300);
		this.setVisible(true);
	}
	
	/*
	 * public void paint(Graphics g) {
	 * 
	 * Graphics2D g2d=(Graphics2D) g; g2d.drawLine(0, 0, 300, 300); }
	 */
	

}
