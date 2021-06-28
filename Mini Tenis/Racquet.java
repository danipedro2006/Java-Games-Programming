package Tenis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Racquet {

	int x = 0;
	int xa = 2;
	
	
	private Game game;

	public Racquet(Game game) {

		this.game = game;
	}

	void move() {
		if(x+xa>0 && x+xa>game.getWidth()-60 ) {
			x=x+xa;
		}
		
		
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		g.fillRect(x, 330, 60, 10);

	}
	
	public void KeyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==e.VK_LEFT) xa=-1;
		
		if(e.getKeyCode()==e.VK_RIGHT) xa=1;
	}
}