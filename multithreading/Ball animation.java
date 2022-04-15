package ball;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bouncer extends Applet implements ActionListener{
	private Button start, stop, stare;
	private Ball firExecutie[]=new Ball[10];
	private static int numarFirExecutie=-1;
	private int count=0;
	public void init() {
		start =new Button("Start");
		add(start);
		start.addActionListener(this);
		stop =new Button("Stop");
		add(stop);
		stop.addActionListener(this);
		
		stare =new Button("Stare");
		add(stare);
		stare.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==start)
			if(numarFirExecutie<9) {
				Graphics g=getGraphics();
				numarFirExecutie++;
				firExecutie[numarFirExecutie]=new Ball(g);
				firExecutie[numarFirExecutie].start();
			}
		
		if(event.getSource()==stop)
			if(numarFirExecutie>=0) {
				Graphics g=getGraphics();
				firExecutie[numarFirExecutie--].stopBall();;
			}
		
		if(event.getSource()==stare && numarFirExecutie>=0) {
			count++;
			Graphics g=getGraphics();
			if(firExecutie[numarFirExecutie].isAlive())
				g.drawString("The ball "+numarFirExecutie+" is alive "+20, 150, count*15);
			else {
				g.drawString("The ball "+numarFirExecutie+" is not alive "+20, 150, count*15);
			}
		}
	}
}

class Ball extends Thread
{
	private boolean keepGoing;
	private Graphics g;
	private int x=37, xChange=7;
	private int y=32, yChange=2;
	private int diameter=10;
	private int rectLeftX=30, rectRightX=130;
	private int rectTopY=30, rectBottomY=130;
	
	public Ball (Graphics graphics) {
		g=graphics;
		keepGoing=true;
	}
	
	public void stopBall() {
		keepGoing=false;
	}
	
	public void run() {
		g.drawRect(rectLeftX, rectTopY, rectRightX-rectLeftX+10, rectBottomY-rectTopY+10);
	while(keepGoing) {
		g.setColor(Color.white);
		g.fillOval(x, y, diameter, diameter);
		if(x+xChange<=rectLeftX) xChange=-xChange;
		if(x+xChange>=rectRightX) xChange=-xChange;
		if(y+yChange<=rectTopY) yChange=-yChange;
		if(y+yChange>=rectBottomY) yChange=-yChange;
		x=x+xChange;
		y=y+yChange;
		g.setColor(Color.red);
		g.fillOval(x, y, diameter, diameter);
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}