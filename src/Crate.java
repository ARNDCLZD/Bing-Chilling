import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Crate extends GameObject{
	
	private BufferedImage crateImage;

	public Crate(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		
		crateImage = ss.grabImage(6, 2, 32, 32);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(crateImage, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
