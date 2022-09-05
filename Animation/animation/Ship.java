package animation;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Ship extends Sprite {
	private int dx;
	private int dy;
	private List<Missile> missiles;

	public Ship(int x, int y) {
		super(x, y);
		initShip();
	}

	private void initShip() {
		missiles = new ArrayList<>();
		loadImage("C://Users//danie//eclipse-workspace//java2d//resources//craft.png");
		getImageDimensions();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void move() {
		x += dx;
		y +=dy;
	}

	public List<Missile> getMissile() {
		return missiles;
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) 
			dx = -2;
		
		if (key == KeyEvent.VK_RIGHT)
			dx = 2;
		
		if (key == KeyEvent.VK_UP)
			dy = -2;
		
		if (key == KeyEvent.VK_DOWN) 
			dy = 2;
		
		if (key == KeyEvent.VK_SPACE)
			fire();
	}

	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT)
			dx = 0;
		if (key == KeyEvent.VK_RIGHT)
			dx = 0;
		if (key == KeyEvent.VK_UP)
			dy = 0;
		if (key == KeyEvent.VK_DOWN)
			dy = 0;
	}

	private void fire() {
		missiles.add(new Missile(x + width, y + height / 2));
	}

}
