import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;




public class SwingTimerDemo {
	 
	public static void main(String[] args) {
		
		ActionListener tictac=new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				System.out.println("Swing timer started");
			}
		};
		
		Timer timer=new Timer(555, tictac);
		timer.setRepeats(false);
		timer.start();
		try {
			Thread.sleep(55555);
			System.out.println(("Timeout"));
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
