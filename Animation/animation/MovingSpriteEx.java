package animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MovingSpriteEx extends JFrame{
	
	public MovingSpriteEx() {
		//add(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Moving Sprite");
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			MovingSpriteEx frame = new MovingSpriteEx();
			//frame.add(new Board());
			frame.setVisible(true);
		});
	}

}
