package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class Ball implements Runnable{
	
	int x;
	int y;
	public int xDirection=1;
	public int yDirection=1;
	int p1score=0;
	int p2score=0;
	Rectangle b;
	
	Paddle paddle1=new Paddle(12, 25, 1);
	Paddle paddle2=new Paddle(480, 25, 2);
	
	public Ball(int x, int y){
		System.out.println("ball created");
		this.x=x;
		this.y=y;
		b=new Rectangle(this.x, this.y,15,15);
	}
	
	public void draw(Graphics g) {
		
		g.setColor(Color.red);
		g.fillOval(b.x, b.y, b.width, b.height);
	}
	
	public void move() {
		collision();
		b.x+=xDirection;
		b.y+=yDirection;
		
		if(b.x<=0) {
			xDirection=+1;
			p2score++;
		}
		
		if(b.x>=485) {
			xDirection=-1;
			p1score++;
		}
		
		if(b.y<=15) {
			yDirection=+1;
		}
		if(b.y>=385) {
			yDirection=-1;
		}
		
	}

	private void collision() {
		if (b.intersects(paddle1.paddle)){
			xDirection*=-1;
		}
		if (b.intersects(paddle2.paddle)){
			xDirection*=-1;
		}
		
	}

	@Override
	public void run() {
		while(true) {
			
			move();
			
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
