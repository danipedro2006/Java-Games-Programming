package animation;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class ShootMissiles extends JFrame{
	
	public ShootMissiles() {
		add(new MissileBoard());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Shooting Missiles");
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			ShootMissiles frame = new ShootMissiles();
			//frame.add(new Board());
			frame.setVisible(true);
		});
	}

}