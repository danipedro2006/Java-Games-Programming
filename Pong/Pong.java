package Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Pong extends JFrame {

	int gWidth = 500;
	int gHeight = 400;
	Image dbImage;
	Graphics dbGraphics;
	Dimension screenSize = new Dimension(gWidth, gHeight);

	public static Ball ball = new Ball(250, 250);

	public Pong() {
		this.setTitle("Pong");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(screenSize);
		this.addKeyListener(new PKeyListener());
	}

	@Override
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbGraphics = dbImage.getGraphics();
		draw(dbGraphics);
		g.drawImage(dbImage, 0, 0, this);
	}

	public void draw(Graphics g) {
		ball.draw(g);
		ball.paddle1.draw(g);
		ball.paddle2.draw(g);
		repaint();
	}

	public static void main(String[] args) {

		Pong p = new Pong();
		Thread b = new Thread(ball);
		b.start();
		Thread p1 = new Thread(ball.paddle1);
		Thread p2 = new Thread(ball.paddle2);
		p1.start();
		p2.start();

	}

	class PKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				ball.paddle1.keyPressed(e);
				ball.paddle2.keyPressed(e);
					}
		@Override
		public void keyReleased(KeyEvent e) {
			
				ball.paddle1.keyReleased(e);
				ball.paddle2.keyReleased(e);
		}
	}
}
