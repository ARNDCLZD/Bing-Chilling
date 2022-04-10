import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy extends GameObject{

	private Game game;
	private Handler handler;
	Random r = new Random();
	int choose = 0;
	int hp = 100;
	int speed = 1;

	
	private BufferedImage[] enemyImage = new BufferedImage[3];
	Animation animation;
	
	public Enemy(int x, int y, ID id, Handler handler, SpriteSheet ss,Game game) {
		super(x, y, id, ss);
		this.handler = handler;
		this.game = game;
		enemyImage[0] = ss.grabImage(4, 1, 32, 32);
		enemyImage[1] = ss.grabImage(5, 1, 32, 32);
		enemyImage[2] = ss.grabImage(6, 1, 32, 32);
		
		animation = new Animation(3, enemyImage[0], enemyImage[1], enemyImage[2]);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		choose = r.nextInt(10);
		
		for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

			/*
			//Déplacement aléatoire
            if(tempObject.getId() == ID.Block) {
            	if(getBoundsBig().intersects(tempObject.getBounds())) {
            		x += (velX * 4) * -1;
            		y += (velY * 4) * -1;
            		velX *= -1;
            		velY *= -1;
            	} else if(choose == 0) {
        			velX = (r.nextInt(4 - -4) + -4);
        			velY = (r.nextInt(4 - -4) + -4);
        		}
            }
            */
			//Déplacement vers le joueur en ignorant les collisions avec les murs
			if(tempObject.getId()==ID.Player){
				if(((Joueur)(tempObject)).game.hp<1){
					this.velY=0;
					this.velX=0;
				}else{
					if(tempObject.x>this.x) this.velX = 2;
					else this.velX = -2;
					if(tempObject.y>this.y) this.velY = 2;
					else this.velY = -2;
				}
			}
            if(tempObject.getId() == ID.Bullet) {
            	if(getBounds().intersects(tempObject.getBounds())) {
					if(!((Bullet)tempObject).touched.contains(this)) {
						hp -= 50;
						((Bullet) tempObject).touched.add(this);
					}
            		//handler.removeObject(tempObject);
            	}
            }
        }
		animation.runAnimation();
		
		if(hp <= 0) {
			this.game.score+=10;
			int random = r.nextInt(4);
			if(random==2)
				handler.addObject(new AmmoCrate(this.x,this.y,ID.AmmoCrate,this.ss));
			if(random==3)
				handler.addObject(new HealthCrate(this.x,this.y,ID.HealthCrate,this.ss));
			handler.removeObject(this);
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.x-32, this.y-16, (int) (96*(((double)(hp)/100))), 8);
		animation.drawAnimation(g, x, y, 0);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public Rectangle getBoundsBig() {
		return new Rectangle(x-16, y-16, 55, 55);
	}

}
