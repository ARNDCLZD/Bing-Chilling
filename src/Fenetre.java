import javax.swing.*;
import java.awt.*;

public class Fenetre {
    public Fenetre(int largeur, int hauteur, String titre, Game game){
        JFrame frame = new JFrame(titre);

        frame.setPreferredSize(new Dimension(largeur,hauteur));
        frame.setMinimumSize(new Dimension(largeur,hauteur));
        frame.setMaximumSize(new Dimension(largeur,hauteur));
        frame.add(game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
