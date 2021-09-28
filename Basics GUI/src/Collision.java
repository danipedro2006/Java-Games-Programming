package collision;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Collision extends JFrame {
	int x=100;
//	public Collision() {
//		setSize(300,400);
//		setVisible(true);
//		setFocusable(true);
//	}
	
public void paint(Graphics g) {
	x++;
	g.setColor(Color.black);
	g.fillOval(x, 100, 50, 50);
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	g.setColor(Color.white);
	g.fillOval(x, 100, 50, 50);
}

private static void loop(JFrame frame) {
	
	while(true) {
		frame.repaint();
	}
	
}
	public static void main(String[] args) {
		JFrame frame=new Collision();
		frame.setSize(300,400);
		frame.setVisible(true);
		loop(frame);
	}
	

}
