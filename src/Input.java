import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {
    Handler handler;
    public Input(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                if(key == KeyEvent.VK_Z) handler.setHaut(true);
                if(key == KeyEvent.VK_S) handler.setBas(true);
                if(key == KeyEvent.VK_Q) handler.setGauche(true);
                if(key == KeyEvent.VK_D) handler.setDroite(true);

            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.Player){
                if(key == KeyEvent.VK_Z) handler.setHaut(false);
                if(key == KeyEvent.VK_S) handler.setBas(false);
                if(key == KeyEvent.VK_Q) handler.setGauche(false);
                if(key == KeyEvent.VK_D) handler.setDroite(false);

            }
        }
    }
}
