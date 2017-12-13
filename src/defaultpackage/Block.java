package defaultpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Block extends GameObject{
	private BufferedImage block_image;
        

	public Block(int x, int y, ID id,SpritSheetPlant ssp) {
		super(x, y, id,null,ssp);
		
		block_image = ssp.grabImage(4, 1, 32, 32);
		
	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(block_image, x, y, null);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}

}
