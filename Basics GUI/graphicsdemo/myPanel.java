package graphicsdemo;

import java.awt.Graphics;

import javax.swing.JPanel;

public class myPanel extends JPanel{
	Rectangle blueRectangle=new Rectangle(50,50);
	Circle circle=new Circle(50);
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		blueRectangle.paint(g);
		circle.paint(g);
	}

}
