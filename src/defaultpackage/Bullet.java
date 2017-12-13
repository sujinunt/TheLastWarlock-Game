package defaultpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Bullet extends GameObject{
	private Handler handler;
	private BufferedImage cat_image;
	public Bullet(int x, int y, ID id,Handler handler,int mx,int my,SpriteSheet ss,SpritSheetPlant ssp) {
		super(x, y, id,ss,ssp);
		this.handler = handler;
		cat_image = ssp.grabImage(6, 1, 32, 32);
		velX = (mx-x)/100;
		velY = (my-y)/100;
	}

	
	public void tick() {
		x+=velX;
		y+=velY;
		
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			
			if(tempObject.getId()==ID.plant) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
			}
			if(tempObject.getId()==ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
			}
                        
		}
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(cat_image, x, y, null);	
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,8,8);
	}

}
