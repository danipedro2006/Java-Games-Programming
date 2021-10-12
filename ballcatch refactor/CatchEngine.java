package ballcatch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class CatchEngine {
	public final int HEIGHT = 300;
	public final int WIDTH = 300;
	private Bucket bucket;
	private Vector<Ball> balls;
	private int score=0;
	private int lives=3;
	
public CatchEngine() {
	balls=new Vector();
	this.bucket=new Bucket(50,100);
}

public void addBall() {
	balls.add(new Ball((int)(Math.random()*WIDTH), 0, Math.random()>0.5));
}
public void testBallCatch() {
	for(int i=0;i<balls.size();i++) {
		if(bucket.contains(balls.get(i))) {
			if(balls.get(i).isGood()) {
				score++;
			}
			else
				lives--;
			balls.remove(i);
			i--;
		}
		else if(balls.get(i).getLocation().getY()>=HEIGHT+Ball.RADIUS) {
			if(balls.get(i).isGood()) {
				lives--;
				balls.remove(i);
				i--;
			}
		}
	}
	
}

public void drawScore(Graphics g) {
	g.setColor(Color.BLACK);
	g.drawString("Points: "+score, 10, 20);
}

public void moveLeft() {
	bucket.moveLeft();
}


public void moveRight() {
	bucket.moveRight();
}


public void moveBalls() {
	for(int i=0;i<balls.size();i++) {
		balls.add(i,balls.get(i).moveDown());
		balls.remove(i+1);
	}
	
}

public void draw(Graphics g) {
	for(int i=0;i<balls.size();i++) {
		balls.get(i).draw(g);
	}
	bucket.draw(g);
	drawScore(g);
}


public void update() {
	//addBall();
	moveBalls();
	testBallCatch();
	
}
}