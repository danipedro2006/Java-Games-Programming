package reversi;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class Reversi extends Canvas implements MouseListener {
	
	private Rectangle[][] boxes;
	private int[][] pieces;
	
	public Reversi() {
		addMouseListener(this);
		boxes=new Rectangle[6][6];
		pieces=new int[6][6];
		for(int r=0;r<boxes.length;r++) {
			for(int c=0;c<boxes[0].length;c++) {
				boxes[r][c]=new Rectangle(10+c*50, 50+r*50,50,50);
				pieces[3][3]=2;
				pieces[3][4]=1;
				pieces[4][3]=1;
				pieces[4][4]=2;
			}
		}
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame("Reversi");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new Reversi());
		frame.setVisible(true);
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 400, 400);
		
		//board
		
		for(int r=0;r<boxes.length;r++) {
			for(int c=0;c<boxes[0].length;c++) {
				g.setColor(Color.BLACK);
				Rectangle box=boxes[r][c];
				g.fillOval(box.x+5, box.y+5, box.width-10, box.height-10);	
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
