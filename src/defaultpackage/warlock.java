package defaultpackage;


import static defaultpackage.Game.state;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class warlock extends GameObject {
	Handler handler;
	Game game;
        String name;
        Camera camera;
	
	private BufferedImage[] warlock_image = new BufferedImage[20];
	
	Animation anim,anim2,anim3,anim4;

	public warlock(int x, int y, ID id,Handler handler,Game game,SpriteSheet ss,SpritSheetPlant ssp,String name,Camera camera) {
		super(x, y, id,ss,ssp);
		this.handler = handler;
		this.game = game;
                this.name = name;
                this.camera = camera;
		
		warlock_image[0] = ssp.grabImage(1, 2, 32, 48); //
		warlock_image[1] = ssp.grabImage(1, 4, 32, 48);
		warlock_image[2] = ssp.grabImage(1, 6, 32, 48);
		warlock_image[3] = ssp.grabImage(1, 8, 32, 48);
		warlock_image[4] = ssp.grabImage(2, 2, 32, 48); //
		warlock_image[5] = ssp.grabImage(2, 4, 32, 48);
		warlock_image[6] = ssp.grabImage(2, 6, 32, 48);
	        warlock_image[7] = ssp.grabImage(2, 8, 32, 48);
		warlock_image[8] = ssp.grabImage(3, 2, 32, 48); //
		warlock_image[9] = ssp.grabImage(3, 4, 32, 48);
		warlock_image[10] = ssp.grabImage(3, 6, 32, 48);
		warlock_image[11] = ssp.grabImage(3, 8, 32, 48);
		warlock_image[12] = ssp.grabImage(4, 2, 32, 48); //
		warlock_image[13] = ssp.grabImage(4, 4, 32, 48);
		warlock_image[14] = ssp.grabImage(4, 6, 32, 48);
		warlock_image[15] = ssp.grabImage(4, 8, 32, 48);
		
		
		
		anim = new Animation(4,warlock_image[3],warlock_image[7],warlock_image[11],warlock_image[15]);
                anim2 = new Animation(4,warlock_image[1],warlock_image[5],warlock_image[9],warlock_image[13]);
		anim3 = new Animation(4,warlock_image[2],warlock_image[6],warlock_image[10],warlock_image[14]);
		anim4 = new Animation(4,warlock_image[0],warlock_image[4],warlock_image[8],warlock_image[12]);
		
		
	}

	
	public void tick() {
		
		collision();
		x += velX;
		y += velY;
		
		
		//Movement
		if(handler.isUp()) velY =  (float) -0.5;
		else if(!handler.isDown()) velY=0;
		anim.runAnimation();
		
		if(handler.isDown()) velY = 1;
		else if(!handler.isUp()) velY=0;
		anim4.runAnimation();
		
		if(handler.isRight()) velX = 1;
		else if(!handler.isLeft()) velX=0;
		anim3.runAnimation();
		
		if(handler.isLeft()) velX =  (float) -0.5;
		else if(!handler.isRight()) velX=0;
		anim2.runAnimation();
		
		
		
		
                //Dead
		if(game.hp <= 0) {
                        
			handler.removeObject(this);
			}
                if(game.end == 1) {
			handler.removeObject(this);
			}
	}

	
		private void collision() {
			  for(int i = 0; i < handler.object.size(); i++) {
			   GameObject tempObject = handler.object.get(i);
			   if(tempObject.getId() == ID.Block) {
				    if(!place_free((int) (x + velX), y, getBounds(), tempObject.getBounds())) {
				     velX= 0;
				    }
				    
				    if(!place_free(x, (int) (y + velY), getBounds(), tempObject.getBounds())) {
				     velY= 0;
				    }
				   }
                           
			   
			   if(tempObject.getId() == ID.plant) {
				    if(!place_free((int) (x + velX), y, getBounds(), tempObject.getBounds())) {
				     velX= 0;
				    }
				    
				    if(!place_free(x, (int) (y + velY), getBounds(), tempObject.getBounds())) {
				     velY= 0;
				    }
				   }
                           
			   if(tempObject.getId() == ID.Create) {
				    if(getBounds().intersects(tempObject.getBounds())) {
				     game.ammo +=10;
				     handler.removeObject(tempObject);
				    }
				    
				   
				   }
			   if(tempObject.getId() == ID.EvilGem) {
				    if(getBounds().intersects(tempObject.getBounds())) {
				     game.exp +=1;
                                     state = Game.STATE.Story;
				     handler.removeObject(tempObject);
				     
				    }
				    
				   
				   }
			   if(tempObject.getId() == ID.Hppotion) {
				    if(getBounds().intersects(tempObject.getBounds())) {
				     game.hp +=30;
				     handler.removeObject(tempObject);
				    }
			
				    
				    
				   
				   }
			   if(tempObject.getId() == ID.Enemy) {
				    if(!place_free((int) (x + velX), y, getBounds(), tempObject.getBounds())) {
				     velX= 0;
                                     game.hp -=1;
				    }
				    
				    if(!place_free(x, (int) (y + velY), getBounds(), tempObject.getBounds())) {
				     velY= 0;
                                     game.hp -=1;
				    }
				    }
			   if(tempObject.getId() == ID.Boss) {
				    if(!place_free((int) (x + velX), y, getBounds(), tempObject.getBounds())) {
				     velX= 0;
                                     game.hp -=1;
				    }
				    
				    if(!place_free(x, (int) (y + velY), getBounds(), tempObject.getBounds())) {
				     velY= 0;
                                     game.hp -=1;
				    }
				    }
			   if(tempObject.getId() == ID.Fight) {
				    if(getBounds().intersects(tempObject.getBounds())) {
				     handler.removeObject(tempObject);
				     handler.addObject(new Block(1900,740,ID.Block,ssp));
				     handler.addObject(new Block(1900,760,ID.Block,ssp));
				     handler.addObject(new Block(1900,790,ID.Block,ssp));
				    }}
                           if(tempObject.getId() == ID.Sword){
                              if(game.melee==1){
                                  
                                  }
                             if(game.melee==0){
                                  handler.removeObject(tempObject);}
                             if(game.melee>1){
                                  handler.removeObject(tempObject);
                           }
                                 }
                           

			 }
	}
	public boolean place_free(int x, int y, Rectangle myRect, Rectangle otherRect) {
		  myRect.x = x;
		  myRect.y = y;
		  if(myRect.intersects(otherRect)) {
		   return false;
		  }
		  return true;
		 }
	public void render(Graphics g) {
            
            
            g.setColor(Color.white);           
            Font fnt0 = new Font("arial",Font.BOLD,20);
            if(name!=null){
            g.drawString("T-La : "+name, x-20,y-10);}
            else if(name==null){
            g.drawString("T-La", x,y-10);
            }
            
            
            
		if(velX==0&&velY==0)
		   g.drawImage(warlock_image[0], x, y, null);
		else if(velX==0&&velY>=0.25)
			anim4.drawAnimation(g, x, y, 0);
		else if (velX==0&&velY<=-0.25)
			anim.drawAnimation(g, x, y, 0);
		else if(velX>=0.25&&velY==0)
			anim3.drawAnimation(g, x, y, 0);
		else if(velX<=-0.25&&velY==0)
			anim2.drawAnimation(g, x, y, 0);
		else if(velX==velY)
			 g.drawImage(warlock_image[1], x, y, null);
                else{
			g.drawImage(warlock_image[2], x, y, null);
        }
                
                
		
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,48);
	}

    

}
