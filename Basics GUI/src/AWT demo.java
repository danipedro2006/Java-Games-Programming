package awt;

import java.awt.*;

public class AWTEx2 {

	public static void main(String[] args) {
		Frame f=new Frame();
		f.setTitle("AWT example 2");
		f.setSize(300,300);
		f.setLayout(null);
		f.setVisible(true);
		
		Label l=new Label("Employee ID");
		l.setBounds(20,80,80,30);
		Button b=new Button("Click-me");
		b.setBounds(100,100,80,30);
		TextField t=new TextField();
		t.setBounds(20,100,80,30);
		
		f.add(b);
		f.add(t);
		f.add(l);

	}

}
