
package defaultpackage;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class sword extends GameObject{
    private Handler handler;
    
    private SpriteSheet sword; //use to load image
    private BufferedImage Sword = null;//use to load image
    private BufferedImage sword_image[] = new BufferedImage[3];//use to load image
    BufferedImageLoader loader = new BufferedImageLoader();
    Animation anim;

    public sword(int x, int y, ID id, SpriteSheet ss, SpritSheetPlant ssp) {
        super(x, y, id, ss, ssp);
        this.handler = handler;
        Sword = loader.loadImage("/src/res/Accweapon.png");//use to load image
	sword = new SpriteSheet(Sword);//use to load image
        sword_image[0] = sword.grabImage(1, 1, 32, 32);//use to load image
	sword_image[1] = sword.grabImage(2, 1, 32, 32);//use to load image
        sword_image[2] = sword.grabImage(4, 1, 34, 32);//use to load image
        
        anim = new Animation(3,sword_image[0],sword_image[1],sword_image[2]);
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;
        anim.runAnimation();
    }

    @Override
    public void render(Graphics g) {
        anim.drawAnimation(g, x, y, 0);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }
    
}
