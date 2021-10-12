package ballcatch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CatchComponent extends JComponent   implements KeyListener, Runnable {
	
	CatchEngine engine;
	
	public CatchComponent() {
		super();
		engine=new CatchEngine();
		setPreferredSize(new Dimension(engine.WIDTH,engine.HEIGHT));
		addKeyListener(this);
//		Timer timer= new Timer(50, new ActionListener() {
// 			@Override
//			public void actionPerformed(ActionEvent e) {
// 				
// 				engine.moveDown();
// 				engine.testBallCatch();
// 				repaint();
//				
//			}
// 		});
//		
//		timer.start();
		
		Thread run=new Thread(this);
		run.start();
	}
	
	public void gameLoop() {
		while(true) {
			requestFocus();
			updateState();
			repaint();
		}
	}
	private void updateState() {
		engine.update();
		
	}

	public void paint(Graphics g) {
		//super.paintComponent(g);
		engine.draw(g);
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.println("left");
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			engine.moveLeft();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			engine.moveRight();
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent arg0) {
	}
	
	
	


@Override
public void run() {
	gameLoop();
	
}


}
