package defaultpackage;

import static defaultpackage.Game.state;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import java.awt.image.BufferedImage;
import java.util.Random;


public class Boss extends GameObject{
	Game game;

	private Handler handler;
	Random r = new Random();
	int choose =0;
	int hp = 2000; //hp Boss
	private BufferedImage [] Boss_image=new BufferedImage[3];
	Animation anim;
	public Boss(int x, int y, ID id,Handler handler,Game game,SpriteSheet ss,SpritSheetPlant ssp) {
		super(x, y, id,ss,ssp);
		this.handler = handler;
		this.game = game;
		Boss_image[0] = ssp.grabImage(5, 6, 64, 56);
		Boss_image[1] = ssp.grabImage(5, 8, 64, 64);
		
		
		
		anim = new Animation(2,Boss_image[0],Boss_image[1]);
	}

	
	public void tick(){
		x+=velX;
		y+=velY;
		choose = r.nextInt(200);
		
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
					hp-=0;
                                       
				}
                        }
		}
		anim.runAnimation();
		if(hp<=0) { 
			handler.removeObject(this);
                        game.storyy+=1;
                        state = Game.STATE.Story;
			handler.addObject(new EvilGem(1000,64,ID.EvilGem,ss,ssp));
                        
			}
                
		
		
		
	}
        
        

	
	public void render(Graphics g) {
                g.setColor(Color.YELLOW);
	        g.fillRect(x-15, y-20, hp/25, 10);
		anim.drawAnimation(g, x, y, 0);
		
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,64,64); 
	}
        public Rectangle getBoundsBig() {
		
		return new Rectangle(x-16,y-16,128,128);
	}
}
