package graphicsdemo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawCar extends JPanel{
	private static final int width=800;
	private static final int  height=600;
	List<Car> cars;
	
	public DrawCar() {
		cars=new ArrayList<>();
		cars.add(new Car(100,200));
		cars.add(new Car(300,300));
		Timer timer=new Timer(50, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Car car:cars) {
					car.move();
					repaint();
				}
			}
		});
		timer.start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Car car:cars) {
			car.drawCar(g);
		}
	}
	public class Car {
		private int increment=5;
		int x, y;
		
		public Car(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void drawCar(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, 100, 30);
			g.setColor(Color.BLACK);
			g.fillOval(x+15, y+20, 15, 15);
			g.fillOval(x+60, y+20, 15, 15);
			g.fillRect(x+15, y-20, 60, 20);
		}
		
		public void move() {
			if(x==width) {
				x=0;
			}
			else {
				x+=increment;
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.add(new DrawCar());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		//frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
