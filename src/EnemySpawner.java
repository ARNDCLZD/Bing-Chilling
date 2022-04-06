import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemySpawner extends GameObject {
    private final int TIMER = 120*6;
    private int tickCount = 0;
    private Handler handler;
    public EnemySpawner(int x, int y, ID id, Handler handler, SpriteSheet ss) {
        super(x, y, id, ss);
        this.handler=handler;
    }

    @Override
    public void tick() {
        this.tickCount++;
        if(this.tickCount%TIMER==0){
            this.handler.addObject(new Enemy(this.x,this.y,ID.Enemy,this.handler, this.ss));
        }
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(40,40);
    }
}
