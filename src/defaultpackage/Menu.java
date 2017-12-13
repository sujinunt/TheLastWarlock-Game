package defaultpackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	public Rectangle playButton = new Rectangle(450,150,100,50);
	public Rectangle quitButton = new Rectangle(450,250,100,50);
       

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		
		Font fnt0 = new Font("arial",Font.BOLD,50);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("The Last Warlock", 290, 100);
		
		Font fnt1 = new Font("arial",Font.BOLD,30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x+19, playButton.y+35);
		g2d.draw(playButton);
		g.drawString("Quit", quitButton.x+19, quitButton.y+35);
		g2d.draw(quitButton);
                
                Font fnt2 = new Font("arial",Font.BOLD,14);
		g.setFont(fnt2);
		g.setColor(Color.WHITE);
		g.drawString("TheLastWarlock making by Software and Knowledge Engineering student for Final project", 0,530);
                g.drawString("Character 2D art by www.rinmarugames.com", 0,510);
	}
}
