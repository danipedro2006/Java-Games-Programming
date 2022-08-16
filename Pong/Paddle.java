package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Paddle extends KeyAdapter implements Runnable {
	int x, y, id;
	int yDirection = 1;
	Rectangle paddle;

	Paddle(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
		paddle = new Rectangle(x, y, 10, 50);
	}

	public void draw(Graphics g) {
		switch (id) {
		case 1:
			g.setColor(Color.CYAN);
			g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
			break;

		case 2:
			g.setColor(Color.PINK);
			g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
			break;
		}
	}

	@Override
	public void run() {
		while (true) {
			move();
			try {
				Thread.sleep(7);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void move() {
		paddle.y += yDirection;

		if (paddle.y <= 15)
			paddle.y = 15;
		if (paddle.y >= 340)
			paddle.y = 340;
	}

	public void keyPressed(KeyEvent e) {
		switch (id) {
		default:
			System.out.println("key pressed");
			break;

		case 1:

			if (e.getKeyCode() == e.VK_W)
				yDirection = -1;

			if (e.getKeyCode() == e.VK_S)
				yDirection = 1;

			break;

		case 2:

			if (e.getKeyCode() == e.VK_UP)
				yDirection = -1;

			if (e.getKeyCode() == e.VK_DOWN)
				yDirection = 1;

			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (id) {
		default:
			System.out.println("key relesed");
			break;
		case 1:
			if (e.getKeyCode() == e.VK_W) {

				yDirection = 0;

				if (e.getKeyCode() == e.VK_S)

					yDirection = 0;

			}
			break;
		case 2:
			if (e.getKeyCode() == e.VK_UP)
				yDirection = 0;
			if (e.getKeyCode() == e.VK_DOWN)
				yDirection = 0;

			break;
		}
	}
}
