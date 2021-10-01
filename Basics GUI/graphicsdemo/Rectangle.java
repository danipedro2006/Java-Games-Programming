package graphicsdemo;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle {
	int width;
	int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, width, height);
	}
}
