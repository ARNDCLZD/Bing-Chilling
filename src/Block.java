import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Block extends GameObject{
	
	private BufferedImage blockImage;

	public Block(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		
		blockImage = ss.grabImage(5, 2, 32, 32);
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(blockImage, x, y, null);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
