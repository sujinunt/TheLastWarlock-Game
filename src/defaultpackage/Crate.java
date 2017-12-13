package defaultpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Crate extends GameObject{

	private BufferedImage Crate_image;
	public Crate(int x, int y, ID id,SpriteSheet ss,SpritSheetPlant ssp) {
		super(x, y, id,ss,ssp);
		Crate_image = ssp.grabImage(2, 1, 32, 32);
		
	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(Crate_image, x, y, null);		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}

}
