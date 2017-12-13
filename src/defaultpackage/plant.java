package defaultpackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class plant extends GameObject{
	private BufferedImage Plant_image;

	public plant(int x, int y, ID id,SpriteSheet ss) {
		super(x, y, id,ss,null);
		Plant_image = ss.grabImage(4, 2, 32, 32);
		
	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(Plant_image, x, y, null);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
}
