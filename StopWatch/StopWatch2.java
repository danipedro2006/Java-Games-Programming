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
	JButton exitButton=new JButton();
	JLabel startLabel=new JLabel();
	JLabel stopLabel=new JLabel();
	JLabel elapsedLabel=new JLabel();
	JTextField startTextField=new JTextField();
	JTextField stopTextField=new JTextField();
	JTextField elapsedTextField=new JTextField();
	
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
		
		exitButton.setText("Exit");
		gridConstraints.gridx=0;
		gridConstraints.gridy=2;
		getContentPane().add(exitButton, gridConstraints);
		
		startLabel.setText(" Start time ");
		gridConstraints.gridx=1;
		gridConstraints.gridy=0;
		getContentPane().add(startLabel, gridConstraints);
		
		stopLabel.setText(" Stop time ");
		gridConstraints.gridx=1;
		gridConstraints.gridy=1;
		getContentPane().add(stopLabel, gridConstraints);
		
		elapsedLabel.setText(" Elapsed time ");
		gridConstraints.gridx=1;
		gridConstraints.gridy=2;
		getContentPane().add(elapsedLabel, gridConstraints);
		
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
		
		elapsedTextField.setText("");
		gridConstraints.gridx=2;
		gridConstraints.gridy=2;
		elapsedTextField.setColumns(15);
		getContentPane().add(elapsedTextField, gridConstraints);
		
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
		
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				exitButtonActionPerformed(e);
			}

			private void exitButtonActionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}

			
		});
	}
	
	
	
	
	public static void main(String[] args) {
		new StopWatch().show();
		
		 
		 
	}
	
}
