import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KeyboardExample extends JPanel{
	
	public KeyboardExample() {
		
		KeyListener listener=new MyKeyListener();//create the listener, can be implemented also as anonymous class
		addKeyListener(listener);//register listener
		setFocusable(true);//allow to receive focus
	}
	public class MyKeyListener implements KeyListener{//this class will create listener object

		@Override
		public void keyPressed(KeyEvent e) {
			
			System.out.println("Key presed: "+KeyEvent.getKeyText(e.getKeyCode()));
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			System.out.println("Key released: "+KeyEvent.getKeyText(e.getKeyCode()));
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) {
		JFrame frame=new JFrame("Mini Tenis");
		KeyboardExample keyboardExample=new KeyboardExample();
		frame.add(keyboardExample);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
