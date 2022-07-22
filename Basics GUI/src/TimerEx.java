package swing;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import  javax.swing.Timer;

import javax.swing.JFrame;

public class TimerEx extends Frame{
	
	static Timer myTimer;

	public static void main(String[] args) {
		TimerEx frame=new TimerEx();
		frame.setSize(400,300);
		frame.setVisible(true);
		
		int delay=1000;
		
		myTimer=new Timer(delay,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("tic-tac");
				Random random=new Random();
				Color color;
				//Toolkit.getDefaultToolkit().beep();
				color=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
				frame.setBackground(color);
			}
			
		});
		myTimer.start();
	}
}
