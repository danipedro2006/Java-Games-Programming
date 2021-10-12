package ballcatch;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class PlayCatch extends JFrame {
	
	public PlayCatch() {
		getContentPane().setLayout(new FlowLayout());
		
		add(new CatchComponent());
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
//		JFrame frame=new JFrame();
//		CatchComponent component= new CatchComponent();
//		
//		frame.add(component);
//		///frame.addKeyListener(component);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(300,400);
//		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
		
		new PlayCatch();
	}
}
