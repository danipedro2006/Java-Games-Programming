package graphicsdemo;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerExample extends Frame implements MouseMotionListener  {
		Label label;
	 public MouseMotionListenerExample() {
		addMouseMotionListener(this);
		setSize(300,300);
		setVisible(true);
				
		
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g=getGraphics();
		g.setColor(Color.BLUE);
		g.fillOval(e.getX(), e.getY(), 1, 1);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		new MouseMotionListenerExample();
	}
}
