package Pong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

public class Pong extends JFrame {
	
	int gWidth=500;
	int gHeight=400;
	Image dbImage;
	Graphics dbGraphics;
	Dimension screenSize=new Dimension(gWidth, gHeight);
	
	static Ball ball=new Ball(250,250);
	
	public Pong() {
		this.setTitle("Pong");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(screenSize);
	}
	
	@Override
	public void paint (Graphics g) {
		dbImage=createImage(getWidth(), getHeight());
		dbGraphics=dbImage.getGraphics();
		draw(dbGraphics);
		g.drawImage(dbImage, 0, 0,this);
	}
	
	public void draw(Graphics g) {
		ball.draw(g);
		repaint();
	}
	
	
	public static void main(String[] args) {
		
		Pong p=new Pong();
		Thread b=new Thread(ball);
		b.start();
		
	}
}
