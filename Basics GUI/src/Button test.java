package awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEx {

	public static void main(String[] args) {
		
		JFrame f=new JFrame("Button");
		
		f.setVisible(true);
		f.setLayout(null);
		f.setSize(300,400);
		
		JButton b=new JButton("Click!");
		b.setBounds(50,100,80,30);
		b.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Button clicked!");
				b.setText("Done");
			}
			
		});
		f.add(b);
	}
}
