package defaultpackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class EvilGem extends GameObject{
	private BufferedImage [] EvilGem_image = new BufferedImage[2];
	Animation anim;
	public EvilGem(int x, int y, ID id,SpriteSheet ss,SpritSheetPlant ssp) {
		super(x, y, id,ss,ssp);
		EvilGem_image[0] = ssp.grabImage(5, 4, 32, 32);
		EvilGem_image[1] = ssp.grabImage(6, 4, 32, 32);
		anim = new Animation(2,EvilGem_image[0],EvilGem_image[1]);
		
	}

	
	public void tick() {
		anim.runAnimation();
		
	}

	
	public void render(Graphics g) {
		anim.drawAnimation(g, x, y, 0);		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	
}
	}
