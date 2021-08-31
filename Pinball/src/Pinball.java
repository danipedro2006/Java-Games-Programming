import javax.swing.JPanel;

public class Pinball extends JPanel {
	
	int ctr=0;
	double G=0.1;//Gravitational constant
	final int xPos=280;
	int points=0;
	int lives=0;
	int sides=13;
	double paddle=130;
	double snorm=400;
	double sd=450;
	double sv=0;
	double rtheta=0;
	double ltheta=0;
	
	double[] p2d= {280, 200};
	double[] v2d= {0,0};
	
	int[][] preset= {
			{0,400,135,450,1},
			{135,450,270,400,1},
			{270,0,300,20,1},
			{291,0,291,500,1},
			{-1,0,270,0,1},
			{0,-1,0,500,1}
			};
	int[][] ball= {
			{80,80,30,50},
			{230,280,20,200},
			{50,200,25,100},
			{200,100,10,500},
	};
	
	int lines[][]=new int[100][5];
	
	
	public Pinball() {
		for(int i=0;i<preset.length;i++) {
			lines[i]=preset[i];
		}
		int plen=preset.length;
		
		int ct=0;
		for(int k=0;k<ball.length;k++) {
			int px=ball[k][0], py=ball[k][1], radius=ball[k][2];
			for(double i=0;i<2*Math.PI;i+=2*Math.PI/sides) {
				ct++;
				lines[plen+ct][0]=px+(int)(radius*Math.cos(i));
				lines[plen+ct][1]=py+(int)(radius*Math.sin(i));
				lines[plen+ct][2]=px+(int)(radius*Math.cos(i-2*Math.PI/sides));
				lines[plen+ct][3]=py+(int)(radius*Math.cos(i-2*Math.PI/sides));
				
			}
		}
	}
}
