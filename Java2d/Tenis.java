package swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tenis extends JPanel {
	
	
	public int x=0;
	public int y=0;
	
	private void move(){
		x=x+1;
		y=y+1;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d=(Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillOval(x,y,50,50);
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame=new JFrame("Tenis");
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tenis tenis=new Tenis();
		frame.add(tenis);
		
		while (true) {
			
		tenis.move();
		tenis.repaint();
		Thread.sleep(10);
		}
	}

}
