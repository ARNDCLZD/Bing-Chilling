import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {

	private Handler handler;
	private Camera camera;
	private Game game;
	private SpriteSheet ss;
	
	public MouseInput(Handler handler, Camera camera, Game game, SpriteSheet ss) {
		this.handler = handler;
		this.camera = camera;
		this.game = game;
		this.ss = ss;
	}
	
	public void mousePressed(MouseEvent e) {
		int mouseX = (int) (e.getX() + camera.getX());
		int mouseY = (int) (e.getY() + camera.getY());

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player && game.ammo >= 1) {
				handler.addObject(new Bullet(tempObject.getX()+16, tempObject.getY()+24, ID.Bullet, handler, mouseX, mouseY, ss));
				game.ammo--;
			}
		}
	}
	
}
