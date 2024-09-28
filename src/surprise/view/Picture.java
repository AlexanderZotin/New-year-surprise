package surprise.view;

import surprise.model.Animation;

import javax.swing.JPanel;
import java.awt.Graphics;

public class Picture extends JPanel {
	private final Animation animation;

    public Picture(Runnable repaintAction) {
        animation = new Animation();
		animation.start(repaintAction);
	}
	
    @Override
	public void paintComponent(Graphics g) {
		animation.paint(g);
	}
}