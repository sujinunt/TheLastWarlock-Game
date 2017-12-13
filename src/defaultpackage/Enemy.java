package defaultpackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject{
	Game game;

	private Handler handler;
	Random r = new Random();
	int choose =0;
	int hp = 200; //hp monster
        
	private BufferedImage [] Enemy_image=new BufferedImage[3];
	Animation anim;
	public Enemy(int x, int y, ID id,Handler handler,SpriteSheet ss,SpritSheetPlant ssp,Game game) {
		super(x, y, id,ss,ssp);
		this.handler = handler;
                this.game = game;
		Enemy_image[0] = ss.grabImage(4, 1, 32, 32);
		Enemy_image[1] = ss.grabImage(5, 1, 32, 32);
		Enemy_image[2] = ss.grabImage(6, 1, 32, 32);
		
		anim = new Animation(3,Enemy_image[0],Enemy_image[1],Enemy_image[2]);
	}

	
	public void tick() {
		x+=velX;
		y+=velY;
		choose = r.nextInt(900);
		
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId()==ID.Block) {
				if(getBoundsBig().intersects(tempObject.getBounds())) {
					x += (velX*2) * -1;
					y += (velY*2) * -1;
					velX= 0;
					velY= 0;
					
					
				}else if(choose==1) {
					velX = (r.nextInt(2*1+1)+ -1);
					velY = (r.nextInt(2*1+1)+ -1);
				}
			}
			if(tempObject.getId()==ID.plant) {
				if(getBoundsBig().intersects(tempObject.getBounds())) {
					x += (velX*2) * -1;
					y += (velY*2) * -1;
					velX= 0;
					velY= 0;
					
					
				}else if(choose==1) {
					velX = (r.nextInt(2*1+1)+ -1);
					velY = (r.nextInt(2*1+1)+ -1);
				}
			}
			if(tempObject.getId()==ID.Bullet) {
				if(getBounds().intersects(tempObject.getBounds())) {
					hp -=50; //hp -50
					handler.removeObject(tempObject);
				}
				
			}
                        if(tempObject.getId()==ID.Sword){
                        if(getBoundsBig().intersects(tempObject.getBounds())) {
					hp -=1; 
				}
                        }
		}
		anim.runAnimation();
		if(hp<=0) { 
			handler.removeObject(this);
                        game.money +=10;
			}
               
                
		
		
	}

	
	public void render(Graphics g) {
	        g.setColor(Color.green);
	        g.fillRect(x-10, y-10, hp/4, 7);
		anim.drawAnimation(g, x, y, 0);
		
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32); 
	}
        public Rectangle getBoundsBig() {
		
		return new Rectangle(x-16,y-16,64,64);
	}
        

}
