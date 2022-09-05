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
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import javax.swing.JPanel;

public class MissileBoard extends JPanel implements ActionListener {

	public Ship ship;
	public Timer timer;
	private final int DELAY = 25;
	private int x = 40, y = 140;
	public boolean ingame;
	//add aliens character
	private List<Alien> aliens;
	
	private final int[][] pos= {
			{2380,20},{2500,59},{1380,89},	
			{780,109},{580,139},{680,239},	
			{790, 259},{760, 50},{510,70},	
			{930,159},{590,80},{920,200},	
			{820,128},{490,170},{700,20}	
	};
	
	public MissileBoard() {
		addKeyListener(new keyboardInput());
		ship = new Ship(x, y);
		initAliens();
		ingame=true;
		setBackground(Color.BLACK);
		setFocusable(true);
		timer = new Timer(DELAY, this);
		timer.start();

	}

	private void initAliens() {
		aliens=new ArrayList<>();
		for(int[] p:pos) {
			aliens.add(new Alien(p[0],p[1]));
		}
		
	}

	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		if(ingame) {
			drawObjects(g);
		}else {
			drawGameOver();
		}
		//drawScreen(g);
		Toolkit.getDefaultToolkit().sync();
	}

	private void drawGameOver() {
		// TODO Auto-generated method stub
		
	}

	private void drawObjects(Graphics g) {
		
		//Graphics2D g2d = (Graphics2D) g;
		
		if(ship.isVisible()) {
			g.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
			
		}
		
		List <Missile> missiles=ship.getMissile();
		
		
		for(Missile missile:missiles) {
			if(missile.isVisible()) {
				g.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
			}
		}
		
		for(Alien alien:aliens) {
			
			if(alien.isVisible()) {
				
				g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
			}
		}
	}

//	private void drawScreen(Graphics g) {
//		
//		Graphics2D g2d = (Graphics2D) g;
//		
//	}

	public void updateMissiles() {
		
		List <Missile> missiles=ship.getMissile();
		
		for(int i=0;i<missiles.size();i++) {
			Missile missile=missiles.get(i);
			
			if(missile.isVisible()) {
				
				missile.move();
			}
			else {
				missiles.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		updateMissiles();
		updateShip();
		updateAliens();
		repaint();
	}

	private void updateAliens() {
		if(aliens.isEmpty()) {
			ingame=false;
			return;
		}
		
		for(int i=0;i<aliens.size();i++) {
			Alien a=aliens.get(i);
			if(a.isVisible()) {;
				a.move();
			}else {
				aliens.remove(i);
			}
		}
		
	}

	private void updateShip() {
		if(ship.isVisible()) {
			
			ship.move();
		}
		
	}

	private void step() {
		ship.move();
		repaint(ship.getX() - 1, ship.getY() - 1, ship.getWidth() + 2, ship.getHeight() + 2);
	}

	private class keyboardInput extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			ship.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			ship.keyReleased(e);
		}
	}
}
