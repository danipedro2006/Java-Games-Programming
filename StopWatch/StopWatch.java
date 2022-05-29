package SafeCode;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StopWatch extends JFrame{
	
	JButton startButton=new JButton();
	JButton stopButton=new JButton();
	JLabel startLabel=new JLabel();
	JTextField startTextField=new JTextField();
	JTextField stopTextField=new JTextField();
	
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
		
		startLabel.setText(" Start time ");
		gridConstraints.gridx=1;
		gridConstraints.gridy=0;
		getContentPane().add(startLabel, gridConstraints);
		
		
		
		startTextField.setText("");
		gridConstraints.gridx=2;
		gridConstraints.gridy=0;
		startTextField.setColumns(15);
		getContentPane().add(startTextField, gridConstraints);
		
		stopTextField.setText("");
		gridConstraints.gridx=2;
		gridConstraints.gridy=1;
		stopTextField.setColumns(15);
		getContentPane().add(stopTextField, gridConstraints);
		
		startButton.addActionListener(new ActionListener() {
			private long startTime;

			public void actionPerformed(ActionEvent e) {
				startButtonActionPerformed(e);
			}

			private void startButtonActionPerformed(ActionEvent e) {
				startTime=System.currentTimeMillis();
				startTextField.setText(String.valueOf(startTime));
				
			}

			
		});
	}
	
	
	
	
	public static void main(String[] args) {
		new StopWatch().show();
		
		 
		 
	}
	
}
