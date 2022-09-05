package animation;

public class Alien extends Sprite{
	private final int INITIAL_X=400;
	public Alien(int x, int y) {
		super(x, y);
		initAlien();
	}

	private void initAlien() {
		loadImage("C://Users//danie//eclipse-workspace//java2d//resources//alien.png");
		getImageDimensions();
	}
	
	public void move() {
		if(x<0) {
			x=INITIAL_X;
		}
		x-=1;//move toward left margin
	}
}
