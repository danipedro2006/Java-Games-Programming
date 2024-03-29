package animation;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean visible;
	protected Image image;
	
	public Sprite(int x, int y) {
		this.x=x;
		this.y=y;
		visible =true;
	}
	
	public void loadImage(String imageName) {
		
		ImageIcon ii=new ImageIcon(imageName);
		image=ii.getImage();
	}
	public void getImageDimensions() {
		
		width=image.getWidth(null);
		height=image.getHeight(null);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return image;
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void setVisible(Boolean visible) {
		this.visible=visible;
	}
	//create rectangle object for collision detection
	public Rectangle getBound() {
		return new Rectangle(x, y, width, height);
	}
}
