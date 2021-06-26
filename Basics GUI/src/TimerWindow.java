import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class TimerWindow extends JFrame implements ActionListener{// create a window using JFrame
	
	private int start=1;
	private JButton jbtn;
	private Timer swingtimer;
	
	TimerWindow(int time){
		
		start+=time;
		
		setTitle("Timer Window");
		
		setLayout(new FlowLayout());
		
		setTimer();
		
		setSize(700,350);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setTimer() {
		
		jbtn=new JButton("StartingTimer...");//change the label button as time decreases
		
		swingtimer=new Timer(222, this);// create swing timer instance
		
		add(jbtn);
		
		swingtimer.start();
		
	}

	

	@Override
	public void actionPerformed(ActionEvent event) {
		
		 start--;
		 
		if(start>=1) {
			
			jbtn.setText("Time: "+start);
		}
		else {
			
			jbtn.setText("Timeout...Now, Close the Window");
			
			swingtimer.stop();
		}
	}
	
	public static void main(String[] args) {
		
		TimerWindow tw=new TimerWindow(5);

	}

}
