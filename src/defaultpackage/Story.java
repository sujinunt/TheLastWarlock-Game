
package defaultpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;



public class Story {
        private Handler handler;
        private Game game;
        private SpriteSheet warlock; //use to load image
        private BufferedImage Warlock = null;//use to load image
        private BufferedImage warlock_image = null;//use to load image
         public static enum Chapter1{
    	Line1,
    	Line2,
        Line3,
        Line4,
        Line5,
        Line6,
        Line7,
        Line8,
        Line9,
        LineBreak,
        Line10
        
    };
         public static Chapter1 Chapter = Chapter1.Line1;
         BufferedImageLoader loader = new BufferedImageLoader();
         
         
	

	public void render(Graphics g) {
                Warlock = loader.loadImage("/res/warlock.png");//use to load image
	        warlock = new SpriteSheet(Warlock);//use to load image
                warlock_image = warlock.grabImage(1, 1, 280, 500);//use to load image
                
		Graphics2D g2d = (Graphics2D) g;
	
		Font fnt1 = new Font("arial",Font.BOLD,20);
                Font fnt2 = new Font("arial",Font.BOLD,16);
                g.drawImage(warlock_image, 650, -10, null);//use to load image
		g.setColor(Color.black);
	        g.fillRect(0, 350, 1000, 250);//x,y,ยาว,กว้าง
                g.setColor(Color.white);
		g.setFont(fnt1);
                g.drawString("Press E to continue or Esc to skip", 650, 520);
                if(Chapter==Chapter1.Line1){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("T-La is the last warlock of the world. You need to help him to do the mission success.", 5, 380);
                }
                if(Chapter==Chapter1.Line2){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("T-La: There is a lot of monster!", 5, 380);}
                
                if(Chapter==Chapter1.Line3){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("T-La: I think,I need to find the EvilGem to stop all of Monster.", 5, 380);}
               if(Chapter==Chapter1.Line4){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("[Mission]", 5, 380);
                g.drawString("Find the EvilGem to stop the monster.", 5, 420);
               }
               if(Chapter==Chapter1.Line5){
                g.setColor(Color.white);
		g.setFont(fnt1);
                g.drawString("T-La: Yeah!! He is dead!!", 5, 380);
		g.drawString("           but I hear something when I kill him.", 5, 420);
                
               }
               if(Chapter==Chapter1.Line6){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("T-La: It come from north.", 5, 380);
                g.drawString("          I think I need to go to check it.", 5, 420);
               
               }
               if(Chapter==Chapter1.Line7){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("T-La: Finally,I got it.", 5, 380);
               
               }
               if(Chapter==Chapter1.Line8){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("T-La: All of moster will be destroy.", 5, 380);
               
               }
               if(Chapter==Chapter1.Line9){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("T-La: The world will be better again now.", 5, 380);
               
               }
               if(Chapter==Chapter1.LineBreak){
                g.setColor(Color.white);
		g.setFont(fnt1);
		g.drawString("", 5, 380);
               
               }
               if(Chapter==Chapter1.Line10){
                g.setColor(Color.white);
		g.setFont(fnt2);
		g.drawString("Thank you so much for playing this game.", 5, 380);
                g.drawString("The game making by Sujinunt Puangmalai from Software and Knowledge Engineering at Kasetsart university.", 5, 420);
                g.drawString("Character by RPG MAKER      Learning code and get some resource from Youtube: RealTutsGML,VertexDigitalArts", 5, 460);
                g.drawString("BGM: Celtic Grove - World/Background - Royalty Free Music", 5, 500);
               }
                
		
               
	}
}
