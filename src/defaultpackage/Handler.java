package defaultpackage;

import java.awt.Graphics;
import java.util.ArrayList;


public class Handler {

	ArrayList<GameObject> object = new ArrayList<GameObject>();
	private boolean up = false,down =false,right=false,left=false;
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public void tick() {
            try{
		for(int i=0;i<object.size();i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}}catch(Exception e){
   System.out.println("Error: "+e.toString());
  }
	}
	public void render(Graphics g) {
		try{
   for(int i = 0; i < object.size(); i++){
   GameObject tempObject = object.get(i);
   
   tempObject.render(g);
   }
  }catch(Exception e){
   System.out.println("Error: "+e.toString());
  }
	}
	
	public void addObject(GameObject tempObject) {
		object.add(tempObject);
		}
	public void removeObject(GameObject tempObject) {
		object.remove(tempObject);
	}
        public void clear(){
        object.removeAll(object);
        }
       
}
