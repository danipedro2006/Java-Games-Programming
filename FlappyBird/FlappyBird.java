package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener {
	
	public static FlappyBird flappyBird;
	
	public final int WIDTH=800, HEIGHT=800;
	
	public Renderer renderer;
	public Rectangle bird;
	public int ticks, yMotion;
	 
	
	public ArrayList<Rectangle> columns;
	public Random rand;
	
	public FlappyBird() {
		
		JFrame jFrame=new JFrame();
		Timer timer=new Timer(20,this);
		jFrame.setSize(WIDTH,HEIGHT);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
		jFrame.setTitle("Flappy Bird");
		jFrame.setResizable(true);
		renderer=new Renderer();
		jFrame.add(renderer);
		timer.start();
		rand =new Random();
		bird=new Rectangle(WIDTH/2-10, HEIGHT/2-10, 20, 20);
		columns=new ArrayList<Rectangle>();
		
		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		ticks++;
		int speed =10;
		
		for(int i=0;i<columns.size();i++) {
			Rectangle column=columns.get(i);
			column.x-=speed;
		}
		
		if(ticks%2==0 && yMotion<15) {
			yMotion+=2;
		}
		
		for(int i=0;i<columns.size();i++) {
			Rectangle column=columns.get(i);
			if(column.x+column.width<0) {
				columns.remove(column);
				addColumn(false);
			}
			column.x-=speed;
		}
		
		bird.y+=yMotion;
		
		
		renderer.repaint();
	}
	
	
	public void addColumn(boolean start) {
		
		int width=80;
		int space =300;
		int height=50 +rand.nextInt(300);
		
		if(start) {
			columns.add(new Rectangle(WIDTH+width+columns.size()*300, HEIGHT-height-120, width, height));
			columns.add(new Rectangle(WIDTH+width+(columns.size()-1)*300, 0, width, HEIGHT-height-space));
		}
		else {
			columns.add(new Rectangle(columns.get(columns.size()-1).x+600, HEIGHT-height-120, width, height));
			columns.add(new Rectangle(columns.get(columns.size()-1).x, 0, width, HEIGHT-height-space));
		}
		

	}
	
	
	public void paintColumn(Graphics g, Rectangle column){
		
		g.setColor(Color.green.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}
	
	
public static void main(String[] args) {
	flappyBird=new FlappyBird();
	
}

public void repaint(Graphics g) {
	
	g.setColor(Color.CYAN);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	
	g.setColor(Color.ORANGE);
	g.fillRect(0, HEIGHT-120, WIDTH, 120);
	
	g.setColor(Color.GREEN);
	g.fillRect(0, HEIGHT-120, WIDTH, 20);
	
	g.setColor(Color.RED);
	g.fillRect(bird.x, bird.y, bird.width,bird.height);
	
	for(Rectangle column:columns) {
		paintColumn(g,column);
	}
	
}
}
