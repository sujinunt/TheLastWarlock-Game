
package defaultpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Tutorial {
    public static enum Tutoriall{
    	Line1,
    	Line2,
        Line3,
        Line4,
        Line5,
        Line6,
        Line7
    };
    private SpriteSheet tutorial1; //use to load image
    private BufferedImage Tutorlial1 = null;//use to load image
    private BufferedImage tutorial1_image = null;//use to load image
    
    private SpriteSheet tutorial2; //use to load image
    private BufferedImage Tutorlial2 = null;//use to load image
    private BufferedImage tutorial2_image = null;//use to load image
    
    private SpriteSheet tutorial3; //use to load image
    private BufferedImage Tutorlial3 = null;//use to load image
    private BufferedImage tutorial3_image = null;//use to load image
    
    private SpriteSheet tutorial4; //use to load image
    private BufferedImage Tutorlial4 = null;//use to load image
    private BufferedImage tutorial4_image = null;//use to load image
    
    private SpriteSheet tutorial5; //use to load image
    private BufferedImage Tutorlial5 = null;//use to load image
    private BufferedImage tutorial5_image = null;//use to load image
    
    private SpriteSheet tutorial6; //use to load image
    private BufferedImage Tutorlial6 = null;//use to load image
    private BufferedImage tutorial6_image = null;//use to load image
    
    private SpriteSheet tutorial7; //use to load image
    private BufferedImage Tutorlial7 = null;//use to load image
    private BufferedImage tutorial7_image = null;//use to load image
    
    BufferedImageLoader loader = new BufferedImageLoader();
    BufferedImageLoader loader2 = new BufferedImageLoader();
    BufferedImageLoader loader3 = new BufferedImageLoader();
    BufferedImageLoader loader4 = new BufferedImageLoader();
    BufferedImageLoader loader5 = new BufferedImageLoader();
    BufferedImageLoader loader6 = new BufferedImageLoader();
    BufferedImageLoader loader7 = new BufferedImageLoader();
    public static Tutoriall Tutorial = Tutoriall.Line1;
    public void render(Graphics g){
        
        Tutorlial1 = loader.loadImage("/2clickPlaybutton.png");//use to load image
	tutorial1 = new SpriteSheet(Tutorlial1);//use to load image
        tutorial1_image = tutorial1.grabImage(1, 1, 980, 530);//use to load image
        
        Tutorlial2 = loader2.loadImage("/3StoryPressEtocontinue.png");//use to load image
	tutorial2 = new SpriteSheet(Tutorlial2);//use to load image
        tutorial2_image = tutorial2.grabImage(1, 1, 980, 530);//use to load image
        
        Tutorlial3 = loader3.loadImage("/4control.png");//use to load image
	tutorial3 = new SpriteSheet(Tutorlial3);//use to load image
        tutorial3_image = tutorial3.grabImage(1, 1, 980, 530);//use to load image
        
        Tutorlial4 = loader4.loadImage("/5atkmonster.png");//use to load image
	tutorial4 = new SpriteSheet(Tutorlial4);//use to load image
        tutorial4_image = tutorial4.grabImage(1, 1, 980, 530);//use to load image
        
        Tutorlial5 = loader5.loadImage("/6Gamrover.png");//use to load image
	tutorial5 = new SpriteSheet(Tutorlial5);//use to load image
        tutorial5_image = tutorial5.grabImage(1, 1, 980, 530);//use to load image
        
        Tutorlial6 = loader6.loadImage("/7Pressrforuseshop.png");//use to load image
	tutorial6 = new SpriteSheet(Tutorlial6);//use to load image
        tutorial6_image = tutorial6.grabImage(1, 1, 980, 530);//use to load image
        
        Tutorlial7 = loader7.loadImage("/8Pickuppotion.png");//use to load image
	tutorial7 = new SpriteSheet(Tutorlial7);//use to load image
        tutorial7_image = tutorial7.grabImage(1, 1, 980, 530);//use to load image
                
        Graphics2D g2d = (Graphics2D) g;
        Font fnt1 = new Font("arial",Font.BOLD,20);
        g.setColor(Color.white);
        g.setFont(fnt1);
        g.drawString("Press E to continue", 650, 520);
        
        if(Tutorial == Tutoriall.Line1){
             g.drawImage(tutorial1_image, 0, 0, null);//use to load image   
                }
        if(Tutorial == Tutoriall.Line2){
             g.drawImage(tutorial2_image, 0, 0, null);//use to load image   
                }
        if(Tutorial == Tutoriall.Line3){
             g.drawImage(tutorial3_image, 0, 0, null);//use to load image   
                }
        if(Tutorial == Tutoriall.Line4){
             g.drawImage(tutorial4_image, 0, 0, null);//use to load image   
                }
        if(Tutorial == Tutoriall.Line5){
             g.drawImage(tutorial5_image, 0, 0, null);//use to load image   
                }
        if(Tutorial == Tutoriall.Line6){
             g.drawImage(tutorial6_image, 0, 0, null);//use to load image   
                }
        if(Tutorial == Tutoriall.Line7){
             g.drawImage(tutorial7_image, 0, 0, null);//use to load image   
                }
        
    
    }
}
