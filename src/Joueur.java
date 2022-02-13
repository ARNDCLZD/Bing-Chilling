import java.awt.*;

public class Joueur extends GameObject{
    Handler handler;
    public Joueur(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if(handler.isHaut()) velY = -5;
        else if(!handler.isBas()) velY = 0;

        if(handler.isBas()) velY = 5;
        else if(!handler.isHaut()) velY = 0;

        if(handler.isDroite()) velX = 5;
        else if(!handler.isGauche()) velX = 0;

        if(handler.isGauche()) velX = -5;
        else if(!handler.isDroite()) velX = 0;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,32,48);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
