package ballcatch;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CatchComponent extends JComponent   implements KeyListener{
	
	Ball ball;
	Bucket bucket;
	
	public CatchComponent() {
		this.ball=new Ball(10, 10,true);
		this.bucket=new Bucket(50,100);
		
		Timer timer= new Timer(50, new ActionListener() {
 			@Override
			public void actionPerformed(ActionEvent e) {
 				
 				ball=ball.moveDown();
 				repaint();
				
			}
 		});
		
		timer.start();
	}
	public void keyPressed(KeyEvent e) {
		System.out.println("left");
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			bucket.moveLeft();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			bucket.moveRight();
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			bucket.moveLeft();
		}
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			bucket.moveLeft();
		}
		
	}

	public void keyTyped(KeyEvent arg0) {
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ball.draw(g);
		bucket.draw(g);
	}
public static void main(String[] args) {
	
	JFrame frame=new JFrame();
	CatchComponent component= new CatchComponent();
	
	frame.add(component);
	frame.addKeyListener(component);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(300,400);
	//frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
}

}
