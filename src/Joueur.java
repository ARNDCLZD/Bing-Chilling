import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Joueur extends GameObject{
	
	private Handler handler;
	private Game game;

	private BufferedImage[] joueurImage = new BufferedImage[3];
	
	Animation animation;
	
	public Joueur(int x, int y, ID id, Handler handler, Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		this.game = game;

		joueurImage[0] = ss.grabImage(1, 1, 32, 48);
		joueurImage[1] = ss.grabImage(2, 1, 32, 48);
		joueurImage[2] = ss.grabImage(3, 1, 32, 48);
		
		animation = new Animation(3, joueurImage[0], joueurImage[1], joueurImage[2]);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		//mouvement
		if(handler.isUp()) velY = -3;
		else if(!handler.isDown()) velY = 0;	//si Up est relâché et Down n'est pas poussé, alors vel est 0
		
		if(handler.isDown()) velY = 3;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isRight()) velX = 3;
		else if(!handler.isLeft()) velX = 0;
		
		if(handler.isLeft()) velX = -3;
		else if(!handler.isRight()) velX = 0;
		
		animation.runAnimation();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Block) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
			
			if(tempObject.getId() == ID.Crate) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					game.ammo += 10;
					handler.removeObject(tempObject);
				}
			}
			
			if(tempObject.getId() == ID.Enemy) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					game.hp--;
					if(game.hp == 0) {
						handler.removeObject(this);
					}
				}
			}
		}
	}

	public void render(Graphics g) {
		if(velX == 0 && velY == 0) {
			g.drawImage(joueurImage[0], x, y, null);
		} else {
			animation.drawAnimation(g, x, y, 0);
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 48);
	}

}
