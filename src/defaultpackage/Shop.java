
package defaultpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Shop {
        public Rectangle HpIncreasing = new Rectangle(200,150,100,50);
	public Rectangle MpIncreasing = new Rectangle(200,250,100,50);
        Game game;
        BufferedImageLoader loader = new BufferedImageLoader();
        private SpriteSheet fairy; //use to load image
        private BufferedImage Fairy = null;//use to load image
        private BufferedImage fairy_image = null;//use to load image
        public Shop(Game game){
        this.game = game;
        }

	public void render(Graphics g) {
                Fairy = loader.loadImage("/src/res/fairy.png");//use to load image
	        fairy = new SpriteSheet(Fairy);//use to load image
                fairy_image = fairy.grabImage(1, 1, 780, 590);//use to load image
            
		Graphics2D g2d = (Graphics2D) g;
                g.drawImage(fairy_image, 250, -10, null);//use to load image
		Font fnt0 = new Font("arial",Font.BOLD,50);
		g.setFont(fnt0);
                g.setColor(Color.white);
		g.drawString("Fairy SHOP", 30, 100);
		g2d.draw(MpIncreasing);
                g2d.draw(HpIncreasing);
		Font fnt1 = new Font("arial",Font.BOLD,30);
                Font fnt3 = new Font("arial",Font.BOLD,18);
                g.setFont(fnt3);
		g.drawString("Press 1 ", HpIncreasing.x, HpIncreasing.y-10);
                g.drawString("Press 2", MpIncreasing.x, MpIncreasing.y-10);
                g.drawString("Cost 20 Money", MpIncreasing.x-140, MpIncreasing.y+35);
                g.drawString("Cost 20 Money", HpIncreasing.x-140, HpIncreasing.y+35);
                g.drawString("Press esc to continue", MpIncreasing.x, MpIncreasing.y+100);
                g.setColor(Color.red);
		g.setFont(fnt1);
		g.drawString("+10 Hp", HpIncreasing.x, HpIncreasing.y+35);
		
                g.setColor(Color.blue);
		g.drawString("+10 Mp", MpIncreasing.x, MpIncreasing.y+35);
		
                
                Font fnt2 = new Font("arial",Font.BOLD,20);
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("Money : "+game.money, 0,530);
                g.drawString("HP : "+game.hp, 0,490);
                g.drawString("MP : "+game.ammo, 0,510);
	}
}
