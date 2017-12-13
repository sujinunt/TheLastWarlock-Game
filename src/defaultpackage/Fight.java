package defaultpackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Fight extends GameObject{
	private BufferedImage Fight;
	public Fight(int x, int y, ID id,SpriteSheet ss,SpritSheetPlant ssp) {
		super(x, y, id,ss,ssp);
		Fight = ssp.grabImage(5, 1, 32, 32);
		
	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(Fight, x, y, null);		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
}
