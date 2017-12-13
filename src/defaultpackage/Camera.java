package defaultpackage;

public class Camera {

	private float x,y;
	
	public Camera(float x,float y) {
		this.x = x;
		this.y = y;
	}
	public void tick(GameObject object) {
		
		
		x += ((object.getX()-x)-1032/2)*0.05f;
		y += ((object.getY()-y)-563/2)*0.05f;
		
		if(x<=0)x=0;
		if(x>=1550)x=1550;
		if(y<=0)y=0;
		if(y>=563+1450)y=563+1450;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
}
