package graphicsdemo;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerExample extends Frame implements MouseListener {
	Label label;
	 public MouseListenerExample() {
		addMouseListener(this);
		label=new Label();
		add(label);
		label.setBounds(20,50,100,100);
		label.setBackground(Color.YELLOW);
		setSize(300,300);
		setLayout(null);
		setVisible(true);
				
		
		
	}

	public static void main(String[] args) {
		new MouseListenerExample();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
			label.setText("Mouse clicked");
			Graphics g=getGraphics();
			g.setColor(Color.BLUE);
			g.fillOval(e.getX(), e.getY(), 30, 30);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		label.setText("Mouse enter");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		label.setText("Mouse exit");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		label.setText("Mouse pressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		label.setText("Mouse released");
		
	}

	
}
