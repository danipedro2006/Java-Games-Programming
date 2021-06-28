package Tenis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	
	public Game() {

		KeyListener listener = new MyKeyListener();// create the listener, can be implemented also as anonymous class
		addKeyListener(listener);// register listener
		setFocusable(true);// allow to receive focus

	}

	public class MyKeyListener implements KeyListener {// this class will create listener object

		@Override
		public void keyPressed(KeyEvent e) {

			System.out.println("Key presed: " + KeyEvent.getKeyText(e.getKeyCode()));

		}

		@Override
		public void keyReleased(KeyEvent e) {

			System.out.println("Key released: " + KeyEvent.getKeyText(e.getKeyCode()));

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			setFocusable(true);
		}

	}

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.paint(g2d);
		racquet.paint(g2d);
		
	}

	public static void main(String[] args) throws InterruptedException {

		JFrame frame = new JFrame("Mini Tenis");

		Game game = new Game();

		frame.add(game);

		frame.setSize(300, 300);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {

			game.move();
			game.repaint();
			Thread.sleep(10);
		}

	}

	private void move() {
		ball.move();
		racquet.move();

	}

}
