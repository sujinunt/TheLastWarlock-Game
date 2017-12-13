package defaultpackage;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {

	protected int x,y;
	protected float velX =0;
	protected float velY =0;
	protected ID id;
	protected SpriteSheet ss;
	protected SpritSheetPlant ssp;
	public GameObject(int x , int y,ID id,SpriteSheet ss,SpritSheetPlant ssp) {
		this.x=x;
		this.y=y;
		this.id = id;
		this.ss =ss;
		this.ssp = ssp;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public ID getId() {
		return id;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getVelX() {
		return velX;
	}
	public void setVelX(float velX) {
		this.velX = velX;
	}
	public float getVelY() {
		return velY;
	}
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	
}
