package bricksbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements KeyListener, ActionListener{
	
	private boolean play=false;
	private int score=0;
	private int totalBricks=21;
	private Timer timer;
	private int delay=8;
	private int playerX=310;
	private int ballposX=120;
	private int ballposY=350;
	private int ballXdir=-1;
	private int ballYdir=-2;
	
	public GamePlay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay, this);
		timer.start();
	}
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(1, 1, 692, 592);
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(680 , 0, 3, 592);
		g.setColor(Color.blue);
		g.fillRect(playerX, 550, 100, 8);
		g.setColor(Color.green);
		g.fillOval(ballposX, ballposY, 20, 20);
		g.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		timer.start();
		repaint();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(playerX>=600) {
				playerX=600;
			}
			else {
				moveRight();
			}
		}
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			if(playerX<=10) {
				playerX=10;
			}
			else {
				moveLeft();
			}
		}
	}

	private void moveLeft() {
		// TODO Auto-generated method stub
		play=true;
		playerX-=20;
	}
	private void moveRight() {
		// TODO Auto-generated method stub
		play=true;
		playerX+=20;
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		play=true;
		playerX+=-20;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
