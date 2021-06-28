package Tenis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball {

	int x = 0;
	int y = 0;
	int xa = 2;
	int ya = 2;
	
	private Game game;

	public Ball(Game game) {

		this.game = game;
	}

	void move() {
		if(x+xa<0) {
			xa=2;
		}
		if(x+xa>game.getWidth()-30) {
			xa=-1;
		}
		if(y+ya<0) {
			ya=1;
		}
		
		if(y+ya>game.getHeight()-30) {
			ya=-1;
		}
		x=x+xa;
		y=y+ya;
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g2d.fillOval(x, y, 30, 30);

	}
}
