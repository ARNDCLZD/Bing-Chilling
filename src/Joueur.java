import java.awt.*;

public class Joueur extends GameObject{
    private float _acc = 1.5f;
    private float _dcc = 0.5f;
    private float _rotation = 0;
    private Input input;
    public Joueur(int x, int y, ID id, Input input) {
        super(x, y, id);
        this.input = input;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if(input.keys[0]) velX += _acc;
        else if(input.keys[1]) velX -= _acc;
        else if(!input.keys[0] && !input.keys[1]){
            if(velX > 0) velX -= _dcc;
            else if(velX < 0) velX += _dcc;
        }

        if(input.keys[2]) velY -= _acc;
        else if(input.keys[3]) velY += _acc;
        else if(!input.keys[2] && !input.keys[3]){
            if(velY > 0) velY -= _dcc;
            else if(velY < 0) velY += _dcc;
        }

        velX = clamp(velX,5,-5);
        velY = clamp(velY,5,-5);

    }

    private float clamp(float value, float max, float min){
        if(value>max) value=max;
        else if(value<=min) value=min;
        return value;
    }
    /*
    private void rotate(Graphics2D g2d){
        this._rotation+=0.1;
        g2d.rotate(this._rotation,this.x,this.y);
        System.out.println(this._rotation);
    }
    */
    @Override
    public void render(Graphics2D g) {
        //this.rotate(g);
        g.setColor(Color.blue);
        g.fillRect(x,y,32,48);


    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
