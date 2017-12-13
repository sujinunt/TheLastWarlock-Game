package defaultpackage;

import static defaultpackage.Game.state;
import static defaultpackage.Story.Chapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class keyinput extends KeyAdapter{
        Game game;
	Handler handler;
        Camera camera;
        private BufferedImage level = null;
        BufferedImageLoader loader = new BufferedImageLoader();
	

    public keyinput(Handler handler,Camera camera,Game game,SpriteSheet ss) {
    	this.handler = handler;
    	this.game = game;
        this.camera=camera;
    }
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		int mx = (int) (camera.getX());
		int my = (int) (camera.getY());
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			if(game.hp<=0) {
				if(key == KeyEvent.VK_Q) {
                                    AudioPlayer.getSound("click").play();
					System.exit(1); 
				}
                                if(key == KeyEvent.VK_P) {
                                    AudioPlayer.getSound("click").play();
                                    handler.clear();
                                    Game.state = Game.STATE.GAME;
                                    level = loader.loadImage("/src/res/MazeMap.png"); 
                                    game.loadLevel(level);
                                    game.hp =100;
                                    game.ammo=50;
                                    game.exp=0;
                                    game.dead+=1;
				}
                                if(key == KeyEvent.VK_M) {
                                    AudioPlayer.getSound("click").play();
                                    handler.clear();
                                    Game.state = Game.STATE.Menu;
                                    level = loader.loadImage("/src/res/MazeMap.png"); 
                                    game.loadLevel(level);
                                    game.storyy =-1;
                                    game.hp =100;
                                    game.ammo=50;
                                    game.exp=0;
                                    game.dead+=1;
				}
                               
			}
                        if(game.exp==1) {
				if(key == KeyEvent.VK_Q) {
                                    AudioPlayer.getSound("click").play();
					System.exit(i);
                                        
				}
                               if(key == KeyEvent.VK_P) {
                                   AudioPlayer.getSound("click").play();
                                    handler.clear();
                                    Game.state = Game.STATE.GAME;
                                    level = loader.loadImage("/src/res/MazeMap.png"); 
                                    game.loadLevel(level);
                                    game.hp =100;
                                    game.ammo=50;
                                    game.exp=0;
                                    game.dead=0;
                                    game.end=0;
				}
                               if(key == KeyEvent.VK_M) {
                                    AudioPlayer.getSound("click").play();
                                    handler.clear();
                                    Game.state = Game.STATE.Menu;
                                    level = loader.loadImage("/src/res/MazeMap.png"); 
                                    game.loadLevel(level);
                                    game.storyy =-1;
                                    game.hp =100;
                                    game.ammo=50;
                                    game.exp=0;
                                    game.dead=0;
                                    game.end=0;
				}
			}
			//Movement key
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_W){handler.setUp(true); game.melee=2;}
				if(key == KeyEvent.VK_A){handler.setLeft(true); game.melee=2;}
				if(key == KeyEvent.VK_S){handler.setDown(true); game.melee=2;}
				if(key == KeyEvent.VK_D){handler.setRight(true); game.melee=2;}
                                if(key== KeyEvent.VK_F){
                                    if(game.swip==0){
                                handler.addObject(new sword(tempObject.getX()+20,tempObject.getY()+10,ID.Sword,null,null));
                                game.melee=1;}
                                }
				if(key == KeyEvent.VK_ENTER){
                                    Game.state = Game.STATE.Pause;
                                    AudioPlayer.getSound("click").play();
                                
                                }
                                if(key == KeyEvent.VK_ESCAPE){
                                    Game.state = Game.STATE.GAME;
                                    AudioPlayer.getSound("click").play();
                                }
                                if(key == KeyEvent.VK_R){
                                    Game.state = Game.STATE.Shop;
                                    AudioPlayer.getSound("click").play();
                                }
                                //if(key == KeyEvent.VK_SPACE){
                                //Game.state = Game.STATE.Tutorial;
                                //AudioPlayer.getSound("click").play();
                                //}
                                
			}
                        if(state == Game.STATE.Shop){//shop
                        if(key == KeyEvent.VK_1){
                        //Pressed +10hp
                                AudioPlayer.getSound("click").play();
  
                        }
                        if(key == KeyEvent.VK_2){
                        AudioPlayer.getSound("click").play();
			      
                        }
                        }
                        if(state == Game.STATE.Tutorial){
                            if(game.tutoriall==0){
                            if(key == KeyEvent.VK_E){
                            AudioPlayer.getSound("click").play();
                            Tutorial.Tutorial = Tutorial.Tutoriall.Line2;   
                        }
                            }
                            if(game.tutoriall==1){
                            if(key == KeyEvent.VK_E){
                            AudioPlayer.getSound("click").play();
                            Tutorial.Tutorial = Tutorial.Tutoriall.Line3;   
                        }
                            }
                            if(game.tutoriall==2){
                            if(key == KeyEvent.VK_E){
                            AudioPlayer.getSound("click").play();
                            Tutorial.Tutorial = Tutorial.Tutoriall.Line4;   
                        }
                            }
                            if(game.tutoriall==3){
                            if(key == KeyEvent.VK_E){
                            AudioPlayer.getSound("click").play();
                            Tutorial.Tutorial = Tutorial.Tutoriall.Line5;   
                        }
                            }
                            if(game.tutoriall==4){
                            if(key == KeyEvent.VK_E){
                            AudioPlayer.getSound("click").play();
                            Tutorial.Tutorial = Tutorial.Tutoriall.Line6;   
                        }
                            }
                            if(game.tutoriall==5){
                            if(key == KeyEvent.VK_E){
                            AudioPlayer.getSound("click").play();
                            Tutorial.Tutorial = Tutorial.Tutoriall.Line7;   
                        }
                            }
                        
                        }
                        if(state == Game.STATE.Story){
                        if(game.storyy==0){
                        if(key == KeyEvent.VK_E){
                            AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line2;
                            
                        }}
                        if(game.storyy==1){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line3;
                        }}
                         if(game.storyy==2){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line4;
                        }}
                         if(game.storyy==3){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.LineBreak;
                        }}
                         if(game.storyy==4){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Game.state = Game.STATE.GAME;
                            game.ammo=50;
                        }}
                         if(game.storyy==6){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line5;
                            
                        }}
                         if(game.storyy==7){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line6;
                        }}
                         if(game.storyy==8){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.LineBreak;
                        }}
                         if(game.storyy==9){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Game.state = Game.STATE.GAME; 
                        }}
                         if(game.storyy==11){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line7;
                            
                            
                        }}
                         if(game.storyy==12){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line8;
                            
                        }}
                         if(game.storyy==13){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line9;
                            
                        }}
                         if(game.storyy==14){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.Line10;
                            game.end=1;
                            
                        }}
                         if(game.storyy==15){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Story.Chapter = Story.Chapter1.LineBreak;
                        }}
                         if(game.storyy==16){
                          if(key == KeyEvent.VK_E){
                              AudioPlayer.getSound("click").play();
                            Game.state = Game.STATE.GAME;
                            
                        }}
                        
                        }
                        
		}
                
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			//Movement key
			if(tempObject.getId() == ID.Player){
				if(key == KeyEvent.VK_W)handler.setUp(false);
				if(key == KeyEvent.VK_A)handler.setLeft(false);
				if(key == KeyEvent.VK_S)handler.setDown(false);
				if(key == KeyEvent.VK_D)handler.setRight(false);
				if(key == KeyEvent.VK_E)game.storyy+=1;
                                if(key == KeyEvent.VK_F){
                                game.melee=0;
                                }
                                
                                if(state == Game.STATE.Shop){//shop
                        if(key == KeyEvent.VK_1){
                        //Pressed +10hp
                                
                                
                                if(game.money<=0){
                                
                                }
                                if(game.money >=20){
                                game.money = game.money-20;
                                game.hp +=10;
                                }
                                
                                
                        }
                        if(key == KeyEvent.VK_2){
                        
				
                                if(game.money<=0){
                                
                                }
                                if(game.money >=20){
                                game.money -=20;
                                game.ammo +=10;
                                }
                                
                        }
                        
                        
                        }
			}
                        
		}
	}
}
