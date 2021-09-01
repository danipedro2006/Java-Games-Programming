import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Pinball extends JPanel {

	int ctr = 0;
	double G = 0.1;// Gravitational constant
	final int xPos = 280;

	int points = 0;
	int lives = 0;
	int sides = 13;

	double paddle = 130;
	double snorm = 400;
	double sd = 450;
	double sv = 0;
	boolean setlock = false;

	double rtheta = 0;// paddle rotation
	double ltheta = 0;
	boolean rdown, ldown;//right key, left key pressed
	double[] p2d = { 280, 200 };
	double[] v2d = { 0, 0 };

	int[][] preset = {

			{ 0, 400, 135, 450, 1 }, { 135, 450, 270, 400, 1 }, { 270, 0, 300, 20, 1 }, { 291, 0, 291, 500, 1 },
			{ -1, 0, 270, 0, 1 }, { 0, -1, 0, 500, 1 } };

	int[][] ball = { { 80, 80, 30, 50 }, { 230, 280, 20, 200 }, { 50, 200, 25, 100 }, { 200, 100, 10, 500 }, };

	int lines[][] = new int[100][5];

	public Pinball() {
		super();
		addKeyListener(new Key());
		setFocusable(true);
		// t
		for (int i = 0; i < preset.length; i++) {
			lines[i] = preset[i];
		}

		int plen = preset.length;

		int ct = 0;

		for (int k = 0; k < ball.length; k++) {

			int px = ball[k][0], py = ball[k][1], radius = ball[k][2];

			for (double i = 0; i < 2 * Math.PI; i += 2 * Math.PI / sides) {
				ct++;
				lines[plen + ct][0] = px + (int) (radius * Math.cos(i));
				lines[plen + ct][1] = py + (int) (radius * Math.sin(i));
				lines[plen + ct][2] = px + (int) (radius * Math.cos(i - 2 * Math.PI / sides));
				lines[plen + ct][3] = py + (int) (radius * Math.sin(i - 2 * Math.PI / sides));

			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		v2d[1] += G;
		p2d[1] += v2d[1];
		p2d[0] += v2d[0];

		double rc = 0.1;

		if(rdown) {
			rtheta=Math.max(-0.5, rtheta-rc);
		}
		else {
			rtheta=Math.max(0.5, rtheta+rc);
		}

		if(ldown) {
			ltheta=Math.max(-0.5, ltheta-rc);
			System.out.println("left key pressed");
		}
		else {
			ltheta=Math.max(0.5, ltheta+rc);
		}


		// draw paddles
		lines[0][2] = lines[0][0] + (int) (Math.cos(ltheta) * paddle);
		lines[0][3] = lines[0][1] + (int) (Math.sin(ltheta) * paddle);
		lines[1][0] = lines[1][2] + (int) (-Math.cos(rtheta) * paddle);
		lines[1][1] = lines[1][3] + (int) (Math.sin(rtheta) * paddle);

		// draw ball

		int rX = (int) p2d[0];
		int rY = (int) p2d[1];
		int r = 10;
		g.setColor(Color.blue);
		g.drawArc(rX - r, rY - r, 2 * r, 2 * r, 0, 360);

		// draw box
		g.setColor(Color.black);
		for (int i = 0; i < lines.length; i++) {
			int x1 = lines[i][0], y1 = lines[i][1], x2 = lines[i][2];
			double y2 = lines[i][3] + 0.0001;
			if (i > preset.length) {
				g.setColor(Color.red);
			}

			g.drawLine(x1, y1, x2, (int) Math.round(y2));
			g.setColor(Color.black);
			g.fillRect(xPos - 5, (int) sd + 10, 10, 20);
		}

	}

	private class Key extends KeyAdapter{

		public  void keyPresed(KeyEvent e) {

			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setlock=true;
				sd+=2;
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				ldown=true;
				System.out.println("left key presssed");
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				rdown=true;
			}
		}

		public  void keyReleased(KeyEvent e) {

			setlock=false;

			if(e.getKeyCode()==KeyEvent.VK_LEFT) {
				ldown=false;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
				rdown=false;
			}
		}
	}
}
