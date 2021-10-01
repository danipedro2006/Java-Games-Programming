package graphicsdemo;

import java.awt.Color;
import java.awt.Graphics;

public class Circle {
	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}
	public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(100, 100, radius, radius);
	}
}
