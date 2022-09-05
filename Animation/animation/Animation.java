package animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Animation extends JFrame {

	public Animation() {
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Basic GUI");
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public static void main(String[] args) {
		Animation frame = new Animation();
		Board board = new Board();
		board.setSize(800, 600);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		frame.setMinimumSize(dim);
		frame.add(board);
	}

}

class Board extends JPanel implements ActionListener {
	
	public Image picture;
	public Timer timer;
	private int x=40, y=40;
	
	public Board() {
		ImageIcon ii = new ImageIcon("C://Users//danie//eclipse-workspace//java2d//resources//basketball.jpg");
		setBackground(Color.WHITE);
		picture = ii.getImage();
		timer=new Timer(25, this);
		timer.start();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(picture, x, y, null);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		x++;
		y++;
		repaint();
		
	}
}