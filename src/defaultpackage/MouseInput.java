package defaultpackage;

import static defaultpackage.Game.state;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MouseInput extends MouseAdapter implements MouseListener{
	private Handler handler;
	private Camera camera;
	private Game game;
	private SpriteSheet ss;
	private SpritSheetPlant ssp;
	public MouseInput(Handler handler,Camera camera,Game game,SpriteSheet ss,
                SpritSheetPlant ssp) {
		this.handler = handler;
		this.camera = camera;
		this.game = game;
		this.ss = ss;
		this.ssp =ssp;
	}
	public void mousePressed(MouseEvent e) {
		int mx = (int) (e.getX()+camera.getX());
		int my = (int) (e.getY()+camera.getY());
		if(state ==Game.STATE.Menu){
		//PlayButton
		if(mx>=450&&mx<=450+100) {
			if(my>=150&&my<=200) {
				//Pressed PlayButton
                                AudioPlayer.getSound("click").play();
                                game.ammo =50;
                                
				Game.state = Game.STATE.Story;
			}
		}
		//QuitButton
			if(mx>=450&&mx<=450+100) {
				if(my>=250&&my<=300) {
				//Pressed quitButton
				System.exit(1);
					}
				}
                }
                
		
		//Shoot 
                if(state ==Game.STATE.GAME){
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId()==ID.Player && game.ammo >=1) {
				handler.addObject(new Bullet(tempObject.getX()+16,
                                        tempObject.getY()+24,ID.Bullet,handler,
                                        mx,my,ss,ssp));
				game.ammo--;
			}
		}}
		
		
		
	}

}
