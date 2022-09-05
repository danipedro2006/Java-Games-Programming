package animation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {

	public SpaceShip spaceShip;
	public Timer timer;
	private final int DELAY = 25;
	private int x = 40, y = 40;
	
	public Board() {
		addKeyListener(new keyboardInput());
		spaceShip = new SpaceShip();
		setBackground(Color.BLACK);
		setFocusable(true);
		timer = new Timer(DELAY, this);
		timer.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawScreen(g);
	}

	private void drawScreen(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(spaceShip.getImage(), spaceShip.getX(), spaceShip.getY(), this);
		Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		step();

	}

	private void step() {
		spaceShip.move();
		repaint(spaceShip.getX() - 1, spaceShip.getY() - 1, spaceShip.getWidth() + 2, spaceShip.getHeight() + 2);
	}

	private class keyboardInput extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("key react");
			spaceShip.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			spaceShip.keyReleased(e);
		}
	}
}
