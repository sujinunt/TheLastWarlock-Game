package defaultpackage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;




public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = 1L;
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    private Camera camera;
    private SpriteSheet ss;
    private SpritSheetPlant ssp;
    private BufferedImage level = null;
    public BufferedImage level2 = null;
    private BufferedImage sprite_sheet = null;
    private BufferedImage Spritsheetplant = null;
    private BufferedImage floor = null;
    private Menu menu;
    private Story story;
    private Shop shop;
    private Tutorial tutorial;
    public String username;
    
    
   
    public int ammo = 50;
    public int hp = 100;
    public int exp = 0;
    public int killBoss = 1;
    public int dead =0;
    public int storyy =-1;
    public int end=0;
    public int money=0;
    public int swip =0;
    public int tutoriall =0;
    public int melee =0;
    
    
    
    public static enum STATE{
    	Menu,
    	GAME,
        Pause,
        Story,
        Shop,
        Tutorial
    };
    
    public static STATE state = STATE.Menu;
    


public Game() {
	
        new Window(1000,563,"TheLastWarlock - วอลอคคนสุดท้าย",this); //maketitlegame
	start();
        
	menu = new Menu();
        tutorial = new Tutorial();
        story = new Story();
        shop = new Shop(this);
	handler = new Handler();
	camera = new Camera(0,0);
	CustomCursor();
        AudioPlayer.load();
        AudioPlayer.getMusic("music").loop();
        
	this.addKeyListener(new keyinput(handler,camera,this,ss));
	
	BufferedImageLoader loader = new BufferedImageLoader();
	level = loader.loadImage("/src/res/MazeMap.png"); //load map naja
        //level2 = loader.loadImage("leveldesign01.png");
	sprite_sheet = loader.loadImage("/src/res/sprite_sheet.png");//load picture
	ss = new SpriteSheet(sprite_sheet);
	floor = ss.grabImage(5, 2, 32, 32);
	Spritsheetplant = loader.loadImage("/src/res/Spritsheetplant.png");
	ssp = new SpritSheetPlant(Spritsheetplant);
	
	this.addMouseListener(new MouseInput(handler,camera,this,ss,ssp));
        
        ImageIcon icon = new ImageIcon("src/res/icon.png");
        username = (String) JOptionPane.showInputDialog(this,"Username ","Login",JOptionPane.INFORMATION_MESSAGE,icon, null,"");
        if(username!=null){
	loadLevel(level);}
        if(username==null){
        loadLevel(level);
        }
        
	
	
}
   public void start() {
	isRunning = true;
	thread = new Thread(this);
	thread.start();
}
  private void stop() {
	isRunning = false;
	try {
		thread.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public void run() {
        
	this.requestFocus();
	long lastTime = System.nanoTime();
	double amountOfTicks = 60.0;
	double ns = 100000000 / amountOfTicks;
	double delta = 0;
	long timer = System.currentTimeMillis();
	int frames = 0;
	  while(isRunning) {
	   long now = System.nanoTime();
	   delta += (now - lastTime) / ns;
	   lastTime = now;
	   while(delta >= 1) {
	    tick();
	    
	    delta--;
	   }
	   render();
	   frames++;
	   
	   if(System.currentTimeMillis() - timer > 1000) {
	    timer += 1000;
	    frames = 0;
	    
	   }
	  }
	  stop();
}
public void tick() {
	
	for(int i=0;i<handler.object.size();i++) {
		if(handler.object.get(i).getId()==ID.Player) {
			camera.tick(handler.object.get(i));}
	}
	if(state == STATE.GAME) {
	handler.tick();
	}
}

public void render() {
	BufferStrategy bs = this.getBufferStrategy();
	if(bs == null) {
		this.createBufferStrategy(3);
		return;
	}
	
	Graphics g = bs.getDrawGraphics();
	Graphics2D g2d = (Graphics2D) g;
	/////////////////////////////
	
	for(int xx=0;xx<30*72;xx+=32) {
		for(int yy=0;yy<30*72;yy+=32) {
			g.drawImage(floor, xx, yy, null);
		}
	}
	g2d.translate(-camera.getX(), -camera.getY());
	
	if(state == STATE.GAME) {
	 handler.render(g);
        //tutorial   
        g.setColor(Color.white);
	g.drawString("Press W A S D to control your charactor", 200,100);
        g.drawString("Use Left Mouse to shoot the monster", 200,120);
        g.drawString("Press R to open shop", 300, 200);
        g.drawString("Press F to use sword", 700, 100);
            
       
	
	g2d.translate(camera.getX(), camera.getY());
        g.setColor(Color.BLACK);
        g.fillRect(0, 480, 220, 55);
        g.fillRect(690, 480, 310, 55);
        g.fillRect(0, 520, 1000, 20);
	//เลือด
        if(hp>100){
        hp=100;
        }
	g.setColor(Color.gray);
	g.fillRect(5, 485, 200, 20);
	g.setColor(Color.green);
	g.fillRect(5, 485, hp*2, 20);
	g.setColor(Color.red);
	g.drawString("Hp: "+hp, 5,500);
	//กระสุน
        if(ammo>50){
        ammo=50;
        }
	g.setColor(Color.gray);
	g.fillRect(5, 510, 200, 20);
	g.setColor(Color.blue);
	g.fillRect(5, 510, ammo*4, 20);
	g.setColor(Color.white);
	g.drawString("Mp: "+ammo, 6,525);
        //Dead Count
        Font fnt3 = new Font("arial",Font.BOLD,30);
	g.setFont(fnt3);
	g.setColor(Color.WHITE);
	g.drawString("Death: "+dead, 850,520);
        //Money
        Font fnt4 = new Font("arial",Font.BOLD,20);
	g.setFont(fnt4);
	g.setColor(Color.WHITE);
	g.drawString("Money: "+money, 700,520);
	//Die
	if(hp <= 0) {
                
		g.setColor(Color.red);
		Font fnt2 = new Font("arial",Font.BOLD,30);
		g.setFont(fnt2);
		g.drawString("You are dead.", 400, 200);
                g.setColor(Color.WHITE);
		g.drawString("Press P to Play Again", 350,280);
                g.drawString("Press M to Menu", 400,345);
		g.drawString("Press Q to Quit", 400,410);
                
                
		
		}
	//End  Game
	if(exp == 1) {
		g.setColor(Color.yellow);
		Font fnt1 = new Font("arial",Font.BOLD,30);
		g.setFont(fnt1);
		g.drawString("You Win!!!.", 400, 200);
                g.setColor(Color.WHITE);
		g.drawString("Press P to Play Again", 350,280);
                g.drawString("Press M to Menu", 400,345);
		g.drawString("Press Q to Quit", 400,410);
		
		}
        }else if(state == STATE.Menu) { //loadmenu	
            menu.render(g);
            
		}
        else if(state == STATE.Pause){
                handler.render(g);
	        g2d.translate(camera.getX(), camera.getY());
                Font fnt0 = new Font("arial",Font.BOLD,50);
                g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("Pause", 400, 100);
		
		Font fnt1 = new Font("arial",Font.BOLD,30);
		g.setFont(fnt1);
		g.drawString("Press esc to continue..", 300, 235);
		
                }
        else if(state == STATE.Story) {//load story
            
            g2d.translate(camera.getX(), camera.getY());	
            story.render(g);
		}
        else if(state == STATE.Shop) {//load shop
            
            g2d.translate(camera.getX(), camera.getY());	
            shop.render(g);
		}
       // else if(state == STATE.Tutorial) {
            
           //g2d.translate(camera.getX(), camera.getY());	
            //tutorial.render(g);
		//}
        
	
	////////////////////////////
	g.dispose();
	bs.show();
	
}

//loading the level//////////
public void loadLevel(BufferedImage image) {
	int w = image.getWidth();
	int h = image.getHeight();
	
	for(int xx =0;xx<w;xx++) {
		for(int yy=0;yy<h;yy++) {
			int pixel = image.getRGB(xx, yy);
			int red = (pixel>>18)& 0xff;
			int green = (pixel>>8)& 0xff;
			int blue =(pixel)&0xff;
			
			if(red == 255&&green==0&&blue==0) //red is block naja
				handler.addObject(new plant(xx*32,yy*32,ID.plant,ss));
			if(blue == 255 && green==0) //blue is player naja
				handler.addObject(new warlock(xx*32,yy*32,ID.Player,handler,this,ss,ssp,username,camera));
			if(green == 255 && blue==0){ //green is enemy
				handler.addObject(new Enemy(xx*32,yy*32,ID.Enemy,handler,ss,ssp,this));
                        }
			if(green==255&&blue==255)//mp potion
				handler.addObject(new Crate(xx*32,yy*32,ID.Create,ss,ssp));
			if(red == 255&&green==255&&blue==200) //Hppotion
				handler.addObject(new Hppotion(xx*32,yy*32,ID.Hppotion,ss,ssp));
			if(red == 255&&green==141&&blue==0) //trap
				handler.addObject(new Fight(xx*32,yy*32,ID.Fight,ss,ssp));
			if(red == 255&&green==31&&blue==255) //Boss
				handler.addObject(new Boss(xx*32,yy*32,ID.Boss,handler,this,ss,ssp));
		}
		
	}
}
public void CustomCursor(){
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image img = toolkit.getImage("cursor.png");
    Point point = new Point(0,0);
    Cursor cursor = toolkit.createCustomCursor(img, point,"Cursor");
    
    setCursor(cursor);



}




public static void Play() {	
    new Game();
}


	public static void main(String arg[]) {
            try{
        Thread.sleep(4500);//Time for Loading Game
        }catch(Exception e){}
		Play();
                
		
 }




	
	
}
