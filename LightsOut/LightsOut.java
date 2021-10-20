package lightsout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LightsOut  extends JFrame implements ActionListener{
	
	
	private JButton[][] gameButtons;
	private JButton manual;
	private JLabel wins;
	private int winCount;
	
	public LightsOut() {
		setSize(500,500);
		JPanel mainPanel=new JPanel();
		JPanel buttonPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		gameButtons=new JButton[5][5];
		buttonPanel.setLayout(new GridLayout(5,5));
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				int random=(int) (Math.random()*3);
				JButton button=new JButton();
				gameButtons[i][j]=button;
				button.setName(" "+i+j);
				button.setBackground(Color.BLACK);
				if(random==2) {
					backgroundColor(button);
				}
				
				button.addActionListener(this);
				buttonPanel.add(button);
			}
		}
		mainPanel.add(buttonPanel,"Center");
		setContentPane(mainPanel);
		
		//create control button
		
		JButton random=new JButton("Randomize");
		random.setName("Random");
		random.addActionListener(this);
		
		JButton manual=new JButton("Manual Setup");
		manual.setName("Manual");
		manual.addActionListener(this);
		
		JPanel controls=new JPanel();
		controls.setLayout(new GridLayout(1,2));
		controls.add(random, "South");
		controls.add(manual, "South");
		
		mainPanel.add(controls,"South");
		
		
		
	}
	

	private void backgroundColor(JButton button) {
		if(button.getBackground()==Color.BLACK) {
			button.setBackground(Color.YELLOW);
		}
		else {
			button.setBackground(Color.BLACK);
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		LightsOut lights=new LightsOut();
		lights.setVisible(true);
	}

}
