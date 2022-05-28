package SafeCode;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StopWatch extends JFrame{
	
	JButton startButton=new JButton();
	JButton stopButton=new JButton();
	
	public StopWatch() {
		
		setTitle("StopWatch");
		setSize(300,100);
		
		getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints gridConstraints=new GridBagConstraints();
		
		startButton.setText("Start");
		gridConstraints.gridx=0;
		gridConstraints.gridy=0;
		getContentPane().add(startButton, gridConstraints);
		
		stopButton.setText("Stop");
		gridConstraints.gridx=0;
		gridConstraints.gridy=1;
		getContentPane().add(stopButton, gridConstraints);
	}
	public static void main(String[] args) {
		new StopWatch().show();
		
		 
		 
	}
	
}
