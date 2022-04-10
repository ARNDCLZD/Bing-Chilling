import java.awt.*;

public class EnemySpawner extends GameObject {
    public int rate = 6;
    private int timer = 120*rate;
    private int tickCount = 0;
    private Handler handler;
    private Game game;
    public EnemySpawner(int x, int y, ID id, Handler handler, SpriteSheet ss, Game game) {
        super(x, y, id, ss);
        this.handler=handler;
        this.game = game;
    }

    @Override
    public void tick() {
        this.tickCount++;
        updateTimer();
        if(this.tickCount% timer ==0){
            this.handler.addObject(new Enemy(this.x,this.y,ID.Enemy,this.handler, this.ss,this.game));
        }
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(40,40);
    }

    private void updateTimer(){
        this.timer=120*rate;
    }
}
