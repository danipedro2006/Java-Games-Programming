import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//show how to trigger an action in terms of repeated display message
//timeout will be displayed when the timer stops

public class SwingTimerTrigger {
	
	 static class SwingTimerActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			
			System.out.println("Timer is ticking..");//action event is triggered by display of message
		}

	}

	public static void main(String[] args) {
		
		Timer swingtimer=new Timer(1111, new SwingTimerActionListener());
		
			swingtimer.start();//timer started
			
			try {
				
				Thread.sleep(5555);
				
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		System.out.println("Timeout");
			
		};

	}


