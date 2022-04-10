import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Bullet extends GameObject {

	private Handler handler;
	public LinkedList<GameObject> touched = new LinkedList<GameObject>();

	public Bullet(int x, int y, ID id, Handler handler, int mouseX, int mouseY, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		
		calculateVelocity(x,y,mouseX,mouseY);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
			}
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x, y, 8, 8);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 8, 8);
	}

	private void calculateVelocity(int fromX, int fromY, int toX, int toY)
	{
		double distance = Math.sqrt(Math.pow((toX - fromX), 2) + Math.pow((toY - fromY), 2));
		double speed = 10; //set the speed in [2,n)  n should be < 20 for normal speed
		//find Y
		this.velY = (float)((toY - fromY) * speed / distance);
		//find X
		this.velX = (float)((toX - fromX) * speed / distance);
	}
	private void addTouched(GameObject object) {
		this.touched.add(object);
	}

}
