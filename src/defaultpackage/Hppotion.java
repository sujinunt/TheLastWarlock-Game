package defaultpackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Hppotion extends GameObject{
	private BufferedImage Hp_image;
	public Hppotion(int x, int y, ID id,SpriteSheet ss,SpritSheetPlant ssp) {
		super(x, y, id,null,ssp);
		Hp_image = ssp.grabImage(3, 1, 32, 32);
		
	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(Hp_image, x, y, null);		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}

}

